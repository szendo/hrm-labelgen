package me.sendow.hrm;

import com.google.common.io.BaseEncoding;
import com.google.common.io.LittleEndianDataOutputStream;
import me.sendow.hrm.model.Font;
import me.sendow.hrm.model.Glyph;
import me.sendow.hrm.model.GridType;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.DeflaterOutputStream;

public class LabelBuilder {

    private static final BaseEncoding BASE64_ENCODER = BaseEncoding.base64()
            .withSeparator("\n", 80)
            .omitPadding();

    private final Font font;
    private final GridType grid;

    private int length = 0;
    private final ByteBuffer labelData = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
    private final Caret caret = new Caret();

    public LabelBuilder(Font font, GridType grid) {
        this.font = font;
        this.grid = grid;
    }

    private boolean drawGlyph(Glyph glyph) {
        int[][] parts = glyph.parts;
        int reqInstr = parts.length;
        for (int[] part : parts) {
            reqInstr += part.length / 2;
        }
        // if not enough instructions left to draw glyph, fail
        if (length + reqInstr > 256) {
            return false;
        }

        // if glyph doesn't fit on current line, start new line
        if (caret.advance + glyph.advance > grid.maxAdvance) {
            caret.advance = 0;
            caret.lineNum++;
        }
        // if no more lines left, fail
        if (caret.lineNum > grid.maxLineNum) {
            return false;
        }

        for (int[] part : parts) {
            for (int k = 0; k < part.length; k += 2) {
                labelData.putShort((short) grid.getCanvasX(caret.advance + part[k]));
                labelData.putShort((short) grid.getCanvasY(font.lineHeight * caret.lineNum + part[k + 1]));
            }
            labelData.putShort((short) 0);
            labelData.putShort((short) 0);
        }
        length += reqInstr;
        caret.advance += glyph.advance;

        return true;
    }

    public void drawText(String text) {
        for (int i = 0; i < text.length(); i++) {
            final String chr = text.substring(i, i + 1).toUpperCase();
            final Glyph glyph = font.getGlyph(chr);
            if (!drawGlyph(glyph)) {
                break;
            }
        }
    }

    public String encode() {
        final StringWriter outputWriter = new StringWriter();
        try (final LittleEndianDataOutputStream outputStream = new LittleEndianDataOutputStream(
                new DeflaterOutputStream(BASE64_ENCODER.encodingStream(outputWriter)))) {
            outputStream.writeInt(length);
            outputStream.write(labelData.array());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputWriter.toString() + ";";
    }

    private static class Caret {
        public int advance;
        public int lineNum;
    }

}

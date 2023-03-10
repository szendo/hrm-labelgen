import {useEffect, useRef} from "react";
import {getGlyph, getLineHeight} from "./getGlyph";
import {getGrid} from "./getGrid";
import {GridType} from "./types";

export interface PreviewProps {
    text: string;
    type: GridType;
};
export function Preview({text, type}: PreviewProps) {
    useEffect(() => {
        let canvas = ref.current;
        if (!canvas) return;
        let ctx = canvas.getContext("2d")!;
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();
        ctx.lineWidth = 16;
        ctx.lineCap = "round";
        ctx.lineJoin = "round";

        const lineHeight = getLineHeight();
        const {maxAdvance, maxLineNum, stretch: [sx, sy], offset: [ox, oy]} = getGrid(type);


        let position = 0;
        let lineNum = 0;

        for (const char of text.toUpperCase()) {
            const {advance, parts} = getGlyph(char, type);

            if (position + advance > maxAdvance) {
                position = 0;
                lineNum++;
            }

            if (lineNum > maxLineNum) {
                break;
            }

            for (const part of parts) {
                let first = true;
                for (const [x, y] of part) {
                    let cx = ox + sx * (position + x);
                    let cy = oy + sy * (lineNum * lineHeight + y);
                    if (first) {
                        ctx.moveTo(cx / 65536 * canvas.width, cy / 65536 * canvas.height);
                        first = false;
                    } else {
                        ctx.lineTo(cx / 65536 * canvas.width, cy / 65536 * canvas.height);
                    }
                }
            }
            position += advance;
        }
        ctx.stroke();
    }, [text, type]);
    let ref = useRef<HTMLCanvasElement>(null);
    return <div className="preview">
        <canvas ref={ref} width={1536} height={512} />
    </div>;
}
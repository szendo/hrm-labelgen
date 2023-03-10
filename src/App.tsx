import {Buffer} from "buffer/";
import {deflate} from "pako";
import {useMemo, useState} from 'react';
import {getGlyph, getLineHeight} from "./getGlyph";
import {getGrid} from "./getGrid";
import {Preview} from "./Preview";
import {GridType} from "./types";

function App() {
    const [text, setText] = useState("");
    const [type, setType] = useState(GridType.DEFAULT);

    const result = useMemo(() => {
        if (!text || !text.trim()) return "";

        const lineHeight = getLineHeight();
        const {maxAdvance, maxLineNum, stretch: [sx, sy], offset: [ox, oy]} = getGrid(type);

        const buf = new ArrayBuffer(1028);
        const dataView = new DataView(buf, 4);

        let instrCount = 0;
        let position = 0;
        let lineNum = 0;

        for (const char of text.toUpperCase()) {
            const {advance, parts} = getGlyph(char, type);

            const reqInstr = parts.map(it => it.length).reduce((prev, curr) => prev + curr, parts.length);
            if (instrCount + reqInstr > 256) {
                break;
            }

            if (position + advance > maxAdvance) {
                position = 0;
                lineNum++;
            }

            if (lineNum > maxLineNum) {
                break;
            }

            for (const part of parts) {
                for (const [x, y] of part) {
                    let cx = ox + sx * (position + x);
                    dataView.setUint16(2 * instrCount++, cx, true);
                    let cy = oy + sy * (lineNum * lineHeight + y);
                    dataView.setUint16(2 * instrCount++, cy, true);
                }
                dataView.setUint16(2 * instrCount++, 0, true);
                dataView.setUint16(2 * instrCount++, 0, true);
            }
            position += advance;
        }
        new DataView(buf, 0).setUint32(0, 123, true);

        return Buffer.from(deflate(new Uint8Array(buf)))
            .toString("base64")
            .replace(/=+$/, "")
            .replace(/[A-Za-z\d+/]{80}/g, "$&\n") + ";";
    }, [text, type]);


    return (
        <>
            Supported characters: <code>A-Z 0-9 . , ! ? + - _ ' " #</code><br />
            <label>
                Label/comment text:
                <input
                    name="text"
                    type="text"
                    autoFocus
                    value={text}
                    onChange={e => setText(e.target.value)}
                />
            </label>
            <label>
                Font:
                <select
                    name="type"
                    value={type}
                    onChange={e => setType(e.target.value as GridType)}
                >
                    <option value="DEFAULT">Default (5 chars)</option>
                    <option value="SMALLER">Smaller letters (8 chars × 2 lines)</option>
                    <option value="SZENDO">Szendo (5 chars)</option>
                    <option value="SZENDO_SMALL">Smaller szendo (8 chars × 2 lines)</option>
                </select>
            </label>

            <textarea
                id="result"
                cols={85}
                rows={8}
                style={{resize: "none"}}
                value={result}
                readOnly
                tabIndex={-1}
            ></textarea>

            <Preview text={text} type={type} />

            <button onClick={() => {navigator.clipboard.writeText(result);}}>Copy</button>
        </>
    );
}

export default App;

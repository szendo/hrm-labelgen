export type Glyph = {
    advance: number;
    parts: [number, number][][];
};

export type Font = {
    lineHeight: number;
    glyphMap: Record<string, Glyph>
}

export type GridType = "DEFAULT" | "SMALLER";

export type GridParams = {
    maxAdvance: number;
    maxLineNum: number;
    stretch: [number, number];
    offset: [number, number];
};
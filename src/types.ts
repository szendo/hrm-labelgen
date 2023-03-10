export type Glyph = {
    advance: number;
    parts: [number, number][][];
};

export type Font = {
    lineHeight: number;
    glyphMap: Record<string, Glyph>;
};

export enum GridType {
    SZENDO = "SZENDO",
    SMALL_SZENDO = "SZENDO_SMALL",
    DEFAULT = "DEFAULT",
    SMALL = "SMALLER",
};

export type GridParams = {
    maxAdvance: number;
    maxLineNum: number;
    stretch: [number, number];
    offset: [number, number];
};
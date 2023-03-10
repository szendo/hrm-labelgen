import {GridParams, GridType} from "./types";


const DEFAULT: GridParams = {
    maxAdvance: 40,
    maxLineNum: 0,
    stretch: [0x666, 0x1999],
    offset: [0x666, 0x1999],
};

const SMALLER: GridParams = {
    maxAdvance: 64,
    maxLineNum: 1,
    stretch: [1024, 2730],
    offset: [1024, 5460],
};

export const getGrid = (t: GridType): Readonly<GridParams> => {
    switch (t) {
        case GridType.SMALL:
        case GridType.SMALL_SZENDO:
            return SMALLER;
        case GridType.DEFAULT:
        case GridType.SZENDO:
            return DEFAULT;
        default:
            throw new Error(`Unknown grid type: ${t}`);
    }
};

package me.sendow.hrm.model;

public enum GridType {
    DEFAULT(40, 0, 0x666, 0x1999),
    SMALLER(64, 1, 1024, 2730, 1024, 5460);

    public final int maxAdvance, maxLineNum;
    private final int stretchX, stretchY, offsetX, offsetY;

    GridType(int maxAdvance, int maxLineNum, int stretchX, int stretchY) {
        this.maxAdvance = maxAdvance;
        this.maxLineNum = maxLineNum;
        this.stretchX = this.offsetX = stretchX;
        this.stretchY = this.offsetY = stretchY;
    }

    GridType(int maxAdvance, int maxLineNum, int stretchX, int stretchY, int offsetX, int offsetY) {
        this.maxAdvance = maxAdvance;
        this.maxLineNum = maxLineNum;
        this.stretchX = stretchX;
        this.stretchY = stretchY;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public int getCanvasX(int x) {
        return stretchX * x + offsetX;
    }

    public int getCanvasY(int y) {
        return stretchY * y + offsetY;
    }

    public static GridType byName(String type) {
        try {
            return GridType.valueOf(type);
        } catch (IllegalArgumentException e) {
            return GridType.DEFAULT;
        }
    }

}

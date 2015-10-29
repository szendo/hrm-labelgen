package me.sendow.hrm.model;

public class Glyph {
    public final int advance;
    public final int[][] parts;

    public Glyph(int advance, int[][] parts) {
        this.advance = advance;
        this.parts = parts;
    }
}

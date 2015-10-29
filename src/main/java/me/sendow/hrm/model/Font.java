package me.sendow.hrm.model;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Font {

    public final int lineHeight;
    private final Map<String, Glyph> glyphMap;

    private Font(int lineHeight, Map<String, Glyph> glyphMap) {
        this.lineHeight = lineHeight;
        this.glyphMap = glyphMap;
    }

    public Glyph getGlyph(String key) {
        if (glyphMap.containsKey(key)) {
            return glyphMap.get(key);
        } else {
            return glyphMap.get("\0");
        }
    }

    public static Font DEFAULT = new Font(12, ImmutableMap.<String, Glyph>builder()
            .put("A", new Glyph(8, new int[][]{
                    {0, 8, 0, 2, 2, 0, 4, 0, 6, 2, 6, 8, 6, 4, 0, 4},
            }))
            .put("B", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 4, 0, 6, 2, 4, 4, 0, 4, 4, 4, 6, 6, 4, 8, 0, 8},
            }))
            .put("C", new Glyph(8, new int[][]{
                    {6, 2, 4, 0, 2, 0, 0, 2, 0, 6, 2, 8, 4, 8, 6, 6},
            }))
            .put("D", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 4, 0, 6, 2, 6, 6, 4, 8, 0, 8},
            }))
            .put("E", new Glyph(8, new int[][]{
                    {6, 0, 0, 0, 0, 4, 4, 4, 0, 4, 0, 8, 6, 8},
            }))
            .put("F", new Glyph(8, new int[][]{
                    {6, 0, 0, 0, 0, 4, 4, 4, 0, 4, 0, 8},
            }))
            .put("G", new Glyph(8, new int[][]{
                    {6, 2, 4, 0, 2, 0, 0, 2, 0, 6, 2, 8, 4, 8, 6, 6, 6, 4, 4, 4},
            }))
            .put("H", new Glyph(8, new int[][]{
                    {0, 0, 0, 8, 0, 4, 6, 4, 6, 0, 6, 8},
            }))
            .put("I", new Glyph(8, new int[][]{
                    {0, 8, 6, 8, 3, 8, 3, 0, 6, 0, 0, 0},
            }))
            .put("J", new Glyph(8, new int[][]{
                    {0, 0, 6, 0, 6, 6, 4, 8, 2, 8, 0, 6},
                    //{4, 4, 6, 4},
            }))
            .put("K", new Glyph(8, new int[][]{
                    {0, 0, 0, 8, 0, 4, 4, 4, 6, 8},
                    {2, 4, 6, 0},
            }))
            .put("L", new Glyph(8, new int[][]{
                    {0, 0, 0, 8, 6, 8},
            }))
            .put("M", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 3, 4, 6, 0, 6, 8},
            }))
            .put("N", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 6, 8, 6, 0},
            }))
            .put("O", new Glyph(8, new int[][]{
                    {2, 0, 4, 0, 6, 2, 6, 6, 4, 8, 2, 8, 0, 6, 0, 2, 2, 0},
            }))
            .put("P", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 4, 0, 6, 2, 4, 4, 0, 4},
            }))
            .put("Q", new Glyph(8, new int[][]{
                    {2, 0, 4, 0, 6, 2, 6, 6, 4, 8, 2, 8, 0, 6, 0, 2, 2, 0},
                    {4, 6, 6, 8},
            }))
            .put("R", new Glyph(8, new int[][]{
                    {0, 8, 0, 0, 4, 0, 6, 2, 4, 4, 0, 4, 4, 4, 6, 8},
            }))
            .put("S", new Glyph(8, new int[][]{
                    {6, 2, 5, 0, 1, 0, 0, 2, 1, 4, 5, 4, 6, 6, 5, 8, 1, 8, 0, 6},
            }))
            .put("T", new Glyph(8, new int[][]{
                    {0, 0, 6, 0, 3, 0, 3, 8},
            }))
            .put("U", new Glyph(8, new int[][]{
                    {0, 0, 0, 6, 2, 8, 4, 8, 6, 6, 6, 0},
            }))
            .put("V", new Glyph(8, new int[][]{
                    {0, 0, 3, 8, 6, 0},
            }))
            .put("W", new Glyph(8, new int[][]{
                    {0, 0, 1, 8, 3, 4, 5, 8, 6, 0},
            }))
            .put("X", new Glyph(8, new int[][]{
                    {0, 0, 6, 8},
                    {0, 8, 6, 0},
            }))
            .put("Y", new Glyph(8, new int[][]{
                    {0, 0, 3, 4, 3, 8, 3, 4, 6, 0},
            }))
            .put("Z", new Glyph(8, new int[][]{
                    {0, 0, 6, 0, 0, 8, 6, 8},
                    {1, 4, 5, 4},
            }))
            .put(".", new Glyph(8, new int[][]{
                    {3, 8},
            }))
            .put(",", new Glyph(8, new int[][]{
                    {3, 6, 2, 8},
            }))
            .put("!", new Glyph(8, new int[][]{
                    {3, 0, 3, 6},
                    {3, 8},
            }))
            .put("?", new Glyph(8, new int[][]{
                    {0, 2, 1, 0, 5, 0, 6, 2, 5, 4, 3, 4, 3, 6},
                    {3, 8},
            }))
            .put("0", new Glyph(8, new int[][]{
                    {1, 0, 5, 0, 6, 2, 6, 6, 5, 8, 1, 8, 0, 6, 0, 2, 1, 0},
                    {4, 2, 2, 6},
            }))
            .put("1", new Glyph(8, new int[][]{
                    {0, 2, 3, 0, 3, 8, 1, 8, 5, 8},
            }))
            .put("2", new Glyph(8, new int[][]{
                    {0, 2, 1, 0, 5, 0, 6, 2, 5, 4, 0, 6, 0, 8, 6, 8},
            }))
            .put("3", new Glyph(8, new int[][]{
                    {0, 2, 1, 0, 5, 0, 6, 2, 5, 4, 3, 4, 5, 4, 6, 6, 5, 8, 1, 8, 0, 6},
            }))
            .put("4", new Glyph(8, new int[][]{
                    {4, 8, 4, 0, 0, 6, 6, 6},
            }))
            .put("5", new Glyph(8, new int[][]{
                    {6, 0, 0, 0, 1, 4, 5, 4, 6, 6, 5, 8, 1, 8, 0, 6},
            }))
            .put("6", new Glyph(8, new int[][]{
                    {6, 2, 5, 0, 1, 0, 0, 2, 0, 6, 1, 8, 5, 8, 6, 6, 5, 4, 1, 4, 0, 6},
            }))
            .put("7", new Glyph(8, new int[][]{
                    {0, 0, 6, 0, 1, 8},
                    {2, 4, 5, 4},
            }))
            .put("8", new Glyph(8, new int[][]{
                    {1, 4, 0, 2, 1, 0, 5, 0, 6, 2, 5, 4, 1, 4, 0, 6, 1, 8, 5, 8, 6, 6, 5, 4},
            }))
            .put("9", new Glyph(8, new int[][]{
                    {6, 2, 5, 0, 1, 0, 0, 2, 1, 4, 5, 4, 6, 2, 6, 6, 5, 8, 1, 8, 0, 6},
            }))
            .put("+", new Glyph(8, new int[][]{
                    {1, 4, 5, 4},
                    {3, 2, 3, 6},
            }))
            .put("-", new Glyph(8, new int[][]{
                    {1, 4, 5, 4},
            }))
            .put("_", new Glyph(8, new int[][]{
                    {0, 8, 6, 8},
            }))
            .put("'", new Glyph(8, new int[][]{
                    {3, 0, 3, 2},
            }))
            .put("\"", new Glyph(8, new int[][]{
                    {2, 0, 2, 2},
                    {4, 0, 4, 2},
            }))
            .put("#", new Glyph(8, new int[][]{
                    {2, 0, 1, 8},
                    {5, 0, 4, 8},
                    {0, 2, 6, 2},
                    {0, 6, 6, 6},
            }))
            .put("*", new Glyph(4, new int[][]{
                    {0, 3, 2, 5},
                    {2, 3, 0, 5},
            }))
            .put("/", new Glyph(8, new int[][]{
                    {1, 8, 5, 0},
            }))
            .put("<", new Glyph(8, new int[][]{
                    {6, 2, 0, 4, 6, 6},
            }))
            .put(">", new Glyph(8, new int[][]{
                    {0, 2, 6, 4, 0, 6},
            }))
            .put("(", new Glyph(4, new int[][]{
                    {2, 0, 0, 2, 0, 6, 2, 8},
            }))
            .put(")", new Glyph(4, new int[][]{
                    {0, 0, 2, 2, 2, 6, 0, 8},
            }))
            .put("=", new Glyph(8, new int[][]{
                    {0, 3, 6, 3},
                    {0, 5, 6, 5},
            }))
            .put(" ", new Glyph(8, new int[][]{}))
            .put("\0", new Glyph(8, new int[][]{
                    {0, 0, 6, 0, 6, 8, 0, 8, 0, 0, 6, 8},
                    {6, 0, 0, 8},
            }))
            .build());

}

package com.mengcraft.scoreboard;

/**
 * Created on 16-5-16.
 */
public class TextLine implements Line {

    public static final Line BLANK = new TextLine("§r ");

    private final String text;

    private TextLine(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static Line of(String text) {
        if (text == null || text.equals("")) {
            return BLANK;
        }
        return new TextLine(text);
    }

}

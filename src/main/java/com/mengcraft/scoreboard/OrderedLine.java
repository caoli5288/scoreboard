package com.mengcraft.scoreboard;

import java.util.List;

/**
 * Created on 16-5-17.
 */
public class OrderedLine extends ListedLine {

    private int cursor;

    protected OrderedLine(List<String> list) {
        super(list);
    }

    @Override
    public String getText() {
        if (cursor < getFrameList().size()) {
            return getFrameList().get(cursor++);
        }
        return getFrameList().get(reset(0));
    }

    private int reset(int cursor) {
        this.cursor = cursor;
        return cursor;
    }

    public static OrderedLine of(List<String> list) {
        return new OrderedLine(list);
    }

}

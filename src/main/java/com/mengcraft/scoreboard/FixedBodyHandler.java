package com.mengcraft.scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-5-18.
 */
public abstract class FixedBodyHandler implements Body {

    private List<Line> list;
    private int blank;

    @Override
    public List<LinePair> getList() {
        list = new ArrayList<>();
        blank = 0x0;
        update();
        return FixedBody.getFixedList(list);
    }

    protected void append(Line line) {
        list.add(line);
    }

    protected void append() {
        StringBuilder b = new StringBuilder();
        int j = blank++;
        for (int i = 0; i < j; i++) {
            b.append("§r");
        }
        append(b.toString());
    }

    protected void append(String line) {
        list.add(TextLine.of(line));
    }

    protected abstract void update();

}

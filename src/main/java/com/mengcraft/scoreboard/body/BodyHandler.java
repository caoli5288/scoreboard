package com.mengcraft.scoreboard.body;

import com.mengcraft.scoreboard.Line;
import com.mengcraft.scoreboard.LinePair;
import com.mengcraft.scoreboard.TextLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-5-18.
 */
public abstract class BodyHandler implements Body {

    private List<LinePair> list;

    @Override
    public List<LinePair> getList() {
        list = new ArrayList<>();
        update();
        return list;
    }

    protected void append(LinePair pair) {
        list.add(pair);
    }

    protected void append(Line line, int score) {
        list.add(LinePair.of(line, score));
    }

    protected void append(String line, int score) {
        list.add(LinePair.of(TextLine.of(line), score));
    }

    protected abstract void update();

}

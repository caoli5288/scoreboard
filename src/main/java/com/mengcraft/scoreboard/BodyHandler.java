package com.mengcraft.scoreboard;

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

    protected abstract void update();

}

package com.mengcraft.scoreboard.body;

import com.google.common.collect.ImmutableList;
import com.mengcraft.scoreboard.LinePair;

import java.util.List;

/**
 * Created on 16-8-18.
 */
public class EmptyBody implements Body {

    public final static EmptyBody INSTANCE = new EmptyBody();

    private EmptyBody() {
    }

    @Override
    public List<LinePair> getList() {
        return ImmutableList.of();
    }

}

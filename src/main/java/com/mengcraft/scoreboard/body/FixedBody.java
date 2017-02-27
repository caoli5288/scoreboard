package com.mengcraft.scoreboard.body;

import com.google.common.collect.ImmutableList;
import com.mengcraft.scoreboard.Line;
import com.mengcraft.scoreboard.LineListBuilder;
import com.mengcraft.scoreboard.LinePair;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created on 16-5-17.
 */
public class FixedBody implements Body {

    private final LineListBuilder builder;

    private FixedBody(LineListBuilder builder) {
        this.builder = builder;
    }

    public static List<LinePair> getFixedList(List<Line> list) {
        int size = list.size();
        ImmutableList.Builder<LinePair> b = ImmutableList.builder();
        for (Line line : list) {
            b.add(LinePair.of(line, size--));
        }
        return b.build();
    }

    @Override
    public List<LinePair> getList() {
        return getFixedList(builder.build());
    }

    public static FixedBody of(Line... list) {
        return of(asList(list));
    }

    public static FixedBody of(List<Line> list) {
        return of(() -> list);
    }

    public static FixedBody of(LineListBuilder builder) {
        return new FixedBody(builder);
    }

}

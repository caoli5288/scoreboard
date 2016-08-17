package com.mengcraft.scoreboard.body;

import com.mengcraft.scoreboard.Line;
import com.mengcraft.scoreboard.LineListFactory;
import com.mengcraft.scoreboard.LinePair;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created on 16-5-17.
 */
public class FixedBody implements Body {

    private final LineListFactory factory;

    private FixedBody(LineListFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<LinePair> getList() {
        return getFixedList(factory.getList());
    }

    public static List<LinePair> getFixedList(List<Line> list) {
        int size = list.size();
        List<LinePair> output = new ArrayList<>(size);
        for (Line line : list) {
            output.add(LinePair.of(line, size--));
        }
        return output;
    }

    public static FixedBody of(LineListFactory factory) {
        return new FixedBody(factory);
    }

    public static FixedBody of(List<Line> list) {
        return new FixedBody(() -> list);
    }

    public static FixedBody of(Line... list) {
        return new FixedBody(() -> asList(list));
    }

}

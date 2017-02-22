package com.mengcraft.scoreboard;

import com.google.common.base.Preconditions;

/**
 * Created on 17-2-22.
 */
public class MixedLine implements Line {

    private final Line[] handle;

    private MixedLine(Line[] handle) {
        this.handle = handle;
    }

    @Override
    public String getText() {
        StringBuilder b = new StringBuilder();
        for (Line line : handle) {
            b.append(line.getText());
        }
        return b.toString();
    }

    public static Line of(Line... i) {
        Preconditions.checkArgument(i.length > 0, "zero length");
        return new MixedLine(i);
    }

}

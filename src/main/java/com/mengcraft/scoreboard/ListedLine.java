package com.mengcraft.scoreboard;

import com.mengcraft.scoreboard.Line;

import java.util.List;

/**
 * Created on 16-5-17.
 */
public abstract class ListedLine implements Line {

    private final List<String> frameList;

    public ListedLine(List<String> frameList) {
        this.frameList = frameList;
    }

    public List<String> getFrameList() {
        return frameList;
    }

}

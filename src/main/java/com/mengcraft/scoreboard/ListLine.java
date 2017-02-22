package com.mengcraft.scoreboard;

import com.mengcraft.scoreboard.board.Board;

import java.util.Iterator;
import java.util.List;

/**
 * Created on 16-5-17.
 */
public class ListLine implements Line {

    private final List<String> list;
    private Iterator<String> i;

    private ListLine(List<String> list) {
        this.list = list;
    }

    @Override
    public String getText() {
        if (Board.nil(i) || !i.hasNext()) {
            i = list.iterator();
        }
        return i.next();
    }

    @Override
    public String toString() {
        return "ListLine(" + list.toString() + ")";
    }

    public static Line of(List<String> handle) {
        return new ListLine(handle);
    }

}

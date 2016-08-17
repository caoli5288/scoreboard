package com.mengcraft.scoreboard;

import com.mengcraft.scoreboard.board.Board;

import java.util.Iterator;
import java.util.List;

/**
 * Created on 16-5-17.
 */
public class ListedLine implements Line {

    private final List<String> list;
    private Iterator<String> it;

    public ListedLine(List<String> list) {
        this.list = list;
    }

    @Override
    public String getText() {
        if (Board.eq(it, null) || !it.hasNext()) {
            it = list.iterator();
        }
        return it.next();
    }

    public List<String> getList() {
        return list;
    }

}

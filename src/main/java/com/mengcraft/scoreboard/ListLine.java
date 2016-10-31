package com.mengcraft.scoreboard;

import com.google.common.collect.ImmutableList;
import com.mengcraft.scoreboard.board.Board;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 16-5-17.
 */
public class ListLine implements Line {

    private final List<String> list;
    private Iterator<String> it;

    private ListLine(List<String> list) {
        this.list = list;
    }

    @Override
    public String getText() {
        if (Board.nil(it) || !it.hasNext()) {
            it = list.iterator();
        }
        return it.next();
    }

    @Override
    public String toString() {
        return "ListLine(" + list.toString() + ")";
    }

    public static Line build(List<String> in) {
        return new ListLine(in);
    }

    public static Line buildLooped(String text, int blank) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < blank; i++) {
            list.add(blank(i) + text + blank(blank - i));
        }
        for (int i = blank; i > 0; i--) {
            list.add(blank(i) + text + blank(blank - i));
        }
        return new ListLine(list);
    }

    public static Line buildLighted(String text, ChatColor base, ChatColor lighted) {
        String striped = ChatColor.stripColor(text);
        int len = striped.length();
        if (len == 0) throw new IllegalArgumentException();
        ImmutableList.Builder<String> b = ImmutableList.builder();
        b.add(base + striped);
        for (int i = 0; i < len; ) {
            StringBuilder l = new StringBuilder();
            if (i > 0) {
                l.append(base);
                l.append(text.substring(0, i));
            }
            l.append(lighted);
            l.append(text.charAt(i));
            if (++i < len) {
                l.append(base);
                l.append(text.substring(i));
            }
            b.add(l.toString());
        }
        return new ListLine(b.build());
    }

    private static String blank(int i) {
        char[] a = new char[i];
        for (int j = 0; j < i; j++)
            a[i] = ' ';
        return new String(a);
    }

}

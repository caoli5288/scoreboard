package com.mengcraft.scoreboard;

import com.google.common.collect.ImmutableList;
import org.bukkit.ChatColor;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created on 17-2-22.
 */
public final class LineFactory {

    private static final char[] MAGIC = "0123456789abcdef".toCharArray();
    private static final char COLOR_CHAR = '§';

    private LineFactory() {
        throw new IllegalStateException("new");
    }

    public static Line looped(String text, int blank) {
        ImmutableList.Builder<String> b = ImmutableList.builder();
        for (int i = 0; i < blank; i++) {
            b.add(blank(i) + text + blank(blank - i));
        }
        for (int i = blank; i > 0; i--) {
            b.add(blank(i) + text + blank(blank - i));
        }
        return ListLine.of(b.build());
    }

    public static Line lighted(String input, ChatColor base, ChatColor lighted) {
        String line = ChatColor.stripColor(input);
        int len = line.length();
        checkArgument(len > 0);
        ImmutableList.Builder<String> b = ImmutableList.builder();
        b.add(base + line);
        for (int i = 0; i < len; ) {
            StringBuilder l = new StringBuilder();
            if (i > 0) {
                l.append(base);
                l.append(line.substring(0, i));
            }
            l.append(lighted);
            l.append(line.charAt(i));
            if (++i < len) {
                l.append(base);
                l.append(line.substring(i));
            }
            b.add(l.toString());
        }
        return ListLine.of(b.build());
    }

    public static Line magic(String input, int dep) {
        checkArgument(dep > 1);
        char[] line = ChatColor.stripColor(input).toCharArray();
        int len = line.length;
        checkArgument(len > 0);
        ImmutableList.Builder<String> r = ImmutableList.builder();
        Random rand = ThreadLocalRandom.current();
        for (int i = 0; i < dep; i++) {
            StringBuilder b = new StringBuilder();
            for (char l : line) {
                b.append(COLOR_CHAR).append(MAGIC[rand.nextInt(16)]).append(l);
            }
            r.add(b.toString());
        }
        return ListLine.of(r.build());
    }

    private static String blank(int i) {
        char[] l = new char[i];
        for (int j = 0; j < i; j++)
            l[i] = ' ';
        return new String(l);
    }

}

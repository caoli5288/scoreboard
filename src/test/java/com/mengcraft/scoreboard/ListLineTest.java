package com.mengcraft.scoreboard;

import org.bukkit.ChatColor;
import org.junit.Test;

/**
 * Created on 16-10-31.
 */
public class ListLineTest {
    @Test
    public void buildLighted() throws Exception {
        Line line = ListLine.buildLighted("测试文本", ChatColor.RED, ChatColor.GOLD);
        System.out.println(line);
    }

}
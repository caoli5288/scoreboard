package com.mengcraft.scoreboard;

import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.List;

/**
 * Created on 16-5-17.
 */
public class SidebarBoard extends Board {

    private Objective objective;
    private Body body;
    private Line head;

    private SidebarBoard(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void update() {
        if (objective != null) {
            objective.unregister();
        }
        objective = getBoard().registerNewObjective("board", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        if (head != null) {
            objective.setDisplayName(head.getText());
        }

        List<LinePair> list = body.getList();
        for (LinePair pair : list) {
            objective.getScore(pair.getText()).setScore(pair.getScore());
        }
    }

    public void setHead(Line head) {
        this.head = head;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static SidebarBoard of(Plugin plugin) {
        return new SidebarBoard(plugin);
    }

}

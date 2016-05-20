package com.mengcraft.scoreboard;

import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

/**
 * Created on 16-5-17.
 */
public class SidebarBoard extends Board {

    private Objective objective;
    private Body body;
    private Line head;
    private int count;

    private SidebarBoard(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void update() {
        Objective objective1 = objective;

        objective = getBoard().registerNewObjective("board-" + count++, "dummy");
        if (head != null) {
            objective.setDisplayName(head.getText());
        }

        for (LinePair pair : body.getList()) {
            objective.getScore(pair.getText()).setScore(pair.getScore());
        }

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        if (objective1 != null) {
            objective1.unregister(); // To prevent sidebar screen flash.
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

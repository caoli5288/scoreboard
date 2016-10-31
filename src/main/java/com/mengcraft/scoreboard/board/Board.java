package com.mengcraft.scoreboard.board;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Created on 16-5-16.
 */
public abstract class Board {

    protected final Scoreboard scoreboard;

    protected Board(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public Objective getObjectiveOf(DisplaySlot slot) {
        Objective objective = scoreboard.getObjective(slot);
        if (nil(objective)) {
            objective = scoreboard.registerNewObjective("board", "dummy");
            objective.setDisplaySlot(slot);
        }
        return objective;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public static boolean nil(Object i) {
        return i == null;
    }

    public static Scoreboard getScoreboardOf(Player p) {
        Scoreboard scoreboard = p.getScoreboard();
        if (scoreboard == p.getServer().getScoreboardManager().getMainScoreboard()) {
            scoreboard = p.getServer().getScoreboardManager().getNewScoreboard();
            p.setScoreboard(scoreboard);
        }
        return scoreboard;
    }

    public abstract void update();

}

package com.mengcraft.scoreboard.board;

import com.mengcraft.scoreboard.Line;
import com.mengcraft.scoreboard.LinePair;
import com.mengcraft.scoreboard.body.Body;
import com.mengcraft.scoreboard.body.EmptyBody;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-5-17.
 */
public class SidebarBoard extends TimedBoard {

    private final Objective objective;
    private Body body;
    private Line head;
    private List<String> bodyText;

    private SidebarBoard(Plugin plugin, Scoreboard scoreboard) {
        super(plugin, scoreboard);
        objective = getObjectiveOf(DisplaySlot.SIDEBAR);
    }

    @Override
    public void update() {
        String headText = head == null ? null : head.getText();

        if (!objective.getDisplayName().equals(headText)) {
            objective.setDisplayName(headText);
        }

        List<String> bodyText1 = bodyText;

        bodyText = new ArrayList<>();

        if (bodyText1 == null) {
            for (LinePair pair : body == null ? EmptyBody.INSTANCE.getList() : body.getList()) {
                String line = pair.getText();
                bodyText.add(line);
                objective.getScore(line).setScore(pair.getScore());
            }
        } else {
            for (LinePair pair : body == null ? EmptyBody.INSTANCE.getList() : body.getList()) {
                String line = pair.getText();
                bodyText1.remove(line);
                bodyText.add(line);
                objective.getScore(line).setScore(pair.getScore());
            }
            bodyText1.forEach(i -> scoreboard.resetScores(i));
        }
    }

    public void setHead(Line head) {
        this.head = head;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static SidebarBoard of(Plugin plugin) {
        return new SidebarBoard(plugin, plugin.getServer().getScoreboardManager().getNewScoreboard());
    }

    public static SidebarBoard of(Plugin plugin, Player p) {
        return of(plugin, Board.getScoreboardOf(p));
    }

    public static SidebarBoard of(Plugin plugin, Scoreboard scoreboard) {
        return new SidebarBoard(plugin, scoreboard);
    }

}

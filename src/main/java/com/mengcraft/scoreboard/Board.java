package com.mengcraft.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Created on 16-5-16.
 */
public abstract class Board {

    private final Plugin plugin;
    private int taskId;
    private Scoreboard board;

    public Board(Plugin plugin) {
        this.plugin = plugin;
    }

    public <T> void update(Condition condition, int interval) {
        if (taskId == 0) {
            taskId = plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
                if (condition.get()) {
                    update();
                } else {
                    cancel();
                }
            }, 0, interval).getTaskId();
        }
    }

    public abstract void update();

    public void update(Player p) {
        p.setScoreboard(getBoard());
    }

    public void cancel() {
        if (taskId != 0) {
            plugin.getServer().getScheduler().cancelTask(taskId);
        }
    }

    public Scoreboard getBoard() {
        if (board == null) {
            board = plugin.getServer().getScoreboardManager().getNewScoreboard();
        }
        return board;
    }

    public Plugin getPlugin() {
        return plugin;
    }

}

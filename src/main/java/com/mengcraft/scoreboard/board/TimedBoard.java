package com.mengcraft.scoreboard.board;

import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.function.Supplier;

/**
 * Created on 16-8-18.
 */
public abstract class TimedBoard extends Board {

    private final Plugin plugin;
    private int taskId;

    protected TimedBoard(Plugin plugin, Scoreboard scoreboard) {
        super(scoreboard);
        this.plugin = plugin;
    }

    /**
     * @param condition update this board if {@code true} or cancelled task in other wish
     * @param interval  update interval by server tick
     */
    public void update(Supplier<Boolean> condition, int interval) {
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

    /**
     * Cancel the timer board update task.
     */
    public void cancel() {
        if (taskId != 0) {
            plugin.getServer().getScheduler().cancelTask(taskId);
        }
    }

}

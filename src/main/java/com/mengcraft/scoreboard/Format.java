package com.mengcraft.scoreboard;

import org.bukkit.ChatColor;

import static com.mengcraft.scoreboard.Main.eq;
import static org.bukkit.ChatColor.RESET;

/**
 * Created on 16-5-18.
 */
public class Format {

    private String format;
    private String colour;

    private String getFormat() {
        if (format == null) {
            return "";
        }
        return format;
    }

    private String getColour() {
        if (colour == null) {
            return "";
        }
        return colour;
    }

    public String get() {
        if (format == null && colour == null) {
            return "§r";
        }
        return getFormat() + getColour();
    }

    public void set(ChatColor in) {
        if (eq(in, RESET)) {
            format = null;
            colour = null;
        } else if (in.isFormat()) {
            format = in.toString();
        } else if (in.isColor()) {
            colour = in.toString();
        }
    }

}

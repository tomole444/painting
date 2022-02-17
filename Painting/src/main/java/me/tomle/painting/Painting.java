package me.tomle.painting;

import me.tomle.painting.commands.PaintCommand;
import me.tomle.painting.commands.PaintbrushCommand;
import me.tomle.painting.listeners.Paint;
import org.bukkit.plugin.java.JavaPlugin;

public final class Painting extends JavaPlugin {
    public static Painting plugin;
    public String color = "black";
    public int radius = 2;


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        //register the commands and listeners
        getCommand("paintbrush").setExecutor(new PaintbrushCommand());
        getCommand("paint").setExecutor(new PaintCommand());
        getServer().getPluginManager().registerEvents(new Paint(), this);
        System.out.println("Painting Plugin successfully loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Painting getInstance() {
        return plugin;
    }
}

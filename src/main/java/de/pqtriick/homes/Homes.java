package de.pqtriick.homes;

import de.pqtriick.homes.commands.admin.CheckHomes;
import de.pqtriick.homes.commands.player.Homecommand;
import de.pqtriick.homes.commands.player.testin;
import de.pqtriick.homes.files.Config;
import de.pqtriick.homes.listener.initalizer.JoinConfig;
import de.pqtriick.homes.listener.inventory.DeleteHome;
import de.pqtriick.homes.listener.inventory.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Homes extends JavaPlugin {

    public static Homes instance;

    @Override
    public void onEnable() {
        instance = this;
        Config.createDir();

        Bukkit.getPluginManager().registerEvents(new JoinConfig(), this);
        Bukkit.getPluginManager().registerEvents(new DeleteHome(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        this.getCommand("testin").setExecutor(new testin());
        this.getCommand("homes").setExecutor(new Homecommand());
        this.getCommand("checkhomes").setExecutor(new CheckHomes());
        //Particle Navigation
        //Jump to home
        //Delete home
        //add home
        //Admin all homes view



    }

    @Override
    public void onDisable() {

    }

    public static Homes getInstance() {
        return instance;
    }
}

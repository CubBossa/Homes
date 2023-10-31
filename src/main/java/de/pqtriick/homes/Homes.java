package de.pqtriick.homes;

import de.pqtriick.homes.commands.admin.CheckHomes;
import de.pqtriick.homes.commands.admin.ReloadValues;
import de.pqtriick.homes.commands.player.AddHome;
import de.pqtriick.homes.commands.player.Homecommand;
import de.pqtriick.homes.files.Config;
import de.pqtriick.homes.files.Messages;
import de.pqtriick.homes.files.Options;
import de.pqtriick.homes.listener.compass.NavigationScheduler;
import de.pqtriick.homes.listener.initalizer.JoinConfig;
import de.pqtriick.homes.listener.initalizer.VersionInform;
import de.pqtriick.homes.listener.inventory.ActionInventory;
import de.pqtriick.homes.listener.inventory.AdminInventory;
import de.pqtriick.homes.listener.inventory.DeleteInventory;
import de.pqtriick.homes.listener.inventory.MainInventoryClick;
import de.pqtriick.homes.utils.Update.VersionCheck;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

public final class Homes extends JavaPlugin {

    public static Homes instance;
    public static boolean hasUpdate;

    @Override
    public void onEnable() {
        instance = this;
        Config.createDir();
        Messages.initMessageFile();
        Options.initOptionsFile();

        Bukkit.getPluginManager().registerEvents(new JoinConfig(), this);
        Bukkit.getPluginManager().registerEvents(new MainInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new DeleteInventory(), this);
        Bukkit.getPluginManager().registerEvents(new ActionInventory(), this);
        Bukkit.getPluginManager().registerEvents(new VersionInform(), this);
        Bukkit.getPluginManager().registerEvents(new AdminInventory(), this);

        this.getCommand("addhome").setExecutor(new AddHome());
        this.getCommand("homes").setExecutor(new Homecommand());
        this.getCommand("checkhomes").setExecutor(new CheckHomes());
        this.getCommand("reloadvalues").setExecutor(new ReloadValues());
        NavigationScheduler.startScheduler();

        checkUpdate();



    }

    @Override
    public void onDisable() {

    }

    public static Homes getInstance() {
        return instance;
    }

    public boolean checkUpdate() {
        new VersionCheck(this, 112984).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                hasUpdate = false;
            } else {
                hasUpdate = true;
            }
        });
        return hasUpdate;
    }
}

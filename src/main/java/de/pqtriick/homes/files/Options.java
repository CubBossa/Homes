package de.pqtriick.homes.files;

import de.pqtriick.homes.Homes;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * @author pqtriick_
 * @created 15:54, 31.10.2023
 */

public class Options {

    public static File optionsfile = new File(Homes.getInstance().getDataFolder().getPath(), "options.yml");
    public static FileConfiguration optionsconfig = YamlConfiguration.loadConfiguration(optionsfile);

    public static void initOptionsFile() {
        if (!optionsfile.exists()) {
            Config.createFile(optionsfile);
            optionsconfig.set("options.particle.enabled", "true");
            optionsconfig.set("options.particle.particle", "FLAME");
            optionsconfig.set("options.particle.delay", "10");
            optionsconfig.set("options.particle.info","//All Available Particles: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html");
            Config.saveFile(optionsconfig, optionsfile);


        }
    }

}

package gigaclubessentials.gigaclubessentials;

import gigaclubessentials.gigaclubessentials.commands.flyspeed;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);

        System.out.println("Initalized plugin");

        setBasicConfig();

        Objects.requireNonNull(getCommand("flyspeed")).setExecutor(new flyspeed());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getPlugin().saveConfig();
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    private void setBasicConfig() {
        if(getPlugin().getConfig().getString("flyspeed-enable-message") == null) {
            getPlugin().getConfig().set("flyspeed-enable-message", "§aDein FlySpeed wurde auf §6%s §agesetzt!");
        }
        if(getPlugin().getConfig().getString("flyspeed-to-small") == null) {
            getPlugin().getConfig().set("flyspeed-to-small", "§cDie Zahl darf nicht kleiner als 0 sein!");
        }
        if(getPlugin().getConfig().getString("flyspeed-to-high") == null) {
            getPlugin().getConfig().set("flyspeed-to-high", "§cDie Zahl darf nicht größer als 10 sein!");
        }
        if(getPlugin().getConfig().getString("flyspeed-need-int") == null) {
            getPlugin().getConfig().set("flyspeed-need-int", "§cBitte gebe eine Zahl als Argument an!");
        }
        if(getPlugin().getConfig().getString("flyspeed-wrong-message") == null) {
            getPlugin().getConfig().set("flyspeed-wrong-message", "§cDer Command heißt /flyspeed [0-10]");
        }
        if(getPlugin().getConfig().getString("flyspeed-no-perms") == null) {
            getPlugin().getConfig().set("flyspeed-no-perms", "§cDu hast keine Rechte für diesen Befehl!");
        }

        getPlugin().saveConfig();

        System.out.println("Set config files");

    }

}

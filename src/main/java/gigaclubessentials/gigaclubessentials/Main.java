package gigaclubessentials.gigaclubessentials;

import gigaclubessentials.gigaclubessentials.commands.flyspeed;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GigaClubEssentials extends JavaPlugin {

    private static GigaClubEssentials plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);
        setBasicConfig();

        Objects.requireNonNull(getCommand("flyspeed")).setExecutor(new flyspeed());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GigaClubEssentials getPlugin() {
        return plugin;
    }

    public static void setPlugin(GigaClubEssentials plugin) {
        GigaClubEssentials.plugin = plugin;
    }

    private void setBasicConfig() {
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-enable-message"), "")) {
            getPlugin().getConfig().set("flyspeed-enable-message", "§aDein FlySpeed wurde auf §6%s §agesetzt!");
        }
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-to-small"), "")) {
            getPlugin().getConfig().set("flyspeed-to-small", "§cDie Zahl darf nicht kleiner als 0 sein!");
        }
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-to-high"), "")) {
            getPlugin().getConfig().set("flyspeed-to-high", "§cDie Zahl darf nicht größer als 10 sein!");
        }
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-need-int"), "")) {
            getPlugin().getConfig().set("flyspeed-need-int", "§cBitte gebe eine Zahl als Argument an!");
        }
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-wrong-message"), "")) {
            getPlugin().getConfig().set("flyspeed-wrong-message", "§cDer Command heißt /flyspeed [0-10]");
        }
        if(Objects.equals(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-no-perms"), "")) {
            getPlugin().getConfig().set("flyspeed-no-perms", "§cDu hast keine Rechte für diesen Befehl!");
        }

    }

}

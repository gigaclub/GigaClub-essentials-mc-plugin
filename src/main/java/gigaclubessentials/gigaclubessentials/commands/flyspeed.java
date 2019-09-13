package gigaclubessentials.gigaclubessentials.commands;

import gigaclubessentials.gigaclubessentials.Main;
import gigaclubessentials.gigaclubessentials.checks.isInteger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class flyspeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (sender.hasPermission("GCE.flyspeed")) {
            if(args.length == 1) {
                if(isInteger.isInteger(args[0])) {
                    int flySpeedInfo = Integer.parseInt(args[0]);
                    float flySpeed = Float.parseFloat(args[0]) / 10;
                    if(flySpeedInfo <= 10) {
                        if(flySpeedInfo >= 0) {
                            player.setFlySpeed(flySpeed);
                            sender.sendMessage(String.format(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-enable-message")), flySpeedInfo));
                        } else {
                            sender.sendMessage(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-to-small")));
                        }
                    } else {
                        sender.sendMessage(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-to-high")));
                    }
                } else {
                    sender.sendMessage(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-need-int")));
                }
            } else {
                sender.sendMessage(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-wrong-message")));
            }
        } else {
            sender.sendMessage(Objects.requireNonNull(Main.getPlugin().getConfig().getString("flyspeed-no-perms")));
        }
        return false;
    }
}

package gigaclubessentials.gigaclubessentials.commands;

import gigaclubessentials.gigaclubessentials.checks.isInteger;
import gigaclubessentials.gigaclubessentials.GigaClubEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyspeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (sender.hasPermission("GCE.flyspeed")) {
            if(args.length == 1) {
                if(isInteger.isInteger(args[0])) {
                    int flySpeed = Integer.parseInt(args[0]);
                    if(flySpeed > 10) {
                        if(flySpeed < 0) {
                            player.setFlySpeed(flySpeed);
                            sender.sendMessage(String.format(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-enable-message"), flySpeed));
                        } else {
                            sender.sendMessage(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-to-small"));
                        }
                    } else {
                        sender.sendMessage(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-to-high"));
                    }
                } else {
                    sender.sendMessage(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-need-int"));
                }
            } else {
                sender.sendMessage(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-wrong-message"));
            }
        } else {
            sender.sendMessage(GigaClubEssentials.getPlugin().getConfig().getString("flyspeed-no-perms"));
        }
        return false;
    }
}

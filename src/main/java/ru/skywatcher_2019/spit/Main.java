package ru.skywatcher_2019.spit;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandExecutor {

  @Override
  public void onEnable() {
    getCommand("spit").setExecutor(this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      Location playerLocation = player.getLocation();
      Location location = playerLocation.toVector().add(playerLocation.getDirection().multiply(0.8)).toLocation(player.getWorld()).add(0.0, 1.0, 0.0);
      Entity spit = player.getWorld().spawnEntity(location, EntityType.LLAMA_SPIT);
      spit.setVelocity(player.getEyeLocation().getDirection().multiply(1));
    } else {
      sender.sendMessage("Command only for players");
    }
    return true;
  }
}

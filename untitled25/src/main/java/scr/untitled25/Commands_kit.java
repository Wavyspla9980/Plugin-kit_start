package scr.untitled25;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Commands_kit implements CommandExecutor {
    HashMap<Player,Long> coldawn = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return  false;
        Player player = (Player) commandSender;

        if (coldawn.containsKey(player)){
            long time = System.currentTimeMillis() - coldawn.get(player);

            if (time < 100000){
                player.sendMessage(" time " + (100000-time)/100 + "s");
                return  false;
            }
        }

        Inventory inventory = player.getInventory();

        inventory.addItem(new ItemStack(Material.ACACIA_WOOD,30));
        inventory.addItem(new ItemStack(Material.IRON_AXE));
        inventory.addItem(new ItemStack(Material.IRON_INGOT,3));
        inventory.addItem(new ItemStack(Material.COAL,20));
        inventory.addItem(new ItemStack(Material.FURNACE));
        inventory.addItem(new ItemStack(Material.BLACK_BED));
        coldawn.put(player,System.currentTimeMillis());
        return false;
    }
}

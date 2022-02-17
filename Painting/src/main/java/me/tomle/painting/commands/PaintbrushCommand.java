package me.tomle.painting.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PaintbrushCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("painting.paint_brush")) {
                Inventory inv = p.getInventory();
                ItemStack pbrush = new ItemStack(Material.STICK);
                ItemMeta meta = pbrush.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "PAINTBRUSH");
                ArrayList<String> lore = new ArrayList<>();
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Hold right-click to paint");
                lore.add(" ");
                meta.setLore(lore);
                pbrush.setItemMeta(meta);

                inv.addItem(pbrush);
            }else{
                p.sendMessage(ChatColor.RED + "You don't have the permission \"painting.paint_brush\"");
            }
        }else{
            System.out.println("You must be a Player to execute commands");
        }

        return true;
    }
}

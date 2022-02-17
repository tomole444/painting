package me.tomle.painting.listeners;

import me.tomle.painting.Painting;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Paint implements Listener {
    public void replaceBlockradius(Block b, Integer r, Player p, Material material){
        Double akr = 0.0;
        Integer bx = b.getX(), by = b.getY(), bz = b.getZ(), x = b.getX(), y = b.getY(), z = b.getZ();

        for (x = 0; x <= r; x++){
            for (y = 0; y <= r; y++){
                for (z = 0; z <= r; z++){
                    akr =  Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
                    if(akr <= r){
                        Block nb = b.getRelative(x,y,z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(-x,-y,-z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(x,-y,-z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(-x,y,-z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(-x,-y,z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(x,y,-z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(x,-y,z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                        nb = b.getRelative(-x,y,z);
                        if(nb.getType() != Material.AIR)
                            nb.setType(material);
                    }

                }
            }
        }
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemStack item = e.getItem();
        Player p = (Player) e.getPlayer();
        try{
            ItemMeta meta = item.getItemMeta();
            if(meta.getDisplayName().equals(ChatColor.RED + "PAINTBRUSH") && p.hasPermission("painting.paint")){
                Material material = Material.YELLOW_CONCRETE;

                switch(Painting.getInstance().color){
                    case "green": material = Material.LIME_CONCRETE; break;
                    case "yellow": material = Material.YELLOW_CONCRETE; break;
                    case "black": material = Material.BLACK_CONCRETE;break;
                    case "blue": material = Material.BLUE_CONCRETE;break;
                    case "white": material = Material.WHITE_CONCRETE;break;
                    case "red": material = Material.RED_CONCRETE;break;
                    case "purple": material = Material.PURPLE_CONCRETE;break;
                    default: material = Material.BLACK_CONCRETE;break;
                }

                Block block = p.getTargetBlockExact(500);
                block.setType(material);
                replaceBlockradius(block, Painting.getInstance().radius,p, material);
            }
        }catch (Exception exe){
        }
    }
}

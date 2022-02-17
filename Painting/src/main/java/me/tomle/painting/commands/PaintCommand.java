package me.tomle.painting.commands;

import me.tomle.painting.Painting;
import me.tomle.painting.listeners.Paint;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;


public class PaintCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            try{
                Painting.getInstance().color = strings[0].toLowerCase();
                Painting.getInstance().radius = Integer.parseInt(strings[1]);
            }catch (Exception ex){
                p.sendMessage("You didn't enter a valid number");
            }

        }else{
            System.out.println("You must be a Player to execute commands");
        }

        return true;
    }
}

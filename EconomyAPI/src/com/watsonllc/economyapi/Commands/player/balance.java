package com.watsonllc.economyapi.Commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Utils.managers.MessageManager;

public class balance implements CommandExecutor {

	public String command() {
		return "balance";
	}
	
	public String permission() {
		return "economy.balance";
	}
	
	public String syntax() {
		return "/balance";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) return false;
		
		if(cmd.getName().equalsIgnoreCase(command()) && player.hasPermission(permission())) {
			if(args.length != 0) player.sendMessage(syntax());
			MessageManager.sendBalance(player);
		}
		return false;
	}
}
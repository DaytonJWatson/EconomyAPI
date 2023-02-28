package com.watsonllc.economyapi.Commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Config.Bank;
import com.watsonllc.economyapi.Utils.managers.MessageManager;

public class setbalance implements CommandExecutor {

	public String command() {
		return "setbalance";
	}
	
	public String permission() {
		return "economy.setbalance";
	}
	
	public String syntax() {
		return "/setbalance <amount> <player>";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) return false;
		
		if(cmd.getName().equalsIgnoreCase(command()) && player.hasPermission(permission())) {
			if(args.length == 0) {
				player.sendMessage(syntax());
			}
			
			if(args.length == 1) {
				Bank.setBalance(player, Integer.parseInt(args[0]));
				MessageManager.setBalance(player);
			}
		}
		return false;
	}
}
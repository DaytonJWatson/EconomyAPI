package com.watsonllc.economyapi.Commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Utils.managers.BankManager;
import com.watsonllc.economyapi.Utils.managers.MessageManager;

public class createaccount implements CommandExecutor {

	public String command() {
		return "createaccount";
	}
	
	public String permission() {
		return "economy.createaccount";
	}
	
	public String syntax() {
		return "/createaccount";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) return false;
		
		if(cmd.getName().equalsIgnoreCase(command()) && player.hasPermission(permission())) {
			if(args.length == 0) {
				BankManager.createAccount(player, 0);
				MessageManager.createAccount(player);
			}
			
			if(args.length == 1) {
				BankManager.createAccount(player, Integer.parseInt(args[0]));
				MessageManager.createAccountAmount(player);
			}
		}
		return false;
	}
}
package com.watsonllc.economyapi.Utils.managers;

import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Config.Bank;
import com.watsonllc.economyapi.Config.Messages;
import com.watsonllc.economyapi.Utils.Utils;

public class MessageManager {
	static Player player;
	
	public static String placeholder(String path) {
		String string = Messages.messages.getString(path);
		string = string.replace("%player%", player.getName());
		string = string.replace("%balance%", String.valueOf(Bank.getBalance(player)));
		return Utils.chat(string);
	}
	
	public static void createAccountAmount(Player player) {
		Bank.reload(false);
		MessageManager.player = player;
		player.sendMessage(placeholder("createAccountAmount"));
	}
	
	public static void createAccount(Player player) {
		MessageManager.player = player;
		player.sendMessage(placeholder("createAccount"));
	}
	
	public static void sendBalance(Player player) {
		Bank.reload(false);
		MessageManager.player = player;
		player.sendMessage(placeholder("sendBalance"));
	}
	
	public static void setBalance(Player player) {
		Bank.reload(false);
		MessageManager.player = player;
		player.sendMessage(placeholder("setBalance"));
	}
}

package com.watsonllc.economyapi.Utils.managers;

import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Config.Bank;

public class BankManager {
	static Player player;
	static String dataPath;
	
	public static boolean accountNull(Player player) {
		dataPath = dataPath + player.getUniqueId().toString();
		Bank.reload(false);
		if(Bank.bank.getString(dataPath) == null) { 
			return false;
		} else return true;
	}
	
	public static boolean overdraftCheck(Player player, double amount) {
		Bank.reload(false);
		BankManager.player = player;
		if(accountNull(player)) return false;
		if(Bank.getBalance(player) > amount) return false;
		if(Bank.getBalance(player) == amount) return false;
		if(Bank.getBalance(player) < amount) return true;
		return false;
	}
	
	public static void createAccount(Player player, double amount) {
		BankManager.player = player;
		dataPath = "BANK." + player.getUniqueId().toString();
		if(!accountNull(player)) return;
		
		Bank.set(dataPath	+ ".user", player.getName());
		Bank.set(dataPath + ".balance", amount);
	}
}
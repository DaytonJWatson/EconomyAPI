package com.watsonllc.economyapi.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.watsonllc.economyapi.Economy;
import com.watsonllc.economyapi.Utils.Utils;
import com.watsonllc.economyapi.Utils.managers.BankManager;

public class Bank {
	public static File bankFile = new File(Economy.instance.getDataFolder(), "bank.yml");
	public static YamlConfiguration bank = YamlConfiguration.loadConfiguration(bankFile);

	static String dataPath = "BANK.";
	static String creating;
	static String saving;
	static String reloading;
	static String failed;

	public static void create() {
		creating = "Creating 'bank.yml'...";
		failed = "Failed to save 'bank.yml'!";

		if (!bankFile.exists()) {
			Economy.warning(creating);
			save(false);
		}
	}

	public static void save(boolean announce) {
		saving = "Saving 'bank.yml'...";
		failed = "Failed to save 'bank.yml'!";

		try {
			if (announce == true)
				Economy.warning(saving);
			bank.save(bankFile);
		} catch (IOException e) {
			Economy.warning(failed);
		}
	}
	
	public static void reload(boolean announce) {
		reloading = "Reloading 'bank.yml'...";
		failed = "Failed to reload 'bank.yml'!";
		
		try {
			if(announce == true) Economy.warning(reloading);
			bank.load(bankFile);
		} catch (IOException | InvalidConfigurationException e) {
			Economy.warning(failed);
		}
	}

	public static int getInt(String path) {
		return bank.getInt(path);
	}

	public static String getString(String path) {
		return Utils.chat(bank.getString(path));
	}

	public static void set(String path, Object object) {
		bank.set(path, object);
		save(false);
	}
	
	// api portion of plugin
	
	public static double getBalance(Player player) {
		dataPath = dataPath + player.getUniqueId().toString();
		if(BankManager.accountNull(player)) return 999;
		return Bank.getInt(dataPath + ".balance");
	}
	
	public static void clearBalance(Player player) {
		dataPath = dataPath + player.getUniqueId().toString();
		if(BankManager.accountNull(player)) return; // do something here
		set(dataPath + ".balance", 0);
	}
	
	public static void setBalance(Player player, double amount) {
		dataPath = dataPath + player.getUniqueId().toString();
		if(BankManager.accountNull(player)) return; // do something here
		set(dataPath + ".balance", amount);
	}
	
	public static void addToBalance(Player player, double amount) {
		dataPath = dataPath + player.getUniqueId().toString();
		double current;
		current = getBalance(player);
		if(BankManager.accountNull(player)) return; // do something here
		set(dataPath + ".balance", amount+current);
	}
	
	public static void deductFromBalance(Player player, double amount) {
		dataPath = dataPath + player.getUniqueId().toString();
		double current;
		current = getBalance(player);
		if(BankManager.accountNull(player)) return;
		if(BankManager.overdraftCheck(player, amount)) return;
		set(dataPath + ".balance", amount-current);
	}
}

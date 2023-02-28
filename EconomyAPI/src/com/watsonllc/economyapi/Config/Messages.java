package com.watsonllc.economyapi.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.watsonllc.economyapi.Economy;

public class Messages {
	public static File messagesFile = new File(Economy.instance.getDataFolder(), "messages.yml");
	public static YamlConfiguration messages = YamlConfiguration.loadConfiguration(messagesFile);
	
	static String creating;
	static String saving;
	static String failed;
	
	public static void create() {
		creating = "Creating 'messages.yml'...";
		failed = "Failed to save 'messages.yml'!";

		if (!messagesFile.exists()) {
			addDefaults();
			Economy.warning(creating);
			save(false);
		}
	}

	public static void save(boolean announce) {
		saving = "Saving 'messages.yml'...";
		failed = "Failed to save 'messages.yml'!";

		try {
			if (announce == true)
				Economy.warning(saving);
			messages.save(messagesFile);
		} catch (IOException e) {
			Economy.warning(failed);
		}
	}
	
	public static void addDefaults() {
		
		set("createAccount", "&7You created a new account!");
		set("createAccountAmount", "&7You created a new account with amount: %balance%");
		set("setBalance", "&7You set your balance to: %balance%");
		set("sendBalance", "&7Your balance is currently: %balance%");
	}
	
	public static void set(String path, Object object) {
		messages.set(path, object);
	}
}

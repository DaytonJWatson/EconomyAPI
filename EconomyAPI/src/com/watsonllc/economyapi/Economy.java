package com.watsonllc.economyapi;

import org.bukkit.plugin.java.JavaPlugin;

import com.watsonllc.economyapi.Commands.Commands;
import com.watsonllc.economyapi.Config.Config;
import com.watsonllc.economyapi.Events.Events;

public class Economy extends JavaPlugin {

	public static Economy instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Commands.setup();
		Config.setup();
		Events.setup();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static void warning(String string) {
		instance.getLogger().warning(string);
	}
}

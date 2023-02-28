package com.watsonllc.economyapi.Events;

import org.bukkit.plugin.PluginManager;

import com.watsonllc.economyapi.Economy;
import com.watsonllc.economyapi.Events.player.Join;
import com.watsonllc.economyapi.Events.player.Quit;

public class Events {
	public static void setup() {
		PluginManager pm = Economy.instance.getServer().getPluginManager();
		
		pm.registerEvents(new Join(), Economy.instance);
		pm.registerEvents(new Quit(), Economy.instance);
	}
}

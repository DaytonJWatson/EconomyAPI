package com.watsonllc.economyapi.Events.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.watsonllc.economyapi.Config.Bank;

public class Quit implements Listener {
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Bank.reload(false);
	}
}

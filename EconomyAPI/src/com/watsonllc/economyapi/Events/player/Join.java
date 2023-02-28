package com.watsonllc.economyapi.Events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.watsonllc.economyapi.Config.Bank;
import com.watsonllc.economyapi.Utils.managers.BankManager;

public class Join implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		Bank.reload(false);
		BankManager.createAccount(player, 50.00);
		
	}
}
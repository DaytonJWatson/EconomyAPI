package com.watsonllc.economyapi.Commands;

import com.watsonllc.economyapi.Economy;
import com.watsonllc.economyapi.Commands.player.balance;

public class Commands {
	public static void setup() {
		Economy.instance.getCommand("balance").setExecutor(new balance());
		Economy.instance.getCommand("createaccount").setExecutor(new balance());
		Economy.instance.getCommand("setbalance").setExecutor(new balance());
		
	}
}

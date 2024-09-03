package com.spring.dao;

import java.util.List;

import com.spring.model.Player;

public interface PlayerDAO {
	
	public List<Player> getPlayers();
	
	public void addPlayers(Player player);// odd or update 
	
	public Player getPlayer(int id);  // to get clicked player from db to update
	
	public void removePlayer(int id);
}

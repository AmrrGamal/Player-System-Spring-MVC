package com.spring.service;

import java.util.List;

import com.spring.model.Player;

public interface PlayerService {

	public List<Player> allPlayers();
	
	public void savePlayer(Player player);// save or update 
	
	public Player showPlayer(int id); // to display player before edit it 
	
	public void deletePlayer(int id);
}

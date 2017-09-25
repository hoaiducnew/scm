package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Player;

public interface PlayerService {

	List<Player> getAllPlayer();
	Player getPlayer(Long playerId);
	void addPlayer(Player player);
	void deletePlayer(Long playerId);
	void editPlayer(Player player);
}

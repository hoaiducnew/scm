package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Player;
import edu.mum.scm.domain.Team;

public interface PlayerService {

	List<Player> getAllPlayer(Team team);
	Player getPlayer(Long playerId);
	void addPlayer(Player player);
	void deletePlayer(Long playerId);
	void editPlayer(Player player);
	Player getPlayerByPlayerId(String value);
}

package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Player;
import edu.mum.scm.domain.Position;
import edu.mum.scm.domain.Team;

public interface PlayerService {

	List<Player> getAllPlayer(Team team);
	Player getPlayer(Long playerId);
	void createPlayer(Player player);
	void deletePlayer(Long playerId);
	void editPlayer(Player player);
	List<Position> getAllPositions();
	Position getPosition(Long positionId);
}

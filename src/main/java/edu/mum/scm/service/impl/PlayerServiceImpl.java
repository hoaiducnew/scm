package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Player;
import edu.mum.scm.domain.Team;
import edu.mum.scm.repository.PlayerRepository;
import edu.mum.scm.service.PlayerService;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	// check Id again
	public Player getPlayer(Long playerId) {
		return playerRepository.findOne(playerId);
	}
	
	public Player getPlayerByPlayerId(String playerId) {
		return playerRepository.getPlayerByPlayerId(playerId);
	}
	
	public void addPlayer(Player player) {
		playerRepository.save(player);
	}
	
	public void deletePlayer(Long playerId) {
		playerRepository.delete(playerId);
	}
	
	public void editPlayer(Player player) {
		Player playerTobeUpdated = playerRepository.findOne(player.getId());
		playerTobeUpdated.setBiography(player.getBiography());
		playerTobeUpdated.setBirthday(player.getBirthday());
		playerTobeUpdated.setFirstName(player.getFirstName());
		playerTobeUpdated.setLastName(player.getLastName());
		playerTobeUpdated.setPlayerPosition(player.getPlayerPosition());
		playerTobeUpdated.setSalary(player.getSalary());
	}

	@Override
	public List<Player> getAllPlayer(Team team) {
		return playerRepository.findByTeam(team);
	}
}

package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Player;
import edu.mum.scm.domain.Position;
import edu.mum.scm.domain.Team;
import edu.mum.scm.repository.PlayerRepository;
import edu.mum.scm.repository.PositionRepository;
import edu.mum.scm.service.PlayerService;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PositionRepository positionRepository;
	
	public List<Player> getAllPlayer(Team team){
		return playerRepository.findByTeam(team);
	}
	
	// check Id again
	public Player getPlayer(Long playerId) {
		return playerRepository.findOne(playerId);
	}
	
	public void createPlayer(Player player) {
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
		playerTobeUpdated.setPlayerId(player.getPlayerId());
		playerTobeUpdated.setPosition(player.getPosition());
		playerTobeUpdated.setSalary(player.getSalary());
	}

	@Override
	public List<Position> getAllPositions() {
		return (List<Position>) positionRepository.findAll();
	}

	@Override
	public Position getPosition(Long positionId) {
		return positionRepository.findOne(positionId);
	}
}

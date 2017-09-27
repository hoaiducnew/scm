package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Team;
import edu.mum.scm.repository.TeamRepository;
import edu.mum.scm.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public List<Team> getAll() {
		return (List<Team>) teamRepository.findAll();
	}

	@Override
	public Team getById(Long id) {
		return teamRepository.findOne(id);
	}

}

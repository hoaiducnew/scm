package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Team;

public interface TeamService {
	public Team save(Team team);
	
	public Team getById(Long id);
	
	
	public List<Team> getAll();
}

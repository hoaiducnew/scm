package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	Team getTeamByName(String name);
}

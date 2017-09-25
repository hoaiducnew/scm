package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{

}

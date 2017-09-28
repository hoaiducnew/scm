package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{
	
		//List<Player> findByTeam(Team team);

		@Query("SELECT p FROM Player p where p.playerId = :playerId")
		Player getPlayerByPlayerId(@Param("playerId") String id);
}

package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.FanClub;

@Repository
public interface FanclubRepository extends CrudRepository<FanClub, Long>{
	@Query("select f from Fanclub f where f.name= :name")
	FanClub findFanClubByName(@Param("name") String name);
}

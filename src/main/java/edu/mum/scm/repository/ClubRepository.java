package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Club;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {
	
	@Query("select c from Club c where c.name = :name")
	Club findClubByName(@Param("name") String name);

}

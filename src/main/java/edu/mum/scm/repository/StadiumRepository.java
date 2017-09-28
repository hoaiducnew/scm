package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Stadium;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
	@Query("select s from Stadium s where s.name = :name")
	Stadium getStadiumByName(@Param("name") String name);
}

package edu.mum.scm.repository;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Stadium;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {

}

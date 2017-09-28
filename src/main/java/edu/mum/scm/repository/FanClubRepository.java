package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.FanClub;

@Repository
public interface FanClubRepository extends CrudRepository<FanClub, Long>{

}

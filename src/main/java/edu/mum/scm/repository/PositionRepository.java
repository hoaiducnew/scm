package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>{
}

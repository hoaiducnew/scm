package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Equipment;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long>{

}

package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long>{
		@Query("SELECT p FROM Manager p where p.managerId = :managerId")
		Manager getManagerByManagerId(@Param("managerId") String id);
}

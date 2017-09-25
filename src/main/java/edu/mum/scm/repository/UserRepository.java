package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User getUserByUsername(String username);
}

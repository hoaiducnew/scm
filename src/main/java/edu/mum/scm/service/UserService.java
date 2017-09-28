package edu.mum.scm.service;

import edu.mum.scm.domain.User;

public interface UserService {
	User save(User user);
	User getUserByUsername(String username);
}

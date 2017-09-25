package edu.mum.scm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Credentials;

@Repository
public interface CredentialsDao extends JpaRepository<Credentials, Long> {
	public Credentials getCredentialsByUsername(String username);
}

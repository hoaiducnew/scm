package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
	public Credentials getCredentialsByUsername(String username);
}

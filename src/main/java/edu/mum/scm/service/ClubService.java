package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Club;

public interface ClubService {
	public List<Club> getAllClubs();
	public void addClub(Club club);
	public void editClub(Club club);
	public void deleteClub(Club club);
	public Club getClubByName(String name);
	
}

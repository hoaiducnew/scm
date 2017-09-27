package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.FanClub;

public interface FanclubService {
	public List<FanClub> getAllFanClub();
	public void addFanClub(FanClub fanClub);
	public void deleteFanClub(FanClub fanClub);
	public void editFanclub(FanClub fanClub);
	public FanClub getFanClubByName(String name);
}

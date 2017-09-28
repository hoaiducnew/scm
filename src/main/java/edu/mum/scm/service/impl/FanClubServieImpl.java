package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.FanClub;
import edu.mum.scm.service.FanclubService;

@Service
@Transactional
public class FanClubServieImpl implements FanclubService {

	@Override
	public List<FanClub> getAllFanClub() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFanClub(FanClub fanClub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFanClub(FanClub fanClub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editFanclub(FanClub fanClub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FanClub getFanClubByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

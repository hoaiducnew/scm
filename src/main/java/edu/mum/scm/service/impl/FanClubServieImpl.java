package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.FanClub;
import edu.mum.scm.repository.FanclubRepository;
import edu.mum.scm.service.FanclubService;

@Service
@Transactional
public class FanClubServieImpl implements FanclubService {
	
	@Autowired
	FanclubRepository fanclubRepo;

	@Override
	public List<FanClub> getAllFanClub() {
		// TODO Auto-generated method stub
		return (List<FanClub>) fanclubRepo.findAll();
	}

	@Override
	public void addFanClub(FanClub fanClub) {
		// TODO Auto-generated method stub
		fanclubRepo.save(fanClub);
	}

	@Override
	public void deleteFanClub(FanClub fanClub) {
		// TODO Auto-generated method stub
		fanclubRepo.delete(fanClub);
	}

	@Override
	public void editFanclub(FanClub fanClub) {
		// TODO Auto-generated method stub
		FanClub fanclubEdit = fanclubRepo.findOne(fanClub.getId());
		fanclubEdit.setName(fanClub.getName());
		fanclubEdit.setDescription(fanClub.getDescription());
		fanclubEdit.setEmail(fanClub.getEmail());
		fanclubEdit.setLeader(fanClub.getLeader());
		fanclubEdit.setNumberOfMembers(fanClub.getNumberOfMembers());
		fanclubEdit.setPhone(fanClub.getPhone());
	}

	@Override
	public FanClub getFanClubByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FanClub getFanClubById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

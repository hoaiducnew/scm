package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.FanClub;
import edu.mum.scm.repository.FanClubRepository;
import edu.mum.scm.service.FanClubService;

@Service
@Transactional
public class FanClubServiceImpl implements FanClubService {

	@Autowired
	FanClubRepository fanClubRepository;

	@Override
	public List<FanClub> getAllFanClub() {
		return (List<FanClub>) fanClubRepository.findAll();
	}

	@Override
	public void addFanClub(FanClub fanClub) {
		fanClubRepository.save(fanClub);
	}

	@Override
	public void deleteFanClub(FanClub fanClub) {
		fanClubRepository.delete(fanClub);
	}

	@Override
	public void editFanclub(FanClub fanClub) {
		FanClub fanclubEdit = fanClubRepository.findOne(fanClub.getId());
		fanclubEdit.setName(fanClub.getName());
		fanclubEdit.setDescription(fanClub.getDescription());
		fanclubEdit.setEmail(fanClub.getEmail());
		fanclubEdit.setLeader(fanClub.getLeader());
		fanclubEdit.setNumberOfMembers(fanClub.getNumberOfMembers());
		fanclubEdit.setPhone(fanClub.getPhone());
	}

	@Override
	public FanClub getFanClubByName(String name) {
		return null;
	}

	@Override
	public FanClub getFanClubById(Long id) {
		return fanClubRepository.findOne(id);
	}

}

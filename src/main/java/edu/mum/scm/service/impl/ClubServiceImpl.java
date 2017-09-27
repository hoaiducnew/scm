package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Club;
import edu.mum.scm.repository.ClubRepository;
import edu.mum.scm.service.ClubService;

@Service
@Transactional
public class ClubServiceImpl implements ClubService{
	
	@Autowired
	ClubRepository clubRepository;

	@Override
	public List<Club> getAllClubs() {
		// TODO Auto-generated method stub
		return (List<Club>) clubRepository.findAll();
	}

	@Override
	public void addClub(Club club) {
		// TODO Auto-generated method stub
		clubRepository.save(club);
	}

	@Override
	public void editClub(Club club) {
		// TODO Auto-generated method stub
		Club clubToUpdate = clubRepository.findOne(club.getId());
		clubToUpdate.setAddress(club.getAddress());
		clubToUpdate.setChairman(club.getChairman());
		clubToUpdate.setName(club.getName());
	
	}

	@Override
	public void deleteClub(Club club) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Club getClubByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Stadium;
import edu.mum.scm.repository.StadiumRepository;
import edu.mum.scm.service.StadiumService;

@Service
@Transactional
public class StadiumServiceImpl implements StadiumService {
	@Autowired
	StadiumRepository stadiumRepo;

	@Override
	public List<Stadium> getAllStadium() {
		// TODO Auto-generated method stub
		return (List<Stadium>) stadiumRepo.findAll();
	}

	@Override
	public void addStadium(Stadium stadium) {
		// TODO Auto-generated method stub
		stadiumRepo.save(stadium);
	}

	@Override
	public void deleteStadium(Stadium stadium) {
		// TODO Auto-generated method stub
		stadiumRepo.delete(stadium);
		
	}

	@Override
	public void editStadium(Stadium stadium) {
		// TODO Auto-generated method stub
		Stadium stadiumUpdated = stadiumRepo.findOne(stadium.getId());
		stadiumUpdated.setName(stadium.getName());
		stadiumUpdated.setCapacity(stadium.getCapacity());
		stadiumUpdated.setDescription(stadium.getDescription());
		stadiumUpdated.setImagePath(stadium.getImagePath());
	}

	@Override
	public Stadium getStadiumByName(String name) {
		// TODO Auto-generated method stub
		return stadiumRepo.getStadiumByName(name);
	}

	@Override
	public Stadium getStadiumById(Long Id) {
		// TODO Auto-generated method stub
		return stadiumRepo.findOne(Id);
	}

}

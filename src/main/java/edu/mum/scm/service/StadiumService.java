package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Stadium;

public interface StadiumService {
	public List<Stadium> getAllStadium();
	public void addStadium(Stadium stadium);
	public void deleteStadium(Stadium stadium);
	public void editStadium(Stadium stadium);
	public Stadium getStadiumByName(String name);
	public Stadium getStadiumById(Long id);
}

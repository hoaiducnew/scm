package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Stadium;

public interface StadiumService {
	public List<Stadium> getAllStadium();
	public void addStadium(Stadium Stadium);
	public void deleteStadium(Stadium Stadium);
	public void editStadium(Stadium Stadium);
	public Stadium getStadiumByName(String name);
}

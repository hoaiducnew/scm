package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Equipment;

public interface EquipmentService {
	public List<Equipment> getAllEquipment();
	public void addEquipment(Equipment Equipment);
	public void deleteEquipment(Equipment Equipment);
	public void editEquipment(Equipment Equipment);
	public Equipment getEquipmentByName(String name);
}

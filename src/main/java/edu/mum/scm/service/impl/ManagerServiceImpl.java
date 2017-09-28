package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Manager;
import edu.mum.scm.repository.ManagerRepository;
import edu.mum.scm.service.ManagerService;


@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository ManagerRepository;
	
	public List<Manager> getAllManager(){
		return (List<Manager>) ManagerRepository.findAll();
	}
	
	// check Id again
	public Manager getManager(Long ManagerId) {
		return ManagerRepository.findOne(ManagerId);
	}
	
	public Manager getManagerByManagerId(String ManagerId) {
		return ManagerRepository.getManagerByManagerId(ManagerId);
	}
	
	public void addManager(Manager Manager) {
		ManagerRepository.save(Manager);
	}
	
	public void deleteManager(Long ManagerId) {
		ManagerRepository.delete(ManagerId);
	}
	
	public void editManager(Manager Manager) {
		Manager ManagerTobeUpdated = ManagerRepository.findOne(Manager.getId());
		ManagerTobeUpdated.setBiography(Manager.getBiography());
		ManagerTobeUpdated.setBirthday(Manager.getBirthday());
		ManagerTobeUpdated.setFirstName(Manager.getFirstName());
		ManagerTobeUpdated.setLastName(Manager.getLastName());
		ManagerTobeUpdated.setSalary(Manager.getSalary());
	}
}

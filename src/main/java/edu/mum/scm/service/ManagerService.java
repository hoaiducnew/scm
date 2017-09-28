package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Manager;

public interface ManagerService {

	List<Manager> getAllManager();
	Manager getManager(Long ManagerId);
	void addManager(Manager Manager);
	void deleteManager(Long ManagerId);
	void editManager(Manager Manager);
	Manager getManagerByManagerId(String value);
}

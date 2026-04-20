package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		Optional<Manager> manager = managerRepo.findById(managerId);
		if (manager.isEmpty()) {
			return null;
		} else {
			return manager.get();
		}
	}

	public List<Manager> fetchAllManagers() {
		return managerRepo.findAll();
	}

	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		saveManager(newManager);
		return newManager;
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}
}

package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.ManagerDao;
import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.exception.ManagerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;

	@Autowired
	ResponseStructure<Manager> responseStructure;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		responseStructure.setMessage("Successfully manager created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setMessage("Successfully manager fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public List<Manager> fetchAllManagers() {
		return managerDao.fetchAllManagers();
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(int oldManagerId, Manager newManager) {
		responseStructure.setMessage("Successfully manager updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setMessage("Successfully manager deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

}

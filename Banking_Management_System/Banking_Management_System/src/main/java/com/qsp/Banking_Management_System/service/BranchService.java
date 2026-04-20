package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.BranchDao;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.exception.BranchIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("Successfully Branch created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully branch fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public List<Branch> fetchAllBranchs() {
		return branchDao.fetchAllBranchs();
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		responseStructure.setMessage("Successfully branch updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully branch deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public Branch addExistingAddressToExistingBranch(int addresId, int branchId) {
		return branchDao.addExistingAddressToExistingBranch(branchId, addresId);
	}

	public Branch addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		return branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}

	public Branch addNewEmployeeToExistingBranch(Employee newEmployee, int branchId) {
		return branchDao.addNewEmployeeToExistingBranch(newEmployee, branchId);
	}

	public Branch addExistingCustomerToExistingBranch(int customerId, int branchId) {
		return branchDao.addExistingCustomerToExistingBranch(branchId, customerId);
	}

	public Branch addNewCustomerToExistingBranch(Customer newCustomer, int branchId) {
		return branchDao.addNewCustomerToExistingBranch(newCustomer, branchId);
	}

}

package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;

	@Autowired
	AddressDao addressDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isEmpty()) {
			return null;
		} else {
			return branch.get();
		}
	}

	public List<Branch> fetchAllBranchs() {
		return branchRepo.findAll();
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		saveBranch(newBranch);
		return newBranch;
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> employees = branch.getEmployees();
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		employees.add(employee);
		branch.setEmployees(employees);
		return saveBranch(branch);
	}

	public Branch addNewEmployeeToExistingBranch(Employee newEmployee, int branchId) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> employees = branch.getEmployees();
		employees.add(newEmployee);
		branch.setEmployees(employees);
		return saveBranch(branch);
	}

	public Branch addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> customers = branch.getCustomers();
		Customer customer = customerDao.fetchCustomerById(customerId);
		customers.add(customer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}

	public Branch addNewCustomerToExistingBranch(Customer newCustomer, int branchId) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> customers = branch.getCustomers();
		customers.add(newCustomer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}

}

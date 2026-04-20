package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.repo.BankRepo;

@Repository
public class BankDao {

	@Autowired
	BankRepo bankRepo;

	@Autowired
	BranchDao branchDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AtmDao atmDao;

	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}

	public Bank fetchBankById(int bankId) {
		Optional<Bank> bank = bankRepo.findById(bankId);
		if (bank.isEmpty()) {
			return null;
		} else {
			return bank.get();
		}
	}

	public List<Bank> fetchAllBanks() {
		return bankRepo.findAll();
	}

	public Bank updateBankById(int oldBankId, Bank newBank) {
		newBank.setBankId(oldBankId);
		saveBank(newBank);
		return newBank;
	}

	public Bank deleteBankById(int bankId) {
		Bank bank = fetchBankById(bankId);
		bankRepo.delete(bank);
		return bank;
	}

	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		Bank bank = fetchBankById(bankId);
		List<Branch> branchs = bank.getBranchs();
		Branch branch = branchDao.fetchBranchById(branchId);
		branchs.add(branch);
		bank.setBranchs(branchs);
		return saveBank(bank);
	}

	public Bank addNewBranchToExistingBank(Branch newBranch, int bankId) {
		Bank bank = fetchBankById(bankId);
		List<Branch> branchs = bank.getBranchs();
		branchs.add(newBranch);
		bank.setBranchs(branchs);
		return saveBank(bank);
	}

	public Bank addExistingManagerToExistingBank(int managerId, int bankId) {
		Bank bank = fetchBankById(bankId);
		Manager manager = managerDao.fetchManagerById(managerId);
		bank.setManager(manager);
		return saveBank(bank);
	}

	public Bank addExistingAtmToExistingBank(int atmId, int bankId) {
		Bank bank = fetchBankById(bankId);
		List<Atm> atms = bank.getAtms();
		Atm atm = atmDao.fetchAtmById(atmId);
		atms.add(atm);
		bank.setAtms(atms);
		return saveBank(bank);
	}

	public Bank addNewAtmToExistingBank(Atm newAtm, int bankId) {
		Bank bank = fetchBankById(bankId);
		List<Atm> atms = bank.getAtms();
		atms.add(newAtm);
		bank.setAtms(atms);
		return saveBank(bank);
	}
}

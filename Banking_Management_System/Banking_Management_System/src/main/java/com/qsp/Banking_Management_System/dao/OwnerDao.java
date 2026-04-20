package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	BankDao bankDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isEmpty()) {
			return null;
		} else {
			return owner.get();
		}
	}

	public List<Owner> fetchAllOwners() {
		return ownerRepo.findAll();
	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		saveOwner(newOwner);
		return newOwner;
	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner addExistingBankToExistingOwner(int ownerId, int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		Owner owner = fetchOwnerById(ownerId);
		owner.setBank(bank);
		return saveOwner(owner);
	}
}

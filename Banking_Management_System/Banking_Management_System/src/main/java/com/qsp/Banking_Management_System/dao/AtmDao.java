package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.repo.AtmRepo;

@Repository
public class AtmDao {
	@Autowired
	AtmRepo atmRepo;

	public Atm saveAtm(Atm atm) {
		return atmRepo.save(atm);
	}

	public Atm fetchAtmById(int atmId) {
		Optional<Atm> atm = atmRepo.findById(atmId);
		if (atm.isEmpty()) {
			return null;
		} else {
			return atm.get();
		}
	}

	public List<Atm> fetchAllAtms() {
		return atmRepo.findAll();
	}

	public Atm updateAtmById(int oldAtmId, Atm newAtm) {
		newAtm.setAtmId(oldAtmId);
		saveAtm(newAtm);
		return newAtm;
	}

	public Atm deleteAtmById(int atmId) {
		Atm atm = fetchAtmById(atmId);
		atmRepo.delete(atm);
		return atm;
	}
}

package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.AtmDao;
import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.exception.AtmIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class AtmService {
	@Autowired
	AtmDao atmDao;

	@Autowired
	ResponseStructure<Atm> responseStructure;

	public ResponseEntity<ResponseStructure<Atm>> saveAtm(Atm atm) {
		responseStructure.setMessage("Successfully Atm created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(atmDao.saveAtm(atm));
		return new ResponseEntity<ResponseStructure<Atm>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Atm>> fetchAtmById(int atmId) {
		Atm atm = atmDao.fetchAtmById(atmId);
		if (atm != null) {
			responseStructure.setMessage("Successfully atm fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(atmDao.fetchAtmById(atmId));
			return new ResponseEntity<ResponseStructure<Atm>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AtmIdNotFound();
		}
	}

	public List<Atm> fetchAllAtms() {
		return atmDao.fetchAllAtms();
	}

	public ResponseEntity<ResponseStructure<Atm>> updateAtmById(int oldAtmId, Atm newAtm) {
		responseStructure.setMessage("Successfully atm updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.updateAtmById(oldAtmId, newAtm));
		return new ResponseEntity<ResponseStructure<Atm>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Atm>> deleteAtmById(int atmId) {
		Atm atm = atmDao.fetchAtmById(atmId);
		if (atm != null) {
			responseStructure.setMessage("Successfully atm deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(atmDao.deleteAtmById(atmId));
			return new ResponseEntity<ResponseStructure<Atm>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AtmIdNotFound();
		}
	}

}

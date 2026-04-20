package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.OwnerDao;
import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.exception.OwnerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("Successfully owner created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("Successfully owner fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public List<Owner> fetchAllOwners() {
		return ownerDao.fetchAllOwners();
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		responseStructure.setMessage("Successfully owner updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("Successfully owner deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public Owner addExistingBankToExistingOwner(int ownerId, int bankId) {
		return ownerDao.addExistingBankToExistingOwner(ownerId, bankId);
	}
}

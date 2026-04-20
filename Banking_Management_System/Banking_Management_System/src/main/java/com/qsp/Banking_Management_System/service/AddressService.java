package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.AddressDao;
import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.exception.AddressIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("Successfully Address created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Successfully address fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		responseStructure.setMessage("Successfully address updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Successfully address deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

}

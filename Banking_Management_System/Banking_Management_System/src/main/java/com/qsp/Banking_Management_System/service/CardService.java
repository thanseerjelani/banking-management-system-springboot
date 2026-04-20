package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.CardDao;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.exception.CardIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class CardService {
	@Autowired
	CardDao cardDao;

	@Autowired
	ResponseStructure<Card> responseStructure;

	public ResponseEntity<ResponseStructure<Card>> saveCard(Card card) {
		responseStructure.setMessage("Successfully Card created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Card>> fetchCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("Successfully card fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(cardDao.fetchCardById(cardId));
			return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CardIdNotFound();
		}
	}

	public List<Card> fetchAllCards() {
		return cardDao.fetchAllCards();
	}

	public ResponseEntity<ResponseStructure<Card>> updateCardById(int oldCardId, Card newCard) {
		responseStructure.setMessage("Successfully card updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(cardDao.updateCardById(oldCardId, newCard));
		return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Card>> deleteCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("Successfully card deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.deleteCardById(cardId));
			return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CardIdNotFound();
		}
	}

}

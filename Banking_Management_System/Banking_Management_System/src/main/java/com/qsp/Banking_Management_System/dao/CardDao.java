package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.repo.CardRepo;

@Repository
public class CardDao {
	@Autowired
	CardRepo cardRepo;

	public Card saveCard(Card card) {
		return cardRepo.save(card);
	}

	public Card fetchCardById(int cardId) {
		Optional<Card> card = cardRepo.findById(cardId);
		if (card.isEmpty()) {
			return null;
		} else {
			return card.get();
		}
	}

	public List<Card> fetchAllCards() {
		return cardRepo.findAll();
	}

	public Card updateCardById(int oldCardId, Card newCard) {
		newCard.setCardId(oldCardId);
		saveCard(newCard);
		return newCard;
	}

	public Card deleteCardById(int cardId) {
		Card card = fetchCardById(cardId);
		cardRepo.delete(card);
		return card;
	}
}

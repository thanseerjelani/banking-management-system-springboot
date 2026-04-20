package com.qsp.Banking_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.service.CardService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CardController {
	@Autowired
	CardService cardService;

	@Operation(summary = "Save Card", description = "API is used to save the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	
	@PostMapping("/saveCard")
	public ResponseEntity<ResponseStructure<Card>> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
	
	@Operation(summary = "fetch Card", description = "API is used to fetch the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })

	@GetMapping("/fetchCardById")
	public ResponseEntity<ResponseStructure<Card>> fetchCardById(@RequestParam int cardId) {
		return cardService.fetchCardById(cardId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllCards")
	public List<Card> fetchAllCards() {
		return cardService.fetchAllCards();
	}
	
	@Operation(summary = "Update Card", description = "API is used to update the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })

	@PutMapping("/updateCardById")
	public ResponseEntity<ResponseStructure<Card>> updateCardById(@RequestParam int oldCardId,
			@RequestBody Card newCard) {
		return cardService.updateCardById(oldCardId, newCard);
	}
	
	@Operation(summary = "Delete Card", description = "API is used to delete the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })

	@DeleteMapping("/deleteCardById")
	public ResponseEntity<ResponseStructure<Card>> deleteCardById(@RequestParam int cardId) {
		return cardService.deleteCardById(cardId);
	}
}

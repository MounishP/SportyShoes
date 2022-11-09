package com.sportyshoes.controller;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.service.SportyShoesService;

@RestController
public class CRUDController {

	@Autowired
	private SportyShoesService sportyShoesService;
	private MultiValueMap<String, String> errorMap;

	@PostMapping("/admin/shoe")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
		try {
			return new ResponseEntity<>(sportyShoesService.createShoe(shoe), HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("error Message: ", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@RequestParam int id) {
		try {
			return new ResponseEntity<>(sportyShoesService.getShoeById(id), HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage: ", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
		try {
			return new ResponseEntity<>(sportyShoesService.createPurchaseReport(pr), HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/admin/shoe")
	public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe) {
		return new ResponseEntity<>(sportyShoesService.updateShoe(shoe), HttpStatus.OK);
	}

	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@RequestParam int id) {
		try {
			sportyShoesService.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@RequestParam int id) {
		try {
			return new ResponseEntity<>(sportyShoesService.getPurchaseReportById(id), HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr) {
		return new ResponseEntity<>(sportyShoesService.updatePurchaseReport(pr), HttpStatus.OK);
	}

	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@RequestParam int id) {
		try {
			sportyShoesService.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

}

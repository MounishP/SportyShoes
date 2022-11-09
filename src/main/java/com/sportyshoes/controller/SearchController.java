package com.sportyshoes.controller;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import com.sportyshoes.repo.ShoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.service.SportyShoesService;

import java.util.Date;
import java.util.List;

@RestController
public class SearchController {
	@Autowired
	private SportyShoesService sportyShoesService;
	
	@Autowired
	private ShoesRepository shoesRepository;

	@GetMapping("/admin/shoe/all")
	public ResponseEntity<List<Shoe>> getAllShoes(){
		return new ResponseEntity<>(sportyShoesService.getAllShoes(),HttpStatus.OK);
    }

	@GetMapping("/admin/purchaseReport/category/{category}")
    public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@RequestParam String category){
    	return new ResponseEntity<List<PurchaseReport>>(sportyShoesService.getAllPurchaseReportByCategory(category),HttpStatus.OK);
	}
	
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByDop(@RequestParam Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<PurchaseReport>>(sportyShoesService.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(sportyShoesService.getAllPurchaseReports(), HttpStatus.OK);
	}
}

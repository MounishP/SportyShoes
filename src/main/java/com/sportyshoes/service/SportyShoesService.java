package com.sportyshoes.service;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface SportyShoesService {
    public List<Shoe> getAllShoes();

	public List<PurchaseReport> getAllPurchaseReportByCategory(String category);
//
	public Shoe createShoe(Shoe shoe) throws Exception;

	public Shoe getShoeById(int id) throws Exception;

	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws Exception;

	public Shoe updateShoe(Shoe shoe);
	
	
	
	public void deleteShoeById(int id) throws Exception;
	
	
	public PurchaseReport getPurchaseReportById(int id) throws Exception;
	public PurchaseReport updatePurchaseReport(PurchaseReport pr);
	public void deletePurchaseReportById(int id) throws Exception;
	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category);
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop);

}

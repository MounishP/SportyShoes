package com.sportyshoes.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.PurchaseReport;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseReport,Integer>{

	public List<PurchaseReport> findByCategory(String category);

	public List<PurchaseReport> findByDate(Date date);
	
}

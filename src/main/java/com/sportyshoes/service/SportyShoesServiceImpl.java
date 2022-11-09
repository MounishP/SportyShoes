package com.sportyshoes.service;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import com.sportyshoes.repo.PurchaseRepo;
import com.sportyshoes.repo.ShoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

@Service
public class SportyShoesServiceImpl implements SportyShoesService{

    @Autowired
	private ShoesRepository shoesRepository;
    
    @Autowired
    private PurchaseRepo purchaseRepo;
    
    @PostConstruct
    public void init() {
    	Shoe s1 = new Shoe(1,"Shoe Name 1","Basketball",1000.24);
		Shoe s2 = new Shoe(2,"Shoe Name 2","Cricket",1100.24);
		Shoe s3 = new Shoe(3,"Shoe Name 3","Running",900.24);
		Shoe s4 = new Shoe(4,"Shoe Name 4","Football",1900.24);
		
		shoesRepository.save(s1);
		shoesRepository.save(s2);
		shoesRepository.save(s3);
		shoesRepository.save(s4);
		
		Date d = new Date(0);
		PurchaseReport pr1 = new PurchaseReport(5,"user_1","Running",d);
		PurchaseReport pr2 = new PurchaseReport(6,"user_2","Cricket",d);
		PurchaseReport pr3 = new PurchaseReport(7,"user_3","Basketball",d);
		PurchaseReport pr4 = new PurchaseReport(8,"user_4","Football",d);
		
		purchaseRepo.save(pr1);
		purchaseRepo.save(pr2);
		purchaseRepo.save(pr3);
		purchaseRepo.save(pr4);
    }

    @Override
    public List<Shoe> getAllShoes() {
        return shoesRepository.findAll();
    }

	@Override
	public List<PurchaseReport> getAllPurchaseReportByCategory(String category) {
		return purchaseRepo.findByCategory(category);

	}
	
	@Override
	public Shoe createShoe(Shoe shoe) throws Exception {
		int id = shoe.getId();
		Shoe oldShoe = null;
		try {
			oldShoe = shoesRepository.findById(id).get();
		}catch (Exception e) {
		}
		if(oldShoe!=null) throw new Exception("Shoe already exixts with id: " + id);
		return shoesRepository.save(shoe);
	}

	@Override
	public Shoe getShoeById(int id) throws Exception {
		Shoe shoe = null;
		try {
			if(id<=0) throw new Exception("Shoe Id can not be negative or zero");
			shoe = shoesRepository.findById(id).get();
		}catch (Exception e) {
			throw new Exception("Shoe not found with ID: " + id);
		}
		return shoe;
	}

	@Override
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws Exception {
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = purchaseRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new Exception("Purchase report already exists with id: "+id);
		return purchaseRepo.save(pr);	
	}

	@Override
	public Shoe updateShoe(Shoe shoe) {
		return shoesRepository.save(shoe);
	}

	@Override
	public void deleteShoeById(int id) throws Exception {
		try {
			shoesRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new Exception("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new Exception("SHoe does not exist with id: "+id);
		}
		
	}

	@Override
	public PurchaseReport getPurchaseReportById(int id) throws Exception {
		PurchaseReport pr = null;
		try {
			if(id<=0) throw new Exception("Purchase Report Id can not be negative or zero");
			pr = purchaseRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new Exception("Purchase Report not found with Id: "+id);
		}
		return pr;
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		return purchaseRepo.save(pr);
	}

	@Override
	public void deletePurchaseReportById(int id) throws Exception {
		try {
			purchaseRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new Exception("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new Exception("Puchase Report does not exist with Id: "+id);
		}
		
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReports() {
		return  purchaseRepo.findAll();
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		// TODO Auto-generated method stub
		return purchaseRepo.findByCategory(category);
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		// TODO Auto-generated method stub
		return purchaseRepo.findByDate(dop);
	}
}

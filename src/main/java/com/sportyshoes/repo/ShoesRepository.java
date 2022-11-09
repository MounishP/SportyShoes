package com.sportyshoes.repo;

import com.sportyshoes.model.Shoe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoe,Integer> {

}

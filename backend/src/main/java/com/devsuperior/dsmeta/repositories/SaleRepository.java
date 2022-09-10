package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :dateMin AND :dateMax ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate dateMin, LocalDate dateMax, Pageable pageable);
	
}

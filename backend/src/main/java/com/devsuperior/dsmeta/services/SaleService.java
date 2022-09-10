package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate dateToday = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate dateMin= minDate.equals("") ? dateToday.minusDays(365) : LocalDate.parse(minDate);
		LocalDate dateMax= maxDate.equals("") ? dateToday : LocalDate.parse(maxDate);
		
		return saleRepository.findSales(dateMin, dateMax, pageable);
	}
	
}

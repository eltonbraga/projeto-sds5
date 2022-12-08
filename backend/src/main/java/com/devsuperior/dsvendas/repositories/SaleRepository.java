package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.domains.Sale;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.dto.SaleVisitsAndDealsDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDto(obj.seller, SUM(obj.amount)) " + 
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDto> amountOfSalesBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleVisitsAndDealsDto(obj.seller, SUM(obj.visited), SUM(obj.deals)) " + 
    "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleVisitsAndDealsDto> numberOfDealsAndVisitsBySeller();
}

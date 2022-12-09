package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.domains.Sale;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.dto.SaleVisitsAndDealsDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDto(seller, SUM(obj.amount)) "
        + " FROM Sale AS obj"
        + " LEFT JOIN Seller as seller "
        + "     ON seller.id = obj.seller.id "
        + " GROUP BY seller.id, obj.seller.id")
    List<SaleSumDto> amountOfSalesBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleVisitsAndDealsDto(seller, SUM(obj.visited), SUM(obj.deals)) "
            + " FROM Sale AS obj"
            + " LEFT JOIN Seller as seller "
            + "     ON seller.id = obj.seller.id "
            + " GROUP BY seller.id, obj.seller.id")
    List<SaleVisitsAndDealsDto> numberOfDealsAndVisitsBySeller();
}

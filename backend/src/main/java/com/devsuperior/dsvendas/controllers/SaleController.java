package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.dto.SaleVisitsAndDealsDto;
import com.devsuperior.dsvendas.services.SaleService;


@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(final SaleService service) {
        this.service = service;
    }

    @GetMapping
    public Page<SaleDto> findAll(final Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/amount-by-seller")
    public List<SaleSumDto> amountOfSalesBySeller() {
        return service.amountOfSalesBySeller();
    }

    @GetMapping("/visits-and-deals-by-seller")
    public List<SaleVisitsAndDealsDto> numberOfDealsAndVisitsBySeller() {
        return service.numberOfDealsAndVisitsBySeller();
    }
}

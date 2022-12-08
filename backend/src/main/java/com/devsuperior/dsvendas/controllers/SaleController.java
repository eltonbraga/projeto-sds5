package com.devsuperior.dsvendas.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.controllers.dto.SaleDto;
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
}

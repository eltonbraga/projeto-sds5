package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.controllers.dto.SellerDto;
import com.devsuperior.dsvendas.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService service;

    public SellerController(final SellerService service) {
        this.service = service;
    }

    @GetMapping
    public List<SellerDto> findAll() {
        return service.findAll();
    }

}

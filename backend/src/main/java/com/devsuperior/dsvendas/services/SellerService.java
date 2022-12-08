package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.controllers.dto.SellerDto;
import com.devsuperior.dsvendas.domains.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private final SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<SellerDto> findAll(){
        final List<Seller> sellers =  repository.findAll();

        return sellers
                .stream().map(seller ->
                        new SellerDto(seller.getId(), seller.getName()))
                .collect(Collectors.toList());
    }
}

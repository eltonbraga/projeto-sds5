package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.controllers.dto.SaleDto;
import com.devsuperior.dsvendas.controllers.dto.SellerDto;
import com.devsuperior.dsvendas.domains.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

    private final SaleRepository repository;

    public SaleService(final SaleRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<SaleDto> findAll(final Pageable pageable) {

        final Page<Sale> result = repository.findAll(pageable);
        
        // can be improved (jpa is doing more than one find in seller's table)
        return result.map(sale -> new SaleDto(sale.getId(), sale.getVisited(), sale.getDeals(), sale.getAmount(),
                        sale.getDate(), new SellerDto(sale.getSeller().getId(), sale.getSeller().getName())));
    }
}

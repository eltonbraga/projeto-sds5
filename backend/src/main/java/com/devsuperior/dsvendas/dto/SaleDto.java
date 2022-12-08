package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

public record SaleDto(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDto seller) {}

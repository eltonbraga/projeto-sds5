package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.domains.Seller;

public class SaleVisitsAndDealsDto {

    private String sellerName;

    private Long totalOfVisit;

    private Long totalOfDeals;

    public SaleVisitsAndDealsDto(final Seller seller, final Long totalOfVisit, final Long totalOfDeals) {
        this.sellerName = seller.getName();
        this.totalOfVisit = totalOfVisit;
        this.totalOfDeals = totalOfDeals;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getTotalOfVisit() {
        return totalOfVisit;
    }

    public void setTotalOfVisit(Long totalOfVisit) {
        this.totalOfVisit = totalOfVisit;
    }

    public Long getTotalOfDeals() {
        return totalOfDeals;
    }

    public void setTotalOfDeals(Long totalOfDeals) {
        this.totalOfDeals = totalOfDeals;
    }

}
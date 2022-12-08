package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.domains.Seller;

public class SaleSumDto {

    private String sellerName;

    private Double sum;

    public SaleSumDto(final Seller seller, final Double sum) {
        this.sum = sum;
        this.sellerName = seller.getName();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

}
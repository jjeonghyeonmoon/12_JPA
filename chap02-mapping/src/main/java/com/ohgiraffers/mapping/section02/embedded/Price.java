package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Price {

    //
    @Column(name = "regular_price")
    private int regularPrice; //정식 판매 가격

    @Column(name = "discount_rate")
    private double discountRate; // 할인율

    @Column(name = "sell_price")
    private int sellPrice; // 할인율 적용된 실제 가격


    public Price(){}

    public Price(int regularPrice, double discountRate) {
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;

    }
}

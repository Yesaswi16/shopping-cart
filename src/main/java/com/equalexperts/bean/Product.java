package com.equalexperts.bean;

import com.equalexperts.constants.ProductType;

import java.math.BigDecimal;

public class Product {
    private final ProductType type;
    private final BigDecimal price;

    public Product(ProductType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

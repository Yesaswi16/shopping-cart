package com.equalexperts.bean;

import com.equalexperts.constants.ProductType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testConstructorAndGetters() {
        Product product = new Product(ProductType.Cheerios, new BigDecimal("2.50"));
        assertEquals(ProductType.Cheerios, product.getType());
        assertEquals(new BigDecimal("2.50"), product.getPrice());
    }

    @Test
    void testDifferentProductTypes() {
        Product cornflakes = new Product(ProductType.Cornflakes, new BigDecimal("3.00"));
        Product frosties = new Product(ProductType.Frosties, new BigDecimal("2.25"));

        assertEquals(ProductType.Cornflakes, cornflakes.getType());
        assertEquals(new BigDecimal("3.00"), cornflakes.getPrice());

        assertEquals(ProductType.Frosties, frosties.getType());
        assertEquals(new BigDecimal("2.25"), frosties.getPrice());
    }

    @Test
    void testPricePrecision() {
        BigDecimal precisePrice = new BigDecimal("2.3333");
        Product product = new Product(ProductType.Weetabix, precisePrice);
        assertEquals(precisePrice, product.getPrice());
        assertEquals(ProductType.Weetabix, product.getType());
    }

    @Test
    void testEqualityOfValues() {
        Product p1 = new Product(ProductType.Shreddies, new BigDecimal("1.75"));
        Product p2 = new Product(ProductType.Shreddies, new BigDecimal("1.75"));

        // They are different objects, but values should match
        assertEquals(p1.getType(), p2.getType());
        assertEquals(p1.getPrice(), p2.getPrice());
        assertNotSame(p1, p2);
    }
}

package com.equalexperts.bean;

import com.equalexperts.constants.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;
    private Product cheerios;
    private Product cornflakes;

    @BeforeEach
    void setup() {
        cart = new Cart();
        cheerios = new Product(ProductType.Cheerios, new BigDecimal("2.50"));
        cornflakes = new Product(ProductType.Cornflakes, new BigDecimal("3.00"));
    }

    @Test
    void testAddProduct() {
        cart.addProduct(cheerios, 2);
        assertEquals(new BigDecimal("5.00"), cart.getSubtotal());
    }

    @Test
    void testAddMultipleProducts() {
        cart.addProduct(cheerios, 2); // 5.00
        cart.addProduct(cornflakes, 1); // 3.00
        assertEquals(new BigDecimal("8.00"), cart.getSubtotal());
    }

    @Test
    void testUpdateProductQuantity() {
        cart.addProduct(cheerios, 2);
        cart.updateProductQuantity(cheerios, 5);
        assertEquals(new BigDecimal("12.50"), cart.getSubtotal());
    }

    @Test
    void testUpdateProductQuantityToZeroRemovesProduct() {
        cart.addProduct(cheerios, 2);
        cart.updateProductQuantity(cheerios, 0);
        assertEquals(new BigDecimal("0.00"), cart.getSubtotal());
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct(cheerios, 2);
        cart.removeProduct(cheerios);
        assertEquals(new BigDecimal("0.00"), cart.getSubtotal());
    }

    @Test
    void testTaxCalculation() {
        cart.addProduct(cheerios, 4); // subtotal = 10.00
        assertEquals(new BigDecimal("1.25"), cart.getTax());
    }

    @Test
    void testTotalCalculation() {
        cart.addProduct(cheerios, 4); // subtotal = 10.00
        assertEquals(new BigDecimal("11.25"), cart.getTotal());
    }

    @Test
    void testDisplayCartContents() {
        cart.addProduct(cheerios, 2);
        cart.addProduct(cornflakes, 1);
        cart.displayCartContents(); // Just ensures no exception is thrown
    }

    @Test
    void testEmptyCartTotals() {
        assertEquals(new BigDecimal("0.00"), cart.getSubtotal());
        assertEquals(new BigDecimal("0.00"), cart.getTax());
        assertEquals(new BigDecimal("0.00"), cart.getTotal());
    }
}

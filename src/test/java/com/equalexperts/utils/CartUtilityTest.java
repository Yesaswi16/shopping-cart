package com.equalexperts.utils;

import com.equalexperts.bean.Product;
import com.equalexperts.constants.ProductType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartUtilityTest {

    @Test
    void testFetchProductPriceCheerios() throws Exception {
        Product product = CartUtility.fetchProductPrice(ProductType.Cheerios);
        assertEquals(ProductType.Cheerios, product.getType());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testFetchProductPriceCornflakes() throws Exception {
        Product product = CartUtility.fetchProductPrice(ProductType.Cornflakes);
        assertEquals(ProductType.Cornflakes, product.getType());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testFetchProductPriceFrosties() throws Exception {
        Product product = CartUtility.fetchProductPrice(ProductType.Frosties);
        assertEquals(ProductType.Frosties, product.getType());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testFetchProductPriceShreddies() throws Exception {
        Product product = CartUtility.fetchProductPrice(ProductType.Shreddies);
        assertEquals(ProductType.Shreddies, product.getType());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testFetchProductPriceWeetabix() throws Exception {
        Product product = CartUtility.fetchProductPrice(ProductType.Weetabix);
        assertEquals(ProductType.Weetabix, product.getType());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

   
}

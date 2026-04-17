package com.equalexperts;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ShoppingCartAppTest {

    @Test
    void testExitImmediately() {
        String input = "5\n"; // choose Exit
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> ShoppingCartApp.main(new String[]{}));
    }

    @Test
    void testAddProductsAndViewCart() {
        // Simulate: Add Cheerios=1, Cornflakes=2, Frosties=0, Shreddies=0, Weetabix=0, then View cart, then Exit
        StringBuilder sb = new StringBuilder();
        sb.append("1\n"); // Add product
        sb.append("1\n"); // Cheerios qty
        sb.append("2\n"); // Cornflakes qty
        sb.append("0\n"); // Frosties qty
        sb.append("0\n"); // Shreddies qty
        sb.append("0\n"); // Weetabix qty
        sb.append("4\n"); // View cart
        sb.append("5\n"); // Exit
        InputStream in = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> ShoppingCartApp.main(new String[]{}));
    }

    @Test
    void testUpdateProductQuantity() {
        // Simulate: Add Cheerios=1, others=0, then Update Cheerios to 3, then Exit
        StringBuilder sb = new StringBuilder();
        sb.append("1\n"); // Add product
        sb.append("1\n"); // Cheerios qty
        sb.append("0\n"); // Cornflakes qty
        sb.append("0\n"); // Frosties qty
        sb.append("0\n"); // Shreddies qty
        sb.append("0\n"); // Weetabix qty
        sb.append("2\n"); // Update product
        sb.append("CHEERIOS\n"); // product name
        sb.append("3\n"); // new quantity
        sb.append("5\n"); // Exit
        InputStream in = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> ShoppingCartApp.main(new String[]{}));
    }

    @Test
    void testRemoveProduct() {
        // Simulate: Add Cheerios=1, others=0, then Remove Cheerios, then Exit
        StringBuilder sb = new StringBuilder();
        sb.append("1\n"); // Add product
        sb.append("1\n"); // Cheerios qty
        sb.append("0\n"); // Cornflakes qty
        sb.append("0\n"); // Frosties qty
        sb.append("0\n"); // Shreddies qty
        sb.append("0\n"); // Weetabix qty
        sb.append("3\n"); // Remove product
        sb.append("CHEERIOS\n"); // product name
        sb.append("5\n"); // Exit
        InputStream in = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> ShoppingCartApp.main(new String[]{}));
    }

    @Test
    void testInvalidChoice() {
        // Simulate: Invalid choice (9), then Exit
        StringBuilder sb = new StringBuilder();
        sb.append("9\n"); // invalid
        sb.append("5\n"); // exit
        InputStream in = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> ShoppingCartApp.main(new String[]{}));
    }
}

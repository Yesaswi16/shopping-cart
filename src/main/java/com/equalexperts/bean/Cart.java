package com.equalexperts.bean;

import com.equalexperts.constants.ProductType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<ProductType, CartItem> items = new HashMap<>();
    private static final BigDecimal TAX_RATE = new BigDecimal("0.125");

    // Helper class to store price + quantity
    static class CartItem {
        BigDecimal price;
        int quantity;

        CartItem(BigDecimal price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    public void addProduct(Product product, int quantity) {
        ProductType type = product.getType();
        CartItem item = items.get(type);
        if (item == null) {
            items.put(type, new CartItem(product.getPrice(), quantity));
        } else {
            item.quantity += quantity;
        }
    }

    public void updateProductQuantity(Product product, int newQuantity) {
        ProductType type = product.getType();
        if (items.containsKey(type)) {
            if (newQuantity > 0) {
                items.put(type, new CartItem(product.getPrice(), newQuantity));
            } else {
                items.remove(type);
            }
        }
    }

    public void removeProduct(Product product) {
        items.remove(product.getType());
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (CartItem item : items.values()) {
            subtotal = subtotal.add(item.price.multiply(BigDecimal.valueOf(item.quantity)));
        }
        return subtotal.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTax() {
        return getSubtotal().multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return getSubtotal().add(getTax()).setScale(2, RoundingMode.HALF_UP);
    }

    public void displayCartContents() {
        System.out.println("\nCart Summary:");
        int totalItems = 0;
        for (Map.Entry<ProductType, CartItem> entry : items.entrySet()) {
            ProductType type = entry.getKey();
            CartItem item = entry.getValue();
            BigDecimal lineTotal = item.price.multiply(BigDecimal.valueOf(item.quantity))
                    .setScale(2, RoundingMode.HALF_UP);

            totalItems += item.quantity;

            System.out.println("- " + item.quantity + " x " + type
                    + " @ $" + item.price
                    + " each = $" + lineTotal);
        }
        System.out.println("Total items: " + totalItems);
        System.out.println("Subtotal: $" + getSubtotal());
        System.out.println("Tax (12.5%): $" + getTax());
        System.out.println("Total: $" + getTotal());
    }
}

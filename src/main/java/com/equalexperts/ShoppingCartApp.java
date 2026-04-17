package com.equalexperts;

import com.equalexperts.bean.Cart;
import com.equalexperts.bean.Product;
import com.equalexperts.constants.ProductType;
import org.json.JSONObject; // You can use org.json (lightweight dependency)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ShoppingCartApp {
    private static Product fetchProductPrice(ProductType type) throws Exception {
        String urlStr = "https://equalexperts.github.io" + type.getEndpoint();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            JSONObject json = new JSONObject(response.toString());
            BigDecimal price = json.getBigDecimal("price");
            return new Product(type, price);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Cart cart = new Cart();

            boolean running = true;
            while (running) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add product");
                System.out.println("2. Update product quantity");
                System.out.println("3. Remove product");
                System.out.println("4. View cart summary");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        for (ProductType type : ProductType.values()) {
                            System.out.print("Enter quantity for " + type + ": ");
                            int qty = scanner.nextInt();
                            if (qty > 0) {
                                Product product = fetchProductPrice(type);
                                cart.addProduct(product, qty);
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Enter product to update (Cheerios/Cornflakes/Frosties/Shreddies/Weetabix): ");
                        String updateName = scanner.next();
                        ProductType updateType = ProductType.valueOf(updateName);
                        Product updateProduct = fetchProductPrice(updateType);
                        System.out.print("Enter new quantity: ");
                        int newQty = scanner.nextInt();
                        cart.updateProductQuantity(updateProduct, newQty);
                        break;

                    case 3:
                        System.out.print("Enter product to remove (Cheerios/Cornflakes/Frosties/Shreddies/Weetabix): ");
                        String removeName = scanner.next();
                        ProductType removeType = ProductType.valueOf(removeName);
                        Product removeProduct = fetchProductPrice(removeType);
                        cart.removeProduct(removeProduct);
                        break;

                    case 4:
                        cart.displayCartContents();
                        break;

                    case 5:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



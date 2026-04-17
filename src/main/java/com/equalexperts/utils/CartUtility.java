package com.equalexperts.utils;

import com.equalexperts.bean.Product;
import com.equalexperts.constants.ProductType;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class CartUtility {

    public static Product fetchProductPrice(ProductType type) throws Exception {
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
}

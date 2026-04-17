# Shopping Cart Application

A simple **pure Java shopping cart application** that fetches product prices from a remote API, allows users to add, update, and remove products, and calculates subtotal, tax, and total with precise rounding.

---

## Features
- Add products to the cart with user-specified quantities.
- Update product quantities.
- Remove products from the cart.
- Fetch product prices dynamically from a provided API.
- Calculate and display:
    - Subtotal
    - Tax (12.5% of subtotal)
    - Total (subtotal + tax)
- Display cart summary with:
    - Product type
    - Quantity
    - Unit price
    - Line total (quantity × unit price)
    - Grand totals

---

## Supported Products
- **Cheerios**
- **Cornflakes**
- **Frosties**
- **Shreddies**
- **Weetabix**

---

## API Details
- **Base URL**: `https://equalexperts.github.io`
- **Endpoint format**: `/backend-take-home-test-data/{product}.json`
- Examples:
    - `https://equalexperts.github.io/backend-take-home-test-data/cheerios.json`
    - `https://equalexperts.github.io/backend-take-home-test-data/cornflakes.json`
    - `https://equalexperts.github.io/backend-take-home-test-data/frosties.json`
    - `https://equalexperts.github.io/backend-take-home-test-data/shreddies.json`
    - `https://equalexperts.github.io/backend-take-home-test-data/weetabix.json`

Each endpoint returns JSON containing the product price.

---

## Technologies Used
- Pure Java (no frameworks)
- `java.net.HttpURLConnection` for API calls
- `org.json` library for parsing JSON
- `BigDecimal` for precise monetary calculations

---

## How to Run
1. Clone or download the project.
2. Ensure you have Java 8+ installed.
3. Add the `org.json` dependency to your classpath (or download the JAR).
4. Compile the application:
   ```bash
   javac ShoppingCartApp.java


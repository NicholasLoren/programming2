package com.ecommerce;

/**
 * Represents a product in an ecommerce system.
 */
public class Product {
    private int productID;
    private String name;
    private double price;

    /**
     * Constructs a new Product with the given product ID, name, and price.
     *
     * @param productID the ID of the product
     * @param name      the name of the product
     * @param price     the price of the product
     */
    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the product ID.
     *
     * @param productID the new product ID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Gets the name of the product.
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }
}

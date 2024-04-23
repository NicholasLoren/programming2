package com.ecommerce;

import com.ecommerce.orders.Order;

import java.util.ArrayList;

/**
 * Represents a customer in an ecommerce system.
 */
public class Customer {
    private String name;
    private int customerID;

    private final ArrayList<Product> shoppingCart = new ArrayList<>();

    /**
     * Constructs a new Customer with the given customer ID and name.
     *
     * @param customerID the ID of the customer
     * @param name the name of the customer
     */
    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    /**
     * Gets the customer ID.
     *
     * @return the customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerID the new customer ID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the new name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a product to the customer's shopping cart.
     *
     * @param p the product to add to the shopping cart
     */
    public void addProductToCart(Product p) {
        this.shoppingCart.add(p);
    }

    /**
     * Removes a product from the customer's shopping cart.
     *
     * @param p the product to remove from the shopping cart
     */
    public void removeProductFromCart(Product p) {
        this.shoppingCart.remove(p);
    }

    /**
     * Gets the customer's shopping cart.
     *
     * @return the shopping cart
     */
    public ArrayList<Product> getShoppingCart() {
        return this.shoppingCart;
    }

    /**
     * Calculates the total cost of all products in the shopping cart.
     *
     * @return the total cost
     */
    public double calculateTotalCost() {
        double total = 0;

        for (Product p : this.shoppingCart) {
            total += p.getPrice();
        }

        return total;
    }

    /**
     * Places an order with the products currently in the shopping cart.
     *
     * @param orderId the ID of the order
     * @return the order that was placed
     */
    public Order placeOrder(int orderId) {
        var order = new Order(orderId, this, this.shoppingCart);
        // Remove products from the shopping cart after placing the order
        shoppingCart.clear();
        return order;
    }
}

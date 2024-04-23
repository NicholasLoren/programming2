package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order placed by a customer in an ecommerce system.
 */
public class Order {
    private int orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
    private String orderStatus;

    /**
     * Constructs a new Order with the given order ID, customer, and list of products.
     *
     * @param orderID  the ID of the order
     * @param customer the customer who placed the order
     * @param products the list of products in the order
     */
    public Order(int orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        // Pass a defensive copy of the list
        this.products = new ArrayList<>(products);
        this.orderStatus = "PENDING";
        this.orderTotal = calculateOrderTotal();
    }

    /**
     * Calculates the total cost of the order.
     *
     * @return the total cost of the order
     */
    private double calculateOrderTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Generates a summary of the order.
     *
     * @return a string containing the order summary
     */
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID).append("\n");
        summary.append("Customer: ").append(customer.getName()).append("\n");
        summary.append("Status: ").append(this.getOrderStatus()).append("\n");
        summary.append("Products:\n");
        for (Product product : products) {
            summary.append("- ").append(product.getName()).append(": $").append(product.getPrice()).append("\n");
        }
        summary.append("Total: $").append(String.format("%.2f", orderTotal)).append("\n");
        return summary.toString();
    }

    /**
     * Sets the status of the order.
     *
     * @param status the new status of the order
     */
    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    /**
     * Gets the status of the order.
     *
     * @return the status of the order
     */
    public String getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * Gets the ID of the order.
     *
     * @return the ID of the order
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the ID of the order.
     *
     * @param orderID the new ID of the order
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the customer associated with the order.
     *
     * @return the customer associated with the order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the order.
     *
     * @param customer the new customer associated with the order
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the list of products in the order.
     *
     * @return the list of products in the order
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products in the order.
     *
     * @param products the new list of products in the order
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Gets the total cost of the order.
     *
     * @return the total cost of the order
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the total cost of the order.
     *
     * @param orderTotal the new total cost of the order
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}

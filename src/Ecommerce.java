import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Ecommerce {
    static Scanner input = new Scanner(System.in);
    static Customer customer;
    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        boolean isRunning = true;
        //Initialize the inventory
        generateProducts();
        System.out.println("Welcome to Online Fruits 🍑 Ecommerce platform");
        System.out.println("\"Where freshness meets convenience\"");
        //Try to check if a user has set up an account
        if(customer == null){
            lineBreak();
            System.out.println("Hey, it seems you are new here. Let's setup for you an account");
            System.out.print("Enter your name: ");
            String customerName = input.nextLine();

            customer = new Customer(1,customerName);
            System.out.println("Account created successfully.");
            lineBreak();
        }

        while(isRunning){
            displayMenu();
            int choice = getNaturalNumber();

            switch(choice){
                case 0->{
                    System.out.println("Thanks for using my platform");
                    isRunning = false;
                }
                case 1->{
                    //Display all products in the inventory
                    displayProducts();
                    System.out.print("Enter a product id to add to cart: ");
                    int productId = getNaturalNumber();

                    //if the product id is 0, go back to main menu
                    if(productId == 0) continue;

                    addToCartOrReportNotFound(productId);

                    while(productId!=0){
                        displayProducts();
                        System.out.print("Enter a product id to add to cart: ");
                        productId = getNaturalNumber();

                        if (productId == 0) continue;
                        addToCartOrReportNotFound(productId);
                    }


                }

                case 2->{
                    //check if there are some cart products
                    if(customer.getShoppingCart().isEmpty()){
                        System.out.println("Add some products");
                        lineBreak();
                        continue;
                    }
                    displayCartProducts(customer);
                    lineBreak();
                    System.out.println("1. Place Order");
                    System.out.println("0. Go back");
                    choice = getNaturalNumber();

                    if (choice != 1) {
                        continue;
                    }
                    int orderId = orders.size() + 1;
                    Order order = customer.placeOrder(orderId);
                    orders.add(order);
                    System.out.println("Order has been placed successfully");
                    lineBreak();

                }
                case 3->{
                    if(orders.isEmpty()){
                        System.out.println("No orders found");
                        lineBreak();
                        continue;
                    }
                    for(Order order: orders){
                        System.out.printf("ID: %d. Order Amount: %.2f \n",order.getOrderID(),order.getOrderTotal());
                    }
                    System.out.println("0. Go back");

                    System.out.print("Choose order ID to view details: ");
                    int orderId = getNaturalNumber();

                    if(orderId == 0) continue;

                    for(Order order: orders){
                        if(order.getOrderID() == orderId){
                            String summary = order.generateOrderSummary();
                            System.out.println(summary);
                        }
                    }

                }
                case 4->{
                    //Display customer details
                    System.out.printf("Id: %d Name: %s \n",customer.getCustomerID(),customer.getName());
                    lineBreak();
                }
                default-> System.out.println("Invalid input.");

            }


        }
    }

    /**
     * Displays the platform menu
     */
    static void displayMenu(){
        System.out.println("1. View Products");
        System.out.println("2. Place Orders");
        System.out.println("3. View Orders");
        System.out.println("4. My Account");
        System.out.println("0. Exit");
        lineBreak();
    }
    /**
     * Scans and get an integer from the keyboard
     * Persists until a number value is provided
     *
     * @return - The integer value from the keyboard
     */
    public static int getNaturalNumber() {
        int number;

        // Prompt user until a valid integer input is provided
        while (true) {
            if (input.hasNextInt()) {
                number = input.nextInt();

                if (number < 0) {
                    System.out.println("Value cannot be zero or negative");
                    System.out.println("Enter new value:");
                    continue;
                }
                return number; // Exit loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Consume the invalid input
            }
        }
    }

    /**
     * Adds a new line to the existing output
     */
    static void lineBreak(){
        System.out.println();//Add a new line
    }

    /**
     * Generates products that will be sold on the platform
     */
    static void generateProducts(){
        var product1 = new Product(1,"Apple 🍎",0.99);
        var product2 = new Product(2,"Mango 🥭",1.99);
        var product3 = new Product(3,"Pine Apple 🍍",3.99);
        var product4 = new Product(4,"Blue Berries 🍇",2.99);
        var product5 = new Product(5,"Water Melon 🍉",2.99);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    /**
     * Gets a product by its ID
     * @param productId The product ID
     * @return A product from the list of products or null if non matches the specified ID
     */
    static Product getProductById(int productId){
        for(Product product: products){
            if(product.getProductID() == productId) return product;
        }
       return null;
    }

    /**
     * Displays all products in the inventory
     */
    static void displayProducts(){
        for (Product product: products){
            System.out.printf("%d. %20s %.2f \n",product.getProductID(),product.getName(),product.getPrice());
        }
        System.out.println("0. Exit Products catalog");
    }

    /**
     * Finds a product by product ID and reports if it's not found
     * @param productId The product ID
     */
    static void addToCartOrReportNotFound(int productId){
        //find the product using the id
        Product foundProduct = getProductById(productId);

        if(foundProduct == null){
            System.out.println("Product not found");
            lineBreak();
        }else{
            customer.addProductToCart(foundProduct);
            System.out.println("Product added to cart");
            lineBreak();
        }
    }

    /**
     * Shows all customers cart items
     * @param customer The current customer
     */
    static void displayCartProducts(Customer customer){
        for(Product product: customer.getShoppingCart()){
            System.out.printf("%s %.2f\n",product.getName(),product.getPrice());
        }
    }

}

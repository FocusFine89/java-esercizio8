package NikitaIvanov.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    //Attributi
    protected long id;
    protected String status;
    protected LocalDate orderDate;
    protected LocalDate deliveryDate;
    protected List<Product> products;
    protected Customer customer;

    //Costruttori
    public Order(List<Product> products, Customer customer) {
        Random rndId = new Random();
        this.id = rndId.nextInt(200000, 300000);
        this.products = products;
        this.customer = customer;

    }

    //Metodi


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", products=" + products +
                '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
}

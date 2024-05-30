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
    public Order(LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        Random rndId = new Random();
        this.id = rndId.nextInt(200000, 300000);
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;

    }

    //Metodi
}

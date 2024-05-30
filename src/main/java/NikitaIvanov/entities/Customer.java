package NikitaIvanov.entities;

import java.util.Random;

public class Customer {
    //Attributi
    protected long id;
    protected String name;
    protected int tier;

    //Costruttori
    public Customer(String name, int tier) {
        Random rndId = new Random();
        this.id = rndId.nextInt(100000, 200000);
        this.name = name;
        this.tier = tier;
    }
    //Metodi

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }
}

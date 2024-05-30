package NikitaIvanov;

import NikitaIvanov.entities.Customer;
import NikitaIvanov.entities.Order;
import NikitaIvanov.entities.Product;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        //Funzione per craere Clienti
        Supplier<Customer> customerSupplier = () -> {
            Faker faker = new Faker();
            Random rndm = new Random();
            return new Customer(faker.lordOfTheRings().character(), rndm.nextInt(1, 5));
        };
        //Fine Funzione

        //Funzione Creazione Libri
        Supplier<Product> bookSupplier = () -> {
            Faker faker = new Faker();
            Random rnmd = new Random();
            return new Product(faker.book().title(), "Books", rnmd.nextDouble(1, 100));
        };
        //Fine creazione libri

        //Funzione Creazione animali
        Supplier<Product> animalSupplier = () -> {
            Faker faker = new Faker();
            Random rnmd = new Random();
            return new Product(faker.animal().name(), "Animals", rnmd.nextDouble(1, 100));
        };
        //Fine creazione animali

        //Funzione Creazione birre
        Supplier<Product> beerSupplier = () -> {
            Faker faker = new Faker();
            Random rnmd = new Random();
            return new Product(faker.beer().name(), "Beer", rnmd.nextDouble(1, 100));
        };
        //Fine creazione birre


        //Lista clienti e prodotti
        List<Customer> customerList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        List<Product> animalsProduct = new ArrayList<>();
        List<Product> beerProduct = new ArrayList<>();
        List<Product> allProductsList = new ArrayList<>();

        //Fine Lista


        //Generazione clienti, Prodotti e ordini

        for (int i = 0; i < 5; i++) {
            customerList.add(customerSupplier.get());
            productList.add(bookSupplier.get());
            animalsProduct.add(animalSupplier.get());
            beerProduct.add(beerSupplier.get());
        }

        Order ordine1 = new Order(productList, customerList.getFirst());
        Order ordine2 = new Order(productList, customerList.get(1));
        Order ordine3 = new Order(productList, customerList.get(2));
        Order ordine4 = new Order(productList, customerList.get(3));
        Order ordine5 = new Order(productList, customerList.getLast());
        orderList.add(ordine1);
        orderList.add(ordine2);
        orderList.add(ordine3);
        orderList.add(ordine4);
        orderList.add(ordine5);
        allProductsList.addAll(productList);
        allProductsList.addAll(animalsProduct);
        allProductsList.addAll(beerProduct);


        //Fine Generazione Clienti, Prodotti e ordini .


        //Esercizio 3
        List<Product> prodottiPiuCostosi = productList.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(3).toList();
        System.out.println(prodottiPiuCostosi);
        System.out.println("--------------------------------");

        //Esercizio 4
        List<List<Product>> listaPerOrdine = orderList.stream().map(prodotti -> prodotti.getProducts()).toList();

        List<Stream<Double>> MediaimportoOrdini = listaPerOrdine.stream().map(prodotti -> prodotti.stream().map(prodotto -> prodotto.getPrice())).toList();
        List<Double> prezzi = MediaimportoOrdini.stream().flatMap(stream -> stream).toList();
        double mediaPrezzi = prezzi.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println("la media di tutti gli ordini è: " + mediaPrezzi);
        System.out.println("---------------------------------");

        //Esercizio 5
        

    }
}

package com.company;

import java.util.*;

/*
Write a program that prints information about food shops in Sofia and the products they store. Until the "Revision"
command you will receive an input in the format: "{shop}, {product}, {price}"
Take in mind that if you receive a shop you already have received, you must collect its product information.
Your output must be ordered by shop name and must be in the format:
{shop}->
Product: {product}, Price: {price}
The price should be formated to one digit after the decimal point.
 */
public class ProductShopLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> groceryStores = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            groceryStores.putIfAbsent(shop, new LinkedHashMap<>());
            groceryStores.get(shop).putIfAbsent(product, price);
            input = scanner.nextLine();
        }

//        for (Map.Entry<String, LinkedHashMap<String, Double>> stores : groceryStores.entrySet()) {
////            String store = stores.getKey();
////            LinkedHashMap<String, Double> productAndPriceSet = stores.getValue();
////
////            System.out.println(store + "->");
////            for (Map.Entry<String, Double> productAndPrice : productAndPriceSet.entrySet()) {
////                String product = productAndPrice.getKey();
////                double price = productAndPrice.getValue();
////                System.out.printf("Product: %s, Price: %.1f%n", product, price);
////            }
////        }

        groceryStores.entrySet().stream().forEach(pair -> {
            System.out.printf("%s->%n", pair.getKey());
            pair.getValue().entrySet().forEach(productPrice -> {
                System.out.printf("Product: %s, Price: %.1f%n", productPrice.getKey(), productPrice.getValue());
            });
        });
    }
}

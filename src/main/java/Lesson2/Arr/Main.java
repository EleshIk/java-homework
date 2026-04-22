package Lesson2.Arr;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        System.out.println("Задание 1");
        Product product = new Product("Ноутбук", 2026, "HP", "Корея", 12000, true);
        product.infoOutputToConsole();
        System.out.println("\n");

        System.out.println("Задание 2");


        // Задание 2
        Product[] products = new Product[5];
        products[0] = new Product("Ноутбук", 2026, "HP", "Корея", 12000, true);
        products[1] = new Product("Телефон", 2025, "Iphone", "Китай", 100000, false);
        products[2] = new Product("Принтер", 2026, "Samsung", "Китай", 5000, true);
        products[3] = new Product("Холодильник", 2024, "LG", "Корея", 17000, false);
        products[4] = new Product("Чайник", 2026, "Bosch", "Китай", 120, true);

        for(Product key : products) {
            key.infoOutputToConsole();
        }
        System.out.println("\n");


        System.out.println("Задание 3");
        // Задание 3
        Park park = new Park("летучий голландец", 200, 8);
        park.printInfo();


    }
}

package Lesson2.Arr;

public class Product {
    String name;
    int data;
    String manufacturer;
    String country;
    int price;
    boolean reservationStatus;

    public Product(String name, int data, String manufacturer, String country, int price, boolean reservationStatus) {
        this.name = name;
        this.data = data;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public void infoOutputToConsole() {

        System.out.println("Товар: " + name + ", Дата: " + data +
                ", Производитель: " + manufacturer + ", Страна: " + country +
                ", Цена: " + price + ", Резерв: " + reservationStatus);
    }
}
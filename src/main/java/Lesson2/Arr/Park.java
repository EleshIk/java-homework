package Lesson2.Arr;

public class Park {
    String name;
    int price;
    int timeWork;

    public Park(String name, int price, int timeWork){
        this.name = name;
        this.price = price;
        this.timeWork = timeWork;
    }


    public void printInfo() {
        System.out.println("Аттракцион: " + name + ", " +  "Цена: " + price + ", " + "Время работы: " + timeWork );
    }
}

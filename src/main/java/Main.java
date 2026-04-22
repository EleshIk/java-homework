public class Main{
    public static void main(String[] args) {
        Cat Casper = new Cat("Casper");
        Cat Ivan = new Cat("Ivan");
        Dog Archie = new Dog("Archie");

        Casper.run(100);
        Casper.swim(0);

        Archie.run(150);
        Archie.swim(10);

        System.out.println(Cat.count);
        System.out.println(Dog.count);

        System.out.println("Всего котов: " + (Cat.count));
        System.out.println("Всего собак: " + (Cat.count));

        System.out.println("Всего животных: " + (Cat.count + Dog.count));

        Cat[] catsArray = {new Cat("Rishat"), new Cat("Zinnur"), new Cat("Marat")};

        for (var i = 0; i < catsArray.length; i++) {
            System.out.println();
            catsArray[i].eat(40);
            System.out.println("Этот кот голоден:" + catsArray[i].IsHungry);
        }

        Cat.increaseFoodBowl(100);
        for (var i = 0; i < catsArray.length; i++) {
            System.out.println();
            catsArray[i].eat(40);
            System.out.println("Этот кот голоден:" + catsArray[i].IsHungry);
        }
    }
}
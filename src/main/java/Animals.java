public class Animals {
    String name;
    int maxRunAnimals;
    int maxSwimAnimals;



    Animals (String name, int maxRunAnimals, int maxSwimAnimals) {
        this.name =  name;
        this.maxRunAnimals = maxRunAnimals;
        this.maxSwimAnimals = maxSwimAnimals;;

    }
    public void run(int maxDistanceRun){
        if (maxDistanceRun <= maxRunAnimals) {
            System.out.println(name + " пробежал " + maxDistanceRun + " метров");
        } else {
            System.out.println(name + " не может пробежать ");
        }
    }

    public void swim(int maxDistanceSwim){
        if (maxDistanceSwim <= maxRunAnimals) {
            System.out.println(name + " проплыл " + maxDistanceSwim + " метров");
        } else {
            System.out.println(name + " не может проплыть ");
        }
    }
}








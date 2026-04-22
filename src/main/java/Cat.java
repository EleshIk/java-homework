class Cat extends Animals {
    static int count = 0;

    public boolean IsHungry = true;
    static int bowl = 100;

    public void eat(int countToEat){

        if (Cat.bowl >= countToEat) {
            Cat.bowl = Cat.bowl - countToEat;
            this.IsHungry = false;
        }

    }

    static void increaseFoodBowl(int count){
        Cat.bowl = Cat.bowl + count;
    }

    Cat(String name) {
        super(name, 200, 0);

        Cat.count = Cat.count + 1;
    }
}
class Dog extends Animals{
    static int count = 0;
    Dog(String name) {
        super(name, 500, 10);
        Dog.count = Dog.count + 1;
    }
}
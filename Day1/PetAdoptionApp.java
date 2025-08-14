
class Pet {

    protected String name;
    protected int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Pet: " + name + ", Age: " + age);
    }
}

class Dog extends Pet {

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void displayInfo() {
        System.out.println("Dog: " + name + ", Age: " + age + ", Breed: " + breed);
    }
}

class Cat extends Pet {

    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cat: " + name + ", Age: " + age + ", Color: " + color);
    }
}

class Bird extends Pet {

    private boolean canTalk;

    public Bird(String name, int age, boolean canTalk) {
        super(name, age);
        this.canTalk = canTalk;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bird: " + name + ", Age: " + age + ", Can Talk: " + canTalk);
    }
}

public class PetAdoptionApp {

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Labrador");
        Cat cat = new Cat("Whiskers", 2, "White");
        Bird bird = new Bird("Polly", 1, true);

        dog.displayInfo();
        cat.displayInfo();
        bird.displayInfo();
    }
}

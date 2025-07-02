class Animal{
    String name;
    int age;


    void makesound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    void name(){
        age=5;
        name="Dogesh";
        System.out.println("Dog name is " + name);
        System.out.println("Dogesh age is " + age);
    }
    @Override
    void makesound(){
        System.out.println(name+" barks");
    }
}
class Cat extends Animal{
    void name(){
        age=5;
        name="rupa";
        System.out.println("Cat name is " + name);
        System.out.println("Rupa age is " + age);
    }
    @Override
    void makesound(){
        System.out.println(name+" meows");
    }
}
class Birds extends Animal{
    void name(){
        age=5;
        name="Surili";
        System.out.println("Birds name is " + name);
        System.out.println("Surili age is " + age);
    }
    @Override
    void makesound(){
        System.out.println(name+" chirp");
    }
}
public class AnimalHeriarchy {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name();
        dog.makesound();
        
        Cat cat = new Cat();
        cat.name();
        cat.makesound();
        
        Birds bird = new Birds();
        bird.name();
        bird.makesound();
    }
}
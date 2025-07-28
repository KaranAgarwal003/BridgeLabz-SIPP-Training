
import java.util.*;
import java.util.stream.Collectors;

// Base class for all pets
class Pet {

    private String type;
    private int age;
    private boolean isAdopted;

    public Pet(String type, int age) {
        this.type = type;
        this.age = age;
        this.isAdopted = false;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void adopt() {
        isAdopted = true;
    }

    @Override
    public String toString() {
        return type + " (Age: " + age + ", Adopted: " + isAdopted + ")";
    }
}

// Generic portal for any pet type
class PetAdoptionPortal<T extends Pet> {

    private List<T> pets = new ArrayList<>();

    // Add a pet to the portal
    public void addPet(T pet) {
        pets.add(pet);
    }

    // Filter available pets by type and age
    public List<T> filterAvailablePets(String type, int maxAge) {
        return pets.stream()
                .filter(p -> !p.isAdopted() && p.getType().equalsIgnoreCase(type) && p.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    // Display all pets
    public void displayAllPets() {
        for (T pet : pets) {
            System.out.println(pet);
        }
    }
}

public class PetAdoptionPortalDemo {

    public static void main(String[] args) {
        PetAdoptionPortal<Pet> portal = new PetAdoptionPortal<>();

        portal.addPet(new Pet("Dog", 2));
        portal.addPet(new Pet("Cat", 1));
        portal.addPet(new Pet("Dog", 5));
        portal.addPet(new Pet("Bird", 1));
        portal.addPet(new Pet("Cat", 3));

        System.out.println("All pets:");
        portal.displayAllPets();

        System.out.println("\nAvailable dogs age <= 3:");
        List<Pet> youngDogs = portal.filterAvailablePets("Dog", 3);
        for (Pet p : youngDogs) {
            System.out.println(p);
        }

        // Adopt a dog
        if (!youngDogs.isEmpty()) {
            youngDogs.get(0).adopt();
        }

        System.out.println("\nAfter adoption, available dogs age <= 3:");
        for (Pet p : portal.filterAvailablePets("Dog", 3)) {
            System.out.println(p);
        }
    }
}


import java.util.*;

// Base Item class
class Item {

    private String itemName;
    private int quantity;
    private double pricePerUnit;

    public Item(String itemName, int quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return itemName.equalsIgnoreCase(item.itemName);
    }

    @Override
    public int hashCode() {
        return itemName.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return itemName + " x" + quantity + " @ $" + pricePerUnit + " each";
    }
}

// Generic ShoppingCart for any item type
class ShoppingCart<T extends Item> {

    private Set<T> items = new HashSet<>();

    // Add item (prevent duplicates by name)
    public boolean addItem(T item) {
        if (items.contains(item)) {
            System.out.println("Duplicate item not added: " + item.getItemName());
            return false;
        }
        items.add(item);
        return true;
    }

    // Calculate total cost
    public double calculateTotal() {
        double total = 0;
        for (T item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Display all items
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class SupermarketBillingDemo {

    public static void main(String[] args) {
        ShoppingCart<Item> cart = new ShoppingCart<>();

        cart.addItem(new Item("Apple", 5, 1.2));
        cart.addItem(new Item("Shirt", 2, 15.0));
        cart.addItem(new Item("Laptop", 1, 800.0));
        cart.addItem(new Item("Apple", 3, 1.2)); // Duplicate, won't be added

        cart.displayCart();
        System.out.println("Total cost: $" + cart.calculateTotal());
    }
}

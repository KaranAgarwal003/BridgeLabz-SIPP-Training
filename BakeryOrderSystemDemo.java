
import java.util.*;

// Order class representing a bakery order
class Order {

    private String itemName;
    private int quantity;
    private String category; // e.g., cake, cookie, pastry

    public Order(String itemName, int quantity, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return itemName + " (" + category + ") x" + quantity;
    }
}

// Generic BakeryOrderSystem for any order type
class BakeryOrderSystem<T extends Order> {

    private Queue<T> orderQueue = new LinkedList<>();
    private List<T> allOrders = new ArrayList<>();

    // Add a new order
    public void addOrder(T order) {
        orderQueue.offer(order);
        allOrders.add(order);
    }

    // Deliver the next order (FIFO)
    public T deliverOrder() {
        return orderQueue.poll();
    }

    // Filter orders by category
    public List<T> filterByCategory(String category) {
        List<T> filtered = new ArrayList<>();
        for (T order : allOrders) {
            if (order.getCategory().equalsIgnoreCase(category)) {
                filtered.add(order);
            }
        }
        return filtered;
    }

    // Display all orders in queue
    public void displayQueue() {
        System.out.println("Current order queue:");
        for (T order : orderQueue) {
            System.out.println(order);
        }
    }
}

public class BakeryOrderSystemDemo {

    public static void main(String[] args) {
        BakeryOrderSystem<Order> bakery = new BakeryOrderSystem<>();

        bakery.addOrder(new Order("Chocolate Cake", 2, "Cake"));
        bakery.addOrder(new Order("Butter Cookie", 12, "Cookie"));
        bakery.addOrder(new Order("Strawberry Pastry", 4, "Pastry"));
        bakery.addOrder(new Order("Vanilla Cake", 1, "Cake"));

        bakery.displayQueue();

        System.out.println("\nDelivering orders:");
        Order delivered = bakery.deliverOrder();
        System.out.println("Delivered: " + delivered);

        bakery.displayQueue();

        System.out.println("\nAll cookie orders:");
        for (Order o : bakery.filterByCategory("Cookie")) {
            System.out.println(o);
        }
    }
}

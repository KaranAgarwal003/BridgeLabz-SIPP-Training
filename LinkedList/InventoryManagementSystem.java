
class ItemNode {

    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {

    private ItemNode head;

    // Add at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        ItemNode newNode = new ItemNode(name, id, qty, price);
        ItemNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(name, id, qty, price);
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by Item ID
    public void removeByItemId(int id) {
        if (head == null) {
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update quantity by Item ID
    public boolean updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Search by Item ID
    public ItemNode searchByItemId(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search by Item Name
    public ItemNode searchByItemName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Calculate total inventory value
    public double totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    // Display all items
    public void displayAll() {
        ItemNode temp = head;
        if (temp == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId
                    + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Sort by Item Name (ascending)
    public void sortByNameAsc() {
        head = mergeSortByName(head, true);
    }

    // Sort by Price (ascending)
    public void sortByPriceAsc() {
        head = mergeSortByPrice(head, true);
    }

    // Sort by Item Name (descending)
    public void sortByNameDesc() {
        head = mergeSortByName(head, false);
    }

    // Sort by Price (descending)
    public void sortByPriceDesc() {
        head = mergeSortByPrice(head, false);
    }

    // Merge sort by name
    private ItemNode mergeSortByName(ItemNode node, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }
        ItemNode mid = getMiddle(node);
        ItemNode nextOfMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSortByName(node, ascending);
        ItemNode right = mergeSortByName(nextOfMid, ascending);
        return sortedMergeByName(left, right, ascending);
    }

    private ItemNode sortedMergeByName(ItemNode a, ItemNode b, boolean ascending) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int cmp = a.itemName.compareToIgnoreCase(b.itemName);
        if ((ascending && cmp <= 0) || (!ascending && cmp > 0)) {
            a.next = sortedMergeByName(a.next, b, ascending);
            return a;
        } else {
            b.next = sortedMergeByName(a, b.next, ascending);
            return b;
        }
    }

    // Merge sort by price
    private ItemNode mergeSortByPrice(ItemNode node, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }
        ItemNode mid = getMiddle(node);
        ItemNode nextOfMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSortByPrice(node, ascending);
        ItemNode right = mergeSortByPrice(nextOfMid, ascending);
        return sortedMergeByPrice(left, right, ascending);
    }

    private ItemNode sortedMergeByPrice(ItemNode a, ItemNode b, boolean ascending) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if ((ascending && a.price <= b.price) || (!ascending && a.price > b.price)) {
            a.next = sortedMergeByPrice(a.next, b, ascending);
            return a;
        } else {
            b.next = sortedMergeByPrice(a, b.next, ascending);
            return b;
        }
    }

    // Utility to get middle of list
    private ItemNode getMiddle(ItemNode node) {
        if (node == null) {
            return node;
        }
        ItemNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {

    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Sample usage
        inventory.addAtEnd("Pen", 101, 50, 10.0);
        inventory.addAtBeginning("Notebook", 102, 30, 50.0);
        inventory.addAtPosition(2, "Pencil", 103, 100, 5.0);

        System.out.println("All items:");
        inventory.displayAll();

        System.out.println("\nTotal inventory value: " + inventory.totalInventoryValue());

        System.out.println("\nSort by name ascending:");
        inventory.sortByNameAsc();
        inventory.displayAll();

        System.out.println("\nSort by price descending:");
        inventory.sortByPriceDesc();
        inventory.displayAll();

        System.out.println("\nUpdate quantity for ID 101:");
        inventory.updateQuantity(101, 80);
        inventory.displayAll();

        System.out.println("\nRemove item with ID 102:");
        inventory.removeByItemId(102);
        inventory.displayAll();

        System.out.println("\nSearch by name 'Pencil':");
        ItemNode found = inventory.searchByItemName("Pencil");
        if (found != null) {
            System.out.println("Found: " + found.itemName + ", Qty: " + found.quantity);
        } else {
            System.out.println("Item not found.");
        }
    }
}

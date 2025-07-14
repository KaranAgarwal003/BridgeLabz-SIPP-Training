
class BookNode {

    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryDoublyLinkedList {

    private BookNode head;
    private BookNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            return;
        }
        if (head.bookId == bookId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }
        BookNode temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp != null) {
            if (temp == tail) {
                tail = temp.prev;
                tail.next = null;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    // Search by Book Title
    public BookNode searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search by Author
    public BookNode searchByAuthor(String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update Availability Status by Book ID
    public boolean updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display all books forward
    public void displayForward() {
        BookNode temp = head;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display all books in reverse
    public void displayReverse() {
        BookNode temp = tail;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void printBook(BookNode node) {
        System.out.println("Title: " + node.title + ", Author: " + node.author
                + ", Genre: " + node.genre + ", ID: " + node.bookId
                + ", Available: " + (node.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        // Sample usage
        library.addAtEnd("Java Programming", "James Gosling", "Education", 101, true);
        library.addAtBeginning("Harry Potter", "J.K. Rowling", "Fantasy", 102, false);
        library.addAtPosition(2, "Clean Code", "Robert Martin", "Education", 103, true);

        System.out.println("All books (forward):");
        library.displayForward();

        System.out.println("\nAll books (reverse):");
        library.displayReverse();

        System.out.println("\nTotal books: " + library.countBooks());

        System.out.println("\nUpdate availability for Book ID 102:");
        library.updateAvailability(102, true);
        library.displayForward();

        System.out.println("\nRemove Book ID 101:");
        library.removeByBookId(101);
        library.displayForward();

        System.out.println("\nSearch by title 'Clean Code':");
        BookNode found = library.searchByTitle("Clean Code");
        if (found != null) {
            System.out.println("Found: " + found.title + ", Author: " + found.author);
        } else {
            System.out.println("Book not found.");
        }
    }
}

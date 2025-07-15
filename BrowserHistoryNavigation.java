
class HistoryNode {

    String url;
    HistoryNode prev;
    HistoryNode next;

    public HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class BrowserHistory {

    private HistoryNode current;

    // Add a new page to history
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        if (current != null) {
            // Remove forward history
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
        }
        current = newNode;
    }

    // Move back in history
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Moved back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    // Move forward in history
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Moved forward to: " + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    // Display current page
    public void displayCurrent() {
        if (current != null) {
            System.out.println("Current page: " + current.url);
        } else {
            System.out.println("No page visited yet.");
        }
    }
}

public class BrowserHistoryNavigation {

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();

        history.visit("google.com");
        history.visit("github.com");
        history.visit("stackoverflow.com");
        history.displayCurrent(); // stackoverflow.com

        history.back();           // github.com
        history.displayCurrent();

        history.back();           // google.com
        history.displayCurrent();

        history.forward();        // github.com
        history.displayCurrent();

        history.visit("oracle.com"); // New visit clears forward history
        history.displayCurrent();

        history.forward();        // No next page.
    }
}

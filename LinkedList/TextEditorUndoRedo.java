
class TextStateNode {

    String content;
    TextStateNode prev;
    TextStateNode next;

    public TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class UndoRedoTextEditor {

    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode current;
    private int size;
    private final int MAX_HISTORY;

    public UndoRedoTextEditor(int maxHistory) {
        this.head = this.tail = this.current = null;
        this.size = 0;
        this.MAX_HISTORY = maxHistory;
    }

    // Add new state at end (after typing or command)
    public void addState(String content) {
        TextStateNode newNode = new TextStateNode(content);
        // If current is not at tail, remove all redo states
        if (current != null && current.next != null) {
            tail = current;
            tail.next = null;
        }
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        current = tail;
        size++;
        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: move to previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo: move to next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

public class TextEditorUndoRedo {

    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState(); // Hello World!

        editor.undo();
        editor.displayCurrentState(); // Hello World

        editor.undo();
        editor.displayCurrentState(); // Hello

        editor.redo();
        editor.displayCurrentState(); // Hello World

        editor.addState("Hello Java!");
        editor.displayCurrentState(); // Hello Java!

        // Undo beyond available history
        for (int i = 0; i < 10; i++) {
            editor.undo();
        }
        editor.displayCurrentState();

        // Redo beyond available history
        for (int i = 0; i < 10; i++) {
            editor.redo();
        }
        editor.displayCurrentState();
    }
}

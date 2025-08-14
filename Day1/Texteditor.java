
import java.util.Stack;

class TextEditors {

    private StringBuilder content = new StringBuilder();
    private Stack<String> undoStack = new Stack<>();

    // Type or append text
    public void type(String text) {
        undoStack.push(content.toString());
        content.append(text);
    }

    // Undo last operation
    public void undo() {
        if (!undoStack.isEmpty()) {
            content = new StringBuilder(undoStack.pop());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public String getContent() {
        return content.toString();
    }

    public static void Texteditor(String[] args) {
        TextEditors editor = new TextEditors();
        editor.type("Hello");
        editor.type(" World!");
        System.out.println("Content: " + editor.getContent());

        editor.undo();
        System.out.println("After undo: " + editor.getContent());

        editor.undo();
        System.out.println("After second undo: " + editor.getContent());

        editor.undo(); // Nothing to undo.
        System.out.println("After third undo: " + editor.getContent());
    }
}

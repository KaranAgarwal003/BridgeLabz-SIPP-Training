
class TaskNode {

    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {

    private TaskNode head;
    private TaskNode tail;
    private TaskNode current; // For viewing and moving to next task

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        current = head;
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            addAtBeginning(id, name, priority, dueDate);
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Remove by Task ID
    public void removeByTaskId(int id) {
        if (head == null) {
            return;
        }
        if (head.taskId == id) {
            if (head == tail) {
                head = tail = null;
                current = null;
            } else {
                head = head.next;
                tail.next = head;
                current = head;
            }
            return;
        }
        TaskNode temp = head;
        while (temp.next != head && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next.taskId == id) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            tail.next = head;
        }
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        printTask(current);
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    // Display all tasks starting from head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        TaskNode temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    private void printTask(TaskNode node) {
        System.out.println("TaskID: " + node.taskId + ", Name: " + node.taskName
                + ", Priority: " + node.priority + ", Due: " + node.dueDate);
    }
}

public class TaskSchedulerCircularList {

    public static void main(String[] args) {
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        // Sample usage
        scheduler.addAtEnd(1, "Task A", 2, "2025-07-15");
        scheduler.addAtBeginning(2, "Task B", 1, "2025-07-14");
        scheduler.addAtPosition(2, 3, "Task C", 3, "2025-07-20");

        System.out.println("All tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nView current task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMove to next task and view:");
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch for tasks with priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemove Task with ID 2:");
        scheduler.removeByTaskId(2);
        scheduler.displayAllTasks();
    }
}

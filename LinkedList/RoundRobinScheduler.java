
import java.util.*;

class ProcessNode {

    int processId;
    int burstTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinCircularList {

    private ProcessNode head;
    private ProcessNode tail;

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Remove process by ID
    public void removeProcess(int processId) {
        if (head == null) {
            return;
        }
        if (head.processId == processId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head && temp.next.processId != processId) {
            temp = temp.next;
        }
        if (temp.next.processId == processId) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            tail.next = head;
        }
    }

    // Display processes in circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("PID: " + temp.processId + ", Burst: " + temp.burstTime
                    + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            return;
        }
        int time = 0;
        int n = countProcesses();
        int[] waitingTimes = new int[n];
        int[] turnAroundTimes = new int[n];
        int[] burstTimes = new int[n];
        int[] processIds = new int[n];

        // Prepare arrays for calculation
        ProcessNode temp = head;
        int idx = 0;
        do {
            burstTimes[idx] = temp.burstTime;
            processIds[idx] = temp.processId;
            idx++;
            temp = temp.next;
        } while (temp != head);

        int completed = 0;
        int[] remainingBurst = Arrays.copyOf(burstTimes, n);
        boolean[] finished = new boolean[n];
        int lastTime = 0;

        while (completed < n) {
            boolean progress = false;
            for (int i = 0; i < n; i++) {
                if (remainingBurst[i] > 0) {
                    progress = true;
                    int execTime = Math.min(timeQuantum, remainingBurst[i]);
                    time += execTime;
                    remainingBurst[i] -= execTime;
                    if (remainingBurst[i] == 0) {
                        turnAroundTimes[i] = time;
                        waitingTimes[i] = time - burstTimes[i];
                        finished[i] = true;
                        completed++;
                    }
                }
            }
            if (!progress) {
                break;
            }
            System.out.println("After round, process states:");
            for (int i = 0; i < n; i++) {
                System.out.println("PID: " + processIds[i] + ", Remaining Burst: " + remainingBurst[i]);
            }
        }

        double avgWaiting = Arrays.stream(waitingTimes).average().orElse(0);
        double avgTurnAround = Arrays.stream(turnAroundTimes).average().orElse(0);

        System.out.println("Average Waiting Time: " + avgWaiting);
        System.out.println("Average Turn-Around Time: " + avgTurnAround);
    }

    // Count processes
    public int countProcesses() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class RoundRobinScheduler {

    public static void main(String[] args) {
        RoundRobinCircularList scheduler = new RoundRobinCircularList();

        // Sample processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial process queue:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        System.out.println("\nSimulating Round Robin with time quantum " + timeQuantum + ":");
        scheduler.simulateRoundRobin(timeQuantum);
    }
}

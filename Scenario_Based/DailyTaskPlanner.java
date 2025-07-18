
import java.util.LinkedList;

abstract class Task {

    String description;

    public Task(String description) {
        this.description = description;
    }

    public abstract void execute();
}

class Meeting extends Task {

    String time;
    String location;

    public Meeting(String description, String time, String location) {
        super(description);
        this.time = time;
        this.location = location;
    }

    @Override
    public void execute() {
        System.out.println("Meeting: " + description + " at " + time + " in " + location);
    }
}

class Workout extends Task {

    String type;
    int duration; // in minutes

    public Workout(String description, String type, int duration) {
        super(description);
        this.type = type;
        this.duration = duration;
    }

    @Override
    public void execute() {
        System.out.println("Workout: " + description + " (" + type + ") for " + duration + " minutes");
    }
}

class CodingSession extends Task {

    String project;
    int hours;

    public CodingSession(String description, String project, int hours) {
        super(description);
        this.project = project;
        this.hours = hours;
    }

    @Override
    public void execute() {
        System.out.println("Coding: " + description + " on " + project + " for " + hours + " hours");
    }
}

public class DailyTaskPlanner {

    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();

        tasks.add(new Meeting("Team Sync", "10:00 AM", "Conference Room"));
        tasks.add(new Workout("Morning Run", "Cardio", 30));
        tasks.add(new CodingSession("Implement Feature X", "PlannerApp", 2));
        tasks.add(new Meeting("Client Call", "2:00 PM", "Zoom"));

        System.out.println("Executing all tasks:");
        for (Task t : tasks) {
            t.execute();
        }

        // Search by keyword (Linear Search)
        String keyword = "Client";
        System.out.println("\nSearching for tasks with keyword: " + keyword);
        boolean found = false;
        for (Task t : tasks) {
            if (t.description.contains(keyword)) {
                t.execute();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with keyword: " + keyword);
        }
    }
}

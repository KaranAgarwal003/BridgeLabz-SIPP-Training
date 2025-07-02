class Employee{
    String name;
    int id;
    int salary;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.salary=0;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name + ", ID: " + id);
    }
}
class Manager extends Employee {
    int teamsize;
    Manager(String name, int id,int teamsize) {
        super(name, id);
        this.teamsize = teamsize;
        this.salary = 50000; // Base salary for manager
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Manage name is " + name );
        System.out.println("Manager Salary: " + salary + ", Team Size: " + teamsize);
    }
}
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, String programmingLanguage) {
        super(name, id);
        this.programmingLanguage = programmingLanguage;
        this.salary = 40000; // Base salary for developer
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Developer name is " + name);
        System.out.println("Developer Salary: " + salary + ", Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    int duration;
    Intern(String name, int id, int duration) {
        super(name, id);
        this.duration = duration;
        this.salary = 15000; // Base salary for intern
    }
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Intern name is " + name);
        System.out.println("Intern Salary: " + salary + ", Duration: " + duration + " months");
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        
        Manager manager = new Manager("Alice", 101, 5);
        manager.displayDetails();

        Developer developer = new Developer("Bob", 102, "Java");
        developer.displayDetails();

        Intern intern = new Intern("Charlie", 103, 3);
        intern.displayDetails();
    }
}
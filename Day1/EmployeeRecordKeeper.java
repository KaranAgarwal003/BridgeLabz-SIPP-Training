import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRecordKeeper {

    public static void main(String[] args) {

        // 1. Use ArrayList<Employee> to store records
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice Smith", "Engineering", 95000));
        employeeList.add(new Employee(102, "Bob Johnson", "HR", 72000));
        employeeList.add(new Employee(103, "Charlie Brown", "Engineering", 110000));
        employeeList.add(new Employee(104, "Diana Prince", "Marketing", 85000));
        employeeList.add(new Employee(105, "Ethan Hunt", "Engineering", 105000));

        System.out.println("--- Full Employee List ---");
        employeeList.forEach(System.out::println);
        System.out.println("--------------------------\n");

        // 2. Define the department to filter by
        String targetDepartment = "Engineering";

        // 3. Filter employees by department using streams
        List<Employee> filteredEmployees = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(targetDepartment))
                .collect(Collectors.toList());

        // 4. Display the filtered list
        System.out.println("--- Employees in the '" + targetDepartment + "' Department ---");
        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found in this department.");
        } else {
            filteredEmployees.forEach(System.out::println);
        }
    }
}
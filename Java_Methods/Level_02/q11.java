import java.util.Random;

public class q11 {

    static final int EMPLOYEES = 10;

    // Method 1: Generate salary and years of service
    public static int[][] generateEmployeeData() {
        int[][] data = new int[EMPLOYEES][2]; // [][0] = salary, [][1] = years of service
        Random rand = new Random();

        for (int i = 0; i < EMPLOYEES; i++) {
            int salary = 10000 + rand.nextInt(90000); // 5-digit salary
            int years = 1 + rand.nextInt(10); // 1 to 10 years
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    // Method 2: Calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        double[][] result = new double[EMPLOYEES][2]; // [][0] = bonus, [][1] = new salary

        for (int i = 0; i < EMPLOYEES; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];

            double bonus = (years > 5) ? 0.05 * salary : 0.02 * salary;
            double newSalary = salary + bonus;

            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

    // Method 3: Display table and total amounts
    public static void displayReport(int[][] employeeData, double[][] salaryBonusData) {
        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;

        System.out.printf("%-10s %-15s %-18s %-12s %-15s\n", "EmpID", "Old Salary", "Years of Service", "Bonus", "New Salary");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < EMPLOYEES; i++) {
            int empId = i + 1;
            int oldSalary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonus = salaryBonusData[i][0];
            double newSalary = salaryBonusData[i][1];

            System.out.printf("%-10d %-15d %-18d %-12.2f %-15.2f\n", empId, oldSalary, years, bonus, newSalary);

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-18s %-12.2f %-15.2f\n", "TOTAL", totalOldSalary, "", totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData();
        double[][] salaryBonusData = calculateBonusAndNewSalary(employeeData);
        displayReport(employeeData, salaryBonusData);
    }
}

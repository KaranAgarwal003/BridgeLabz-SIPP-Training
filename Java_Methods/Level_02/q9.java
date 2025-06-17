import java.util.Scanner;

public class q9 {

    // Method to return the name of the month
    public static String getMonthName(int month) {
        String[] months = { 
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December" 
        };
        return months[month - 1];
    }

    // Method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to return the number of days in a given month
    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30, 
            31, 31, 30, 31, 30, 31
        };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    // Method to get the day of the week of the 1st day of the given month and year (0=Sunday)
    public static int getFirstDayOfMonth(int month, int year) {
        // Zeller's Congruence algorithm
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int q = 1; // Day of month
        int k = year % 100;
        int j = year / 100;
        int h = (q + 13*(month + 1)/5 + k + k/4 + j/4 + 5*j) % 7;
        int dayOfWeek = ((h + 6) % 7); // To make 0=Sunday
        return dayOfWeek;
    }

    // Method to display calendar
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int days = getNumberOfDaysInMonth(month, year);
        int startDay = getFirstDayOfMonth(month, year);

        System.out.printf("     %s %d\n", monthName, year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // First loop for spacing up to start day
        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        // Loop to print the days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d", day);
            if ((day + startDay) % 7 == 0 || day == days) {
                System.out.println();
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year (e.g. 2025): ");
        int year = sc.nextInt();
        System.out.println();

        displayCalendar(month, year);
        sc.close();
    }
}

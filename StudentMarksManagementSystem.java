import java.util.Scanner;

public class StudentMarksManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();

        Student student = new Student(name, rollNumber);

        // Enter initial marks
        for (int i = 1; i <= 5; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + i + ": ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a whole number.");
                    sc.next();
                    continue;
                }

                int mark = sc.nextInt();

                if (student.setMarks(i, mark)) {
                    break;
                }
            }
        }

        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Display Student Details");
            System.out.println("2. View Report Card");
            System.out.println("3. Update Subject Marks");
            System.out.println("4. View Total and Percentage");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Name: " + student.getName());
                    System.out.println("Roll Number: " + student.getRollNumber());
                    break;

                case 2:
                    student.displayReport();
                    break;

                case 3:
                    System.out.print("Enter subject number (1-5): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid subject number.");
                        sc.next();
                        break;
                    }
                    int subject = sc.nextInt();

                    System.out.print("Enter new marks (0-100): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Marks must be a whole number.");
                        sc.next();
                        break;
                    }
                    int newMark = sc.nextInt();

                    if (student.setMarks(subject, newMark)) {
                        System.out.println("Marks updated successfully!");
                    }
                    break;

                case 4:
                    System.out.println("Total: " + student.getTotal() + "/500");
                    System.out.printf("Percentage: %.2f%%%n",
                        student.getPercentage());
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

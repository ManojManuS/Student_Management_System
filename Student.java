public class Student {

    // Private data: encapsulation
    private String name;
    private int rollNumber;
    private final int[] marks = new int[5];

    // Constructor
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    // Set marks with validation
    public boolean setMarks(int subjectNumber, int mark) {
        if (subjectNumber < 1 || subjectNumber > 5) {
            System.out.println("Invalid subject number. Choose 1 to 5.");
            return false;
        }

        if (mark < 0 || mark > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return false;
        }

        marks[subjectNumber - 1] = mark;
        return true;
    }

    // Get marks without exposing the private array
    public int getMarks(int subjectNumber) {
        if (subjectNumber < 1 || subjectNumber > 5) {
            throw new IllegalArgumentException(
                "Subject number must be between 1 and 5."
            );
        }

        return marks[subjectNumber - 1];
    }

    // Calculate total marks
    public int getTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Calculate percentage out of 500
    public double getPercentage() {
        return getTotal() / 5.0;
    }

    // Calculate grade using sample grading rules
    public String getGrade() {
        for (int mark : marks) {
            if (mark < 35) {
                return "Fail";
            }
        }

        double percentage = getPercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 75) {
            return "A";
        } else if (percentage >= 60) {
            return "B";
        } else {
            return "C";
        }
    }

    // Display report card
    public void displayReport() {
        System.out.println("\n===== STUDENT REPORT CARD =====");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        System.out.println("Total: " + getTotal() + "/500");
        System.out.printf("Percentage: %.2f%%%n", getPercentage());
        System.out.println("Grade: " + getGrade());
    }
}

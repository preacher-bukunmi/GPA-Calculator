import java.util.ArrayList;
import java.util.Scanner;

    public class Methods {
        // Define a class to represent a course
        static class Course {

            String code;
            int unit;
            int score;
            double grade;
            double gradeUnit;
            String gradeAlpha;

            // Constructor to initialize a course with provided values
            public Course( String code, int unit, int score) {

                this.code = code;
                this.unit = unit;
                this.score = score;
                // Calculate grade and grade unit based on the score
                this.grade = calculateQualityPoint(score);
                this.gradeUnit = unit * grade;
                this.gradeAlpha = calculateGradeAlpha(score);
            }
        }

        // Method to calculate quality point based on the score
        public static double calculateQualityPoint(int score) {
            if (score >= 70) {
                return 5.0;
            } else if (score >= 60) {
                return 4.0;
            } else if (score >= 50) {
                return 3.0;
            } else if (score >= 45) {
                return 2.0;
            } else if (score >= 40) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        private static String calculateGradeAlpha(double score) {
            if (score >= 70 ) {
                return "A";
            } else if (score >= 60) {
                return "B";
            } else if (score >= 50) {
                return "C";
            } else if (score >= 45) {
                return "D";
            } else {
                return "F";
            }
        }

        public static void main(String[] args) {
            // Create a Scanner object for user input
            Scanner scanner = new Scanner(System.in);
            // Create an ArrayList to store Course objects
            ArrayList<Course> courses = new ArrayList<>();

            // Loop to input course information until the user enters 'exit'
            while (true) {
                System.out.print("Enter course code (or 'exit' to finish): ");
                String courseCode = scanner.nextLine();
                if (courseCode.toLowerCase().equals("exit")) {
                    break;
                }

                System.out.print("Enter course unit: ");
                int courseUnit = scanner.nextInt();
                System.out.print("Enter course score: ");
                int courseScore = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Create a Course object and add it to the ArrayList
                Course course = new Course( courseCode, courseUnit, courseScore);
                courses.add(course);
            }

            double totalGradeUnit = 0;
            int totalCourseUnit = 0;

            // Display the header for the tabular form
            System.out.println("|----------------------------|-----------------------|------------|---------------------|");
            System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
            System.out.println("|----------------------------|-----------------------|------------|---------------------|");

            // Loop through each course, display its information, and calculate total grade units and course units
            for (Course course : courses) {
                System.out.printf("| %-27s| %-22d| %-11S|%-21d|%n",
                        course.code,course.unit,course.gradeAlpha,(int)course.gradeUnit);

                totalGradeUnit += course.gradeUnit;
                totalCourseUnit += course.unit;
            }

            // Display the footer for the tabular form
            System.out.println("|----------------------------|-----------------------|------------|---------------------|");

            // Calculate and display the GPA
            double gpa = totalGradeUnit / totalCourseUnit;
            System.out.printf("Your GPA is = %.2f to 2 decimal places.%n", gpa);
        }
    }

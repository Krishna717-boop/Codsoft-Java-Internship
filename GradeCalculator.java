import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int subjects = scan.nextInt();

        int total = 0;
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            total += scan.nextInt();
        }

        double avg = (double) total / subjects;

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", avg);
        System.out.println("Grade: " + getGrade(avg));

        scan.close();
    }

    static String getGrade(double avg) {
        if (avg >= 90)
            return "A+";
        if (avg >= 80)
            return "A";
        if (avg >= 70)
            return "B";
        if (avg >= 60)
            return "C";
        if (avg >= 50)
            return "D";
        return "F";
    }
}
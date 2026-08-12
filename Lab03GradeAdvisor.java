/*
 * COSC 1173 Programming Lab - Lab 03: Grade Advisor
 * Textbook reference: Liang, Chapter 3 (Selections)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * REQUIREMENT: every executable statement below must carry a line comment.
 */
import java.util.Scanner;

public class Lab03GradeAdvisor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates the keyboard reader

        // PART A - grade classification
        System.out.print("Enter the exam score (0-100): ");
        double score = input.nextDouble();

        // STEP 1 - TODO: if the score is below 0 OR above 100, print exactly
        //          "Invalid score" and print NOTHING else for Part A.
        //          Otherwise, run Steps 2 and 3.
        //          Use a logical OR operator to combine the two conditions.

        // STEP 2 - TODO: use a multi-way if / else if / else chain to print
        //              Letter grade: A     when score >= 90
        //              Letter grade: B     when score >= 80
        //              Letter grade: C     when score >= 70
        //              Letter grade: D     when score >= 60
        //              Letter grade: F     otherwise
        //          Order matters: test the largest boundary first.

        // STEP 3 - TODO: print "Status: PASS" when the score is 70 or higher,
        //          otherwise print "Status: FAIL". Use a two-way if-else.

        // PART B - leap year determination
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // STEP 4 - TODO: a year is a leap year when it is divisible by 4 but not
        //          by 100, OR when it is divisible by 400. Store that test in a
        //          boolean variable named isLeapYear.
        boolean isLeapYear = false;

        // STEP 5 - TODO: print either
        //              2024 is a leap year
        //          or
        //              1900 is not a leap year
        //          The year value must come from the variable, not be typed in.
    }
}

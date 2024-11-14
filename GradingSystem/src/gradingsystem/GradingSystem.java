/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gradingsystem;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GradingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Scanner object for console output
        Scanner Asmaan = new Scanner(System.in);
        
        // This flag keeps track of whether the user wants to continue using the program
        boolean continueApp = true;
        
        // The loop runs the program as long as the user wants
        while (continueApp) {
            // Ask the user to enter the number of students via a pop-up
            String studentInput = JOptionPane.showInputDialog(null, "Enter the number of students:");
            // Convert the input to an integer value
            int totalStudents = Integer.parseInt(studentInput);
            
            // Call the method to handle grading for all students
            processStudentGrades(totalStudents);
            
            // Ask the user if they want to continue. If they say yes, we keep running the program.
            int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
            continueApp = (userChoice == JOptionPane.YES_OPTION);
        }
        
        // Close the Scanner once we are done to clean up resources
        Asmaan.close();
    }

    // Method for processing student grades
    public static void processStudentGrades(int studentCount) {
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;
        int pass = 0, fail = 0;

        for (int i = 0; i < studentCount; i++) {
            int marks = -1; // Initialize marks variable

            // Loop to ensure the marks input is between 0 and 100 using JOptionPane
            while (marks < 0 || marks > 100) {
                String markInput = JOptionPane.showInputDialog(null, "Enter marks for student " + (i + 1) + " (0 - 100):");
                marks = Integer.parseInt(markInput);

                if (marks < 0 || marks > 100) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a value between 0 and 100.");
                }
            }

            // Determine the grade based on marks
            if (marks >= 90) { gradeA++; pass++; }
            else if (marks >= 80) { gradeB++; pass++; }
            else if (marks >= 70) { gradeC++; pass++; }
            else if (marks >= 60) { gradeD++; pass++; }
            else { gradeF++; fail++; }
        }

        // Display the results using Scanner output
        displayGradeResults(gradeA, gradeB, gradeC, gradeD, gradeF);
        displayPassFailResults(pass, fail);
    }

    // Method to display grade results using Scanner output
    public static void displayGradeResults(int a, int b, int c, int d, int f) {
        System.out.println("Grade A: " + a);
        System.out.println("Grade B: " + b);
        System.out.println("Grade C: " + c);
        System.out.println("Grade D: " + d);
        System.out.println("Grade F: " + f);
    }

    // Method to display pass and fail results using Scanner output
    public static void displayPassFailResults(int pass, int fail) {
        System.out.println("Passed: " + pass);
        System.out.println("Failed: " + fail);
        if (pass > fail) {
            System.out.println("Bonus to instructor!");
        } else {
            System.out.println("More students failed.");
        }
        System.out.println("Thank You For Using Asmaan System");
    }
}


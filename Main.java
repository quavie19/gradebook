/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import java.util.Scanner;

import util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();

        // Input Handling Phase
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:\n\"firstName lastName PID grade\". \nPress Enter when you are done.");
        String input = in.nextLine();
        // while statement will run until user types "DONE"
        while (!input.equals("DONE")) {
        	//while loop runs when isValid function meets all conditions 
            if (isValid(input)) {
            	// converts input into an array separated by a space 
                String[] parts = input.split(" ");
                //create and assign input to array index 
                String firstName = parts[0];
                String lastName = parts[1];
                int pid = Integer.parseInt(parts[2]);
                int grade = Integer.parseInt(parts[3]);
                //instance class variable for student class
                Student student = new Student(firstName, lastName, pid, grade);
                // adds student to gradebook array 
                gradebook.addStudent(student);
                System.out.println("Please enter the information of the next student using the same format. \nIf there is no more students, please enter the keyword \"DONE\".");
           // prints statement if isValid method is false
            } else {
                System.out.println("\033[0;31mInvalid input. Please try again.\033[0m");
            }
            // loop input runs at at end 
            input = in.nextLine();
        }

        // Command Handling Phase
        while (true) {
        	//prompts user to enter command 
            System.out.println("Please enter a new command:");
            String command = in.nextLine();
            // quits program if user enters quit 
            if (command.equals("quit")) {
                break;
            } else if (command.equals("min score")) {
                System.out.println("Minimum score: " + gradebook.calculatetMinScore());
            } else if (command.equals("min letter")) {
                System.out.println("Minimum letter grade: " + gradebook.getMinLetterGrade());
            } else if (command.equals("max score")) {
                System.out.println("Maximum score: " + gradebook.calculateMaxScore());
            } else if (command.equals("max letter")) {
                System.out.println("Maximum letter grade: " + gradebook.getMaxLetterGrade());
            } else if (command.startsWith("letter ")) {
                int pid = Integer.parseInt(command.split(" ")[1]);
                System.out.println("Letter grade for PID " + pid + ": " + gradebook.getLetterGrade(pid));
            } else if (command.startsWith("name ")) {
                int pid = Integer.parseInt(command.split(" ")[1]);
                System.out.println("Name for PID " + pid + ": " + gradebook.getName(pid));
            } else if (command.startsWith("change ")) {
                String[] parts = command.split(" ");
                int pid = Integer.parseInt(parts[1]);
                int newGrade = Integer.parseInt(parts[2]);
                gradebook.changeGrade(pid, newGrade);
                System.out.println("Grade updated for PID " + pid);
            } else if (command.equals("avg score")) {
                System.out.println("Average score: " + gradebook.calculateAvg());
            } else if (command.equals("avg letter")) {
                System.out.println("Avgerage letter grade: " + gradebook.getAvgLetter());
            } else if (command.equals("med score")) {
                System.out.println("Median score: " + gradebook.calculateMedian());
            } else if (command.equals("med letter")) {
                System.out.println("Median letter grade: " + gradebook.getMedLetter());
            } else if (command.equals("tab scores")) {
                gradebook.printTabScores();
            } else if (command.equals("tab letters")) {
                gradebook.printTabLetters();
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static boolean isValid(String input) {
        // Split the input string into parts based on spaces
        String[] parts = input.split(" ");
       // Check if the number of parts is not equal to 4
        if (parts.length != 4) {
       // If the number of parts is not 4, return false indicating invalid input
            return false;
        }
        // assigns variable place to input strings entered 
        String firstName = parts[0];
        String lastName = parts[1];
        String pidString = parts[2];
        String gradeString = parts[3];
        // checks if first name starts with a Uppercase letter followed by lower case letters 
        if (!firstName.matches("^[A-Z][a-z]*$")) {
            return false;
        }
        // checks if last name starts with Uppercase letter followed by Lowercase letters with an optional middle initial 
        if (!lastName.matches("^[A-Z][a-z]*(\\.?[A-Z][a-z]*)?$")) {
            return false;
        }
        // checks if pid number is a 7 digit number 
        if (pidString.length() != 7 || !pidString.matches("\\d+")) {
            return false;
        }

        try {
        	//converts score into integer 
            int grade = Integer.parseInt(gradeString);
            // returns false if grade is not between 0 an d1000
            if (grade < 0 || grade > 100) {
                return false;
            }
            // returns false if string cannot convert into integer 
        } catch (NumberFormatException e) {
            return false;
        }
        // returns true if input meets all conditions 
        return true;
    }
}
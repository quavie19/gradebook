/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> listOfStudents;
    // Array object
    public Gradebook() {
        listOfStudents = new ArrayList<>();
    }
    // adds students to array list 
    public void addStudent(Student student) {
        listOfStudents.add(student);
    }
    // function calculates lowest score 
    public int calculatetMinScore() {
        int minScore = Integer.MAX_VALUE;
        for (Student student : listOfStudents) {
            int score = student.getGrade().getScore();
            if (score < minScore) {
                minScore = score;
            }
        }
        return minScore;
    }
    // function calculates min grade
    public String getMinLetterGrade() {
        String minLetterGrade = "A";
        for (Student student : listOfStudents) {
            String letterGrade = student.getGrade().getLetterGrade();
            if (letterGrade.compareTo(minLetterGrade) < 0) {
                minLetterGrade = letterGrade;
            }
        }
        return minLetterGrade;
    }

    // function calculates max score 
    public int calculateMaxScore() {
        int maxScore = Integer.MIN_VALUE;
        for (Student student : listOfStudents) {
            int score = student.getGrade().getScore();
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }
    // function calculates max letter grade
    public String getMaxLetterGrade() {
        String maxLetterGrade = "F";
        for (Student student : listOfStudents) {
            String letterGrade = student.getGrade().getLetterGrade();
            if (letterGrade.compareTo(maxLetterGrade) > 0) {
                maxLetterGrade = letterGrade;
            }
        }
        return maxLetterGrade;
    }
    // function prints letter grade of entered PID number for student
    public String getLetterGrade(int pid) {
        for (Student student : listOfStudents) {
            if (student.getPid() == pid) {
                return student.getGrade().getLetterGrade();
            }
        }
        return "Student with PID " + pid + " not found.";
    }
    
    // function prints name of entered PID number for student 
    public String getName(int pid) {
        for (Student student : listOfStudents) {
            if (student.getPid() == pid) {
                return student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student with PID " + pid + " not found.";
    }
    // function that changes grade of entered PID number for student 
    public void changeGrade(int pid, int newGrade) {
        for (Student student : listOfStudents) {
            if (student.getPid() == pid) {
                student.getGrade().setScore(newGrade);
                return;
            }
        }
        System.out.println("Student with PID " + pid + " not found.");
    }

    // function that calculates average score
    public double calculateAvg() {
    	double sum = 0;
    	for(Student s: listOfStudents)
    		sum += s.getGrade().getScore();
    		return sum / listOfStudents.size();
    }
    
    //function that calculates average letter grade
    public String getAvgLetter() {
        double averageScore = calculateAvg();
        Grade grade = new Grade((int) averageScore);
        return grade.getLetterGrade();
    }
    
 


	// function that calculates median score 
    public float calculateMedian() {
    	int i = 0, n = listOfStudents.size();
    	int[] scores = new int[n];
    		for(Student s: listOfStudents)
    			scores[i++] = s.getGrade().getScore();
    			Arrays.sort(scores);
    				if (n % 2 == 0)
    					return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
    				else
    					return scores[n / 2];
    	}
    // function that calculates median letter grade
    public String getMedLetter() {
        double medianScore = calculateMedian();
        Grade grade = new Grade((int) medianScore);
        return grade.getLetterGrade();
    }

   // function prints student name, PID number and score in table 
    public void printTabScores() {
        System.out.println("First Name\tLast Name\tPID\tScore");
        for (Student student : listOfStudents) {
            System.out.println(student.getFirstName() + "\t" + student.getLastName() + "\t" + student.getPid() + "\t" + student.getGrade().getScore());
        }
    }
    // function prints student name, PID number and letter grade in table
    public void printTabLetters() {
        System.out.println("First Name\tLast Name\tPID\tLetter Grade");
        for (Student student : listOfStudents) {
            System.out.println(student.getFirstName() + "\t" + student.getLastName() + "\t" + student.getPid() + "\t" + student.getGrade().getLetterGrade());
        }
    }    
}

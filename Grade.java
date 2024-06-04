/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
	private int score;
    private String letterGrade;
// constructor takes score and calculates letter grade 
    public Grade(int score) {
        this.score = score;
        calculateLetterGrade();
    }
// letter grade function based on student score 
    private void calculateLetterGrade() {
        if (score >= 95) {
            letterGrade = "A";
        } else if (score >= 90) {
            letterGrade = "A-";
        } else if (score >= 87) {
            letterGrade = "B+";
        } else if (score >= 83) {
            letterGrade = "B";
        } else if (score >= 80) {
            letterGrade = "B-";
        } else if (score >= 77) {
            letterGrade = "C+";
        } else if (score >= 70) {
            letterGrade = "C";
        } else if (score >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
    }
// gets students score
    public int getScore() {
        return score;
    }
// gets students letter grade 
    public String getLetterGrade() {
        return letterGrade;
    }
// method that updates score and updates letter grade  
    public void setScore(int newScore) {
        this.score = newScore;
        calculateLetterGrade();
    }
}
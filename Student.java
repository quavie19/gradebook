/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    // constructor initalizes students name, pid, and score 
    public Student(String firstName, String lastName, int pid, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = new Grade(score);
    }
    // getters to retireive students information    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPid() {
        return pid;
    }
    public Grade getGrade() {
        return grade;
    }
}

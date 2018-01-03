package q4;

import java.util.ArrayList;

import q3.Student;

/**
 * Courses class which keeps track of the students enrolled.
 *
 * @author Wilburt Herrera
 * @version 2017
 */
public class Course {
    
    /**
     * Max number of students.
     */
    public static final int MAX = 5; 
    
    /**
     * Number of students in the course.
     */
    private static int numStudents;
    
    /**
     * List of students in the class.
     */
    private ArrayList<Student> studentList;
    
    /**
     * Name of the course.
     */
    private String courseName;
    
    
    /**
     * Constructs an object of type Courses.
     * @param courseName a string.
     */
    public Course(String courseName) {
        this.courseName = courseName;
        studentList = new ArrayList<Student>(MAX);
        numStudents = 0;
    }
    
    /**
     * Adds a student to the course.
     * @param student a Student object.
     */
    public void addStudent(Student student) {
        
        if (numStudents < MAX) {
            studentList.add(numStudents, student);
            numStudents++;
        } else {
            throw new IllegalArgumentException("There can only be 5 students");
        }
    }
    
    /**
     * Calculates the average of the average scores of each student.
     * @return totalAvg the average of all scores
     */
    public double average() {
        double totalAvg = 0;
        double numerator = 0;
        for (Student temp : studentList) {
            numerator += temp.average();
        }
        totalAvg = numerator / studentList.size();
        return totalAvg;
    }
    
    /**
     * Prints out the information for each student in the course.
     */
    public void roll() {
        for (Student temp : studentList) {
            System.out.println(temp.toString());
            System.out.println();
        }
    }

    /**
     * Returns the courseName for this Course.
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the courseName for this Course.
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
}

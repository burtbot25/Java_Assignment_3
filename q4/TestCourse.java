package q4;

import q3.Address;
import q3.Student;

/**
 * <p>Tests the Course class by adding 6 students then printing
 * the student list and course average.</p>
 *
 * @author Your Name goes here
 * @version 1.0
 */
public class TestCourse {
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE1 = 99;
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE2 = 88;
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE3 = 77;
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE4 = 66;
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE5 = 55;
    
    /**
     * A test score to enter for the student object.
     */
    public static final double SCORE6 = 50;
    
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Course java = new Course("Java");
        
        Address school =
            new Address("3700 Willingdon Ave.", "Burnaby", "BC", "V5G 3H2");
        
        Address hHome = 
            new Address("742 Evergreen Terrace", "Richmond", "BC", "V1A 1A1");
        Student homer = new Student("Homer", "Simpson", hHome, school,
            SCORE1, SCORE2, SCORE3);
        
        Address lHome = 
            new Address("123 Nuclear Street", "Vancouver", "BC", "V2B 2B2");
        Student lenny = new Student("Lenny", "Leonard", lHome, school,
            SCORE4, SCORE5, SCORE6);
        
        Address cHome = 
            new Address("987 Power Plant Street", "Surrey", "BC", "V3C 3C3");
        Student carl = new Student("Carl", "Carlson", cHome, school,
            SCORE1, SCORE3, SCORE6);
        
        Address bHome = 
            new Address("456 Duff Street", "New Westminster", "BC", "V4C 4D4");
        Student barney = new Student("Barney", "Gumble", bHome, school,
            SCORE2, SCORE4, SCORE5);
        
        Address mHome = 
            new Address("123 Tavern Street", "White Rock", "BC", "V5E 5E5");
        Student moe = new Student("Moe", "Szyslak", mHome, school,
            SCORE3, SCORE1, SCORE4);
        
        Address sHome = 
            new Address("123 Elementary Street", "Burnaby", "BC", "V6F 6F6");
        Student seymour = new Student("Seymour", "Skinner", sHome, school,
            SCORE3, SCORE1, SCORE4);
        
        java.addStudent(homer);
        java.addStudent(lenny);
        java.addStudent(carl);
        java.addStudent(barney);
        java.addStudent(moe);
        
        // Trying to add the 6th Student
        try {
            java.addStudent(seymour);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        java.roll();
        
        System.out.println("The course average is: " + java.average());
        
        System.out.println("Question four was called and ran sucessfully.");
    }

};

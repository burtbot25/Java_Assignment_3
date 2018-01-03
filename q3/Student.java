package q3;

/**
 * Represents a BCIT student.
 * 
 * @author Wilburt Herrera
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2017
 */
public class Student {
    
    /**
     * To select test 1 in the switch statement.
     */
    public static final int TEST1 = 1;
    
    /**
     * To select test 2 in the switch statement.
     */
    public static final int TEST2 = 2;
    
    /**
     * To select test 3 in the switch statement.
     */
    public static final int TEST3 = 3;
    
    /**
     * Number of tests.
     */
    public static final int NUM_TESTS = 3;
    
    /**
     * Default first name for no parameters.
     */
    public static final String DEFAULT_FIRST = "(No First Name)";
    
    /**
     * Default last name for no parameters.
     */
    public static final String DEFAULT_LAST = "(No Last Name)";
    
    /**
     * Default Address for no parameters.
     */
    public static final Address DEFAULT_ADDRESS 
        = new Address("(blank)", "(blank)", "(blank)", "(blank)");
    
    /**
     * First name of this student.
     */
    private String firstName;

    /**
     * Last name of this student. 
     */
    private String lastName;

    /**
     * Home address of this student. 
     */
    private Address homeAddress;

    /**
     * School address of this student.  Can be shared by other students 
     */
    private Address schoolAddress;
    
    /**
     * Test score 1.
     */
    private double testScore1;
    
    /**
     * Test score 2.
     */
    private double testScore2;
    
    /**
     * Test score 3.
     */
    private double testScore3;
    


    /**
     * Constructs a Student object that contains the specified values.
     * @param first a String representing the first name
     * @param last a String representing the last name
     * @param home an Address object containing the home address
     * @param school an Address object containing the school address
     * @param test1 a double for the first test's score
     * @param test2 a double for the second test's score
     * @param test3 a double for the third test's score
     * @throws IllegalArgumentException if names are null or empty.
     */
    public Student(String first, String last, Address home, Address school, 
        double test1, double test2, double test3) 
            throws IllegalArgumentException {
        
        if (first == null || last == null || first.equals("") 
            || last.equals("")) {
            throw new IllegalArgumentException("Names cannot be null or blank");
        } else {
            firstName = first;
            lastName = last;
        }

        homeAddress = home;
        schoolAddress = school;

        
        if (test1 >= 0 && test2 >= 0 && test3 >= 0) {
            this.testScore1 = test1;
            this.testScore2 = test2;
            this.testScore3 = test3;
        } else {
            throw new IllegalArgumentException("Test scores must be 0" 
                + "or greater");
        }
    }
    
    /**
     * <p>Constructs a Student object that initializes all instance 
     * variables to a default value.</p>
     */
    public Student() {
        firstName = DEFAULT_FIRST;
        lastName = DEFAULT_LAST;
        homeAddress = DEFAULT_ADDRESS;
        schoolAddress = DEFAULT_ADDRESS;
        this.testScore1 = 0;
        this.testScore2 = 0;
        this.testScore3 = 0;
    }
    
    /**
     * Sets a test score to the value given.
     * @param testNum an int.
     * @param score an int.
     */
    public void setTestScore(int testNum, double score) {
        if ((testNum == TEST1 || testNum == TEST2 || testNum == TEST3) 
            && score >= 0) {
            switch (testNum) {
            case TEST1 :
                testScore1 = score;
                break;
            case TEST2 :
                testScore2 = score;
                break;
            case TEST3 :
                testScore3 = score;
                break;
            default :
                break;
            }
        } else {
            throw new IllegalArgumentException("Test parameter must "
                + "be 1, 2, or 3 and score must be 0 or greater");
        }

    }
    
    /**
     * Gets the test score of the specified test.
     * @param testNum a double.
     * @return the test score of the specified test.
     */
    public double getTestScore(int testNum) {
        if (testNum == TEST1 || testNum == TEST2 || testNum == TEST3) {
            switch (testNum) {
            case TEST1 :
                return testScore1;
            case TEST2 :
                return testScore2;
            case TEST3 :
                return testScore3;
            default :
                break;
            }
        } else {
            throw new IllegalArgumentException("Test parameter must "
                    + "be 1, 2, or 3");
            }
        return testScore1;
    }
    
    /**
     * Calculates the average of the three test scores.
     * @return the average of the 3 test scores
     */
    public double average() {
        return ((testScore1 + testScore2 + testScore3) / NUM_TESTS);
    }
    
    /**
     * Returns a String description of this Student object.
     * @return description a String
     */
    public String toString() {
        String result;

        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test1 score: " + testScore1 + "\n";
        result += "Test2 score: " + testScore2 + "\n";
        result += "Test3 score: " + testScore3 + "\n";
        result += "Average test score: " + average();

        return result;
    }
}


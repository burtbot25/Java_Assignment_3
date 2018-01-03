package q3;

/**
 * <p>Tests the newly modified Student class.  Creates students and uses
 * the newly added methods.</p>
 *
 * @author Wilburt Herrera
 * @version 1.0
 */
public class TestStudent {
    
    /**
     * Test score 1..
     */
    public static final double T_SCORE1 = 97;
    
    /**
     * Test score 2.
     */
    public static final double T_SCORE2 = 95;
    
    /**
     * Test score 3.
     */
    public static final double T_SCORE3 = 85;
    
    /**
     * Test score 4.
     */
    public static final double T_SCORE4 = 100;
    
    /**
     * Test score 5.
     */
    public static final double T_SCORE5 = 94;
    
    /**
     * Test score 6.
     */
    public static final double T_SCORE6 = 91;
    
    /**
     * To select test 1.
     */
    public static final int TEST1 = 1;
    
    /**
     * To select test 2.
     */
    public static final int TEST2 = 2;
    
    /**
     * To select test 3.
     */
    public static final int TEST3 = 3;
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        try {
            // Creates the student
            Address school =
                new Address("3700 Willingdon Ave.", "Burnaby", "BC", "V5G 3H2");
            Address tHome = 
                new Address("123 Fake Street", "Richmond", "BC", "V7C 3M6");
            Student travis = new Student("Travis", "Touchdown", tHome, school,
                T_SCORE1, T_SCORE2, T_SCORE3);
            System.out.println(travis.toString());
            
            // Updating Travis' scores and prints the result
            System.out.println("Updating Travis' test scores.");
            travis.setTestScore(TEST2, T_SCORE4);
            travis.setTestScore(TEST2, T_SCORE5);
            travis.setTestScore(TEST3, T_SCORE6);
            System.out.println("Test score one is now: " 
               + travis.getTestScore(TEST1));
            System.out.println("Test score two is now: " 
               + travis.getTestScore(TEST2));
            System.out.println("Test score three is now: " 
               + travis.getTestScore(TEST3));
            System.out.println("New average is: " + travis.average());
    
            // Blank Student using zero constructor
            Student blankStudent = new Student();
            System.out.println();
            System.out.println(blankStudent.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Question three was called and ran sucessfully.");
    }
};

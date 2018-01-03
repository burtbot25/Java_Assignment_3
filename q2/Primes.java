package q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * This program prints and finds all the prime numbers between 0 and the user's
 * input by using the sieve of Eratosthenes.
 * </p>
 *
 * @author Wilburt Herrera
 * @version 1.0
 */
public class Primes {

    /**
     * Holds list of numbers.
     */
    private ArrayList<Boolean> primes;

    /**
     * Size of array.
     */
    private int upperBound;

    /**
     * Constructs an object of type Primes.
     * 
     * @param n
     *            an int.
     */
    public Primes(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Must be a positive integer");
        }
        
        this.upperBound = n;
        primes = new ArrayList<Boolean>(upperBound);
        calculatePrimes(upperBound);
    }

    /**
     * Assigns true if indexed number is prime, else false.
     * 
     * @param n
     *            and int.
     */
    private void calculatePrimes(int n) {
        // Sets array to all true
        for (int i = 0; i < n; i++) {
            primes.add(true);
        }

        // Sets 0 and 1 to false
        primes.set(0, false);
        primes.set(1, false);

        // Sets number in the array to false if not a prime
        for (int j = 2; j < upperBound; j++) {
            if (!isPrime(j)) {
                primes.set(j, false);
            }
        }
    }

    /**
     * Prints all the prime numbers in the range specified.
     */
    public void printPrimes() {
        for (int number = 0; number < upperBound; number++) {
            if (primes.get(number)) {
                System.out.print(number + "  ");
            }
        }
    }

    /**
     * Counts the number of primes.
     * 
     * @return count an int.
     */
    public int countPrimes() {
        int count = 0;
        for (int i = 0; i < upperBound; i++) {
            if (primes.get(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Determines if a given number is prime.
     * 
     * @param x
     *            an int.
     * @return boolean if number is prime.
     */
    private boolean isPrime(int x) {
        // 2 is prime
        if (x == 2) {
            return true;
        }
        // Determines if the number (greater than 2) is prime
        for (int i = 2; i <= Math.sqrt(x); i += 1) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("This program uses the sieve of Eratosthenes " 
            + "to determine which numbers are prime.");

        System.out.println("Please enter an integer for the upper bounds");
        Primes prime;
        int userInput;
        
        try {
            userInput = scan.nextInt();
            prime = new Primes(userInput);
            System.out.println("There are " + prime.countPrimes() + " primes");
            System.out.println("The prime numbers between 0 and " 
                + userInput + " are:");
            prime.printPrimes();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("Question two was called and ran sucessfully.");

        scan.close();
    }

};

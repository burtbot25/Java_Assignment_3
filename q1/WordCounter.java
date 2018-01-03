package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>This program reads a file and determines the number of
 * unique words in the file and prints the top 10 most used
 * words and their frequency.</p>
 *
 * @author Wilburt Herrera
 * @version 1.0
 */
public class WordCounter {
    
    /**
     * Top 10 most used words in the book.
     */
    public static final int TOP_TEN = 10;
    
    /**
     * ArrayList consisting of Word objects.
     */
    private ArrayList<Word> wordsArray;
    
    /**
     * Reads a book and returns the total number of unique Words
     * in the list.
     * @param fileName a String.
     * @throws FileNotFoundException for File input.
     * @return wordsArray an int.
     */
    public int parseBook(String fileName) throws FileNotFoundException {
        wordsArray = new ArrayList<Word>();
        
        Scanner fileScan = new Scanner(new File(fileName));
        wordsArray.add(new Word(fileScan.next()));
        
        while (fileScan.hasNext()) {
            String scannedWord = fileScan.next();
            if (!containsWord(scannedWord)) {
            wordsArray.add(new Word(scannedWord));
            }
        }
        fileScan.close();

        return wordsArray.size();
        
    }
    
    /**
     * Checks to see if the scanned word is in the array.
     * @param scannedWord a String
     * @return a boolean.
     */
    private boolean containsWord(String scannedWord) {
        for (Word compareWord : wordsArray) {
            if (compareWord.getWord().equalsIgnoreCase(scannedWord)) {
                compareWord.incrementFreq();
                return true;
            }
        } return false;
    }
    
    /**
     * Prints the top most used words in the file.
     * @param n an int.
     */
    public void printTopWords(int n) {
        wordsArray.sort(null);

        if (n < 0) {
            throw new IllegalArgumentException("Number must be 0 or greater");
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(wordsArray.get(i));
        }
    }
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        WordCounter wCounter = new WordCounter();
        System.out.println("Parsing book...");
        
        try {
            System.out.println("There are : " 
                + wCounter.parseBook("src/bible.txt") 
                + " unique words");
            try {
            wCounter.printTopWords(TOP_TEN);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Question one was called and ran sucessfully.");
    }
    
};

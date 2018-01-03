package q1;

/**
 * Creates a Word class.
 *
 * @author Wilburt Herrera
 * @version 2017
 */
public class Word implements Comparable<Word> {
    
    /**
     * Word to be read.
     */
    private final String word;
    
    /**
     * Frequency of the word.
     */
    private int frequency;
    
    /**
     * Constructs an object of type Word.
     * @param word a String.
     */
    public Word(String word) {
        this.word = word;
        frequency = 1;
    }

    /**
     * Returns the word for this Word.
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the frequency for this Word.
     * @return frequency
     */
    public int getFrequency() {
        return frequency;
    }
    
    /**
     * Increments frequency by one.
     */
    public void incrementFreq() {
        frequency++;
    }

    /**
     * Returns Word represented as a String.
     * @see java.lang.Object#toString()
     * @return
     */
    @Override
    public String toString() {
        return "Word [word=" + word.toLowerCase() 
            + ", frequency=" + frequency + "]";
    }

    /**
     * Compares the word's frequency and returns a value.
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param wordObj
     * @return
     */
    @Override
    public int compareTo(Word wordObj) throws IllegalArgumentException {
        if (this.frequency < wordObj.getFrequency()) {
            return 1;
        } else if (this.frequency == wordObj.getFrequency()) {
            return 0;
        } else {
            return -1;
        }
    }
}


package DF1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * This class provides functionalities to analyze a given text.
 * Users can perform various operations on the text including finding character and word counts,
 * identifying the most common character, and finding frequencies of specific characters or words.
 */
public class TextAnalysisTool {
    /**
     * The text to be analyzed
     */
    private final String text;
    /**
     * A shared Scanner object used for user input throughout the program.
     * Note that this design choice might not be optimal for real-world applications due to potential thread-safety issues. In larger applications, consider using a separate Scanner object for each instance.
     */
    static Scanner input = new Scanner(System.in);
    /**
     * Constructs a TextAnalysisTool object with the provided text.
     *
     * @param text The text to be analyzed.
     */
    TextAnalysisTool(String text) {
        this.text = text;
    }
    /**
     * Calculates and returns the total number of characters in the text, excluding whitespaces.
     *
     * @return The total number of characters in the text.
     */
    public int getCharacterCount() {
        return this.text.replaceAll("\\s", "").length();
    }
    /**
     * Calculates and returns the total number of words in the text.
     *
     * @return The total number of words in the text.
     */
    public int getWordCount() {
        return this.text.split("\\s+").length;
    }
    /**
     * Finds and returns the most common character in the text (excluding whitespaces), considering case-insensitivity.
     *
     * @return The most common character in the text, or '\0' if the text is empty.
     */
    public Character getMostCommonCharacter() {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        // Map all character frequencies to their respective characters
        for (Character c : this.text.replaceAll("\\s", "").toCharArray()) {
            characterFrequency.put(Character.toLowerCase(c), characterFrequency.getOrDefault((Character) Character.toLowerCase(c), 0) + 1);
        }

        int maxFrequency = 0;
        Character mostCommonCharacter = '\0';

        // Iterate the Hashed map to get the most frequent character
        for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommonCharacter = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostCommonCharacter;
    }
    /**
     * Finds and returns the frequency of a given character in the text (excluding whitespaces), considering case-insensitivity.
     *
     * @param inputCharacter The character to find the frequency of.
     * @return The number of occurrences of the character in the text.
     */
    public int getCharacterFrequency(Character inputCharacter) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        // Map all character frequencies to their respective characters
        for (Character c : this.text.replaceAll("\\s", "").toCharArray()) {
            characterFrequency.put(Character.toLowerCase(c), characterFrequency.getOrDefault( (Character)Character.toLowerCase(c), 0) + 1);
        }

        return characterFrequency.getOrDefault((Character)Character.toLowerCase(inputCharacter), 0);
    }
    /**
     * Finds and returns the frequency of a given word in the text, considering case-insensitivity.
     *
     * @param inputWord The word to find the frequency of.
     * @return The number of occurrences of the word in the text.
     */
    public int getWordFrequency(String inputWord) {
        int frequency = 0;
        for (String word : this.text.split("\\s+")) {
            if (word.equalsIgnoreCase(inputWord)) frequency++;
        }

        return frequency;
    }
    /**
     * Prints all unique words present in the text.
     */
    public void displayUniqueWords() {
        Map<String, Integer> wordsFrequency = new HashMap<>();

        for (String word : this.text.split("\\s+")) {
            wordsFrequency.put(word.toLowerCase(), wordsFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
        }

        // Iterate the Hashed map to get the most frequent character
        for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        String text;
        System.out.println("Welcome to Text Analysis");
        System.out.println("Enter any paragraph. Press return to stop");
        text = input.nextLine();
        var textTool = new TextAnalysisTool(text);

        // Display text analysis menu
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Character Count");
            System.out.println("2. Word Count");
            System.out.println("3. Most Common Character");
            System.out.println("4. Find character frequency");
            System.out.println("5. Find word frequency");
            System.out.println("6. Show all unique words");
            System.out.println("0. Exit");
            int option = getNaturalNumber();

            switch (option) {
                case 0:
                    isRunning = false;
                    System.out.println("Thank you for using my text analysis tool");
                    break;

                case 1:
                    System.out.println("Total characters: " + textTool.getCharacterCount());
                    break;

                case 2:
                    System.out.println("Total words: " + textTool.getWordCount());
                    break;

                case 3:
                    System.out.println("Most common character: " + textTool.getMostCommonCharacter());
                    break;

                case 4:
                    System.out.println("Enter character: ");
                    input.nextLine(); // consume newline
                    char c = input.nextLine().charAt(0);
                    System.out.println("Frequency: " + textTool.getCharacterFrequency(c));
                    break;

                case 5:
                    System.out.println("Enter word: ");
                    input.nextLine(); // consume newline
                    String word = input.nextLine();
                    System.out.println("Frequency: " + textTool.getWordFrequency(word));
                    break;

                case 6:
                    textTool.displayUniqueWords();
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    /**
     * Scans and get an integer from the keyboard
     * Persists until a number value is provided
     *
     * @return - The integer value from the keyboard
     */
    public static int getNaturalNumber() {
        int number;

        // Prompt user until a valid integer input is provided
        while (true) {
            if (input.hasNextInt()) {
                number = input.nextInt();

                if (number < 0) {
                    System.out.println("Value cannot be zero or negative");
                    System.out.println("Enter new value:");
                    continue;
                }
                return number; // Exit loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Consume the invalid input
            }
        }
    }
}

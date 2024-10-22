package A12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.Scanner;
import org.jfugue.Player;

import static java.lang.System.exit;

public class Palindromikes {
    public static void main(String[] args)
    {
        // Main method to manage the selection and execution of different functionalities
        //a
        try {
            //readig palidrome.
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a palindrome: ");
            String palindrome = in.nextLine();

            //throwig an exception if the provided string is empty.
            if (palindrome.isEmpty()) {throw new InvalidParameterException();}
            else{
                //timig and executing the function to check if the string is a palindrome.
                long timeI = System.currentTimeMillis();
                System.out.println("\n" + PalindromikesFraseis.isPalindromikiFrash(palindrome));
                long timeF = System.currentTimeMillis();
                System.out.println("a execution time in seconds: " +  (timeF - timeI)/1000.0);
            }
        }
        catch (Exception e) {
            exit(1);
        }

        //b

        //timing and executing the function that reads the input file, updates the necessary variables,
        // formats each string and checks if it's a palindrome.
        long timeI = System.currentTimeMillis();
        PalindromikesLexikou.scanDict();
        long timeF = System.currentTimeMillis();

        //printing the palindromes that were found and the execution time.
        PalindromikesLexikou.printData();
        System.out.println("b execution time in seconds: " +  (timeF - timeI)/1000.0);

        //sorting the palindrome array with merge sort and printing the result.
        PalindromikesLexikou.sort();
        PalindromikesLexikou.printPalindromes();

        //c
        int palindromeCount = PalindromikesLexikou.palindromeCount;
        String[] palindromes = PalindromikesLexikou.palindromes;

        for (int i = 0; i < palindromeCount; i++)
        {
            PalindromikesMusic.playWord(palindromes[i]);
        }
    }
}

// Class for palindrome phrase functionality
abstract class PalindromikesFraseis {
    // Method to check if the input string is a palindrome
    static boolean isPalindromikiFrash(String s)
    {
        //converting the accents into characters.
        s = Normalizer.normalize(s, Normalizer.Form.NFD);

        //replacing the accent characters with an empty string.
        s = Pattern.compile("\\p{M}").matcher(s).replaceAll("");

        //replacing any non-alphabetical character with the empty string.
        s = s.replaceAll("[^\\p{L}]", "");

        //converting everything to lowercase to compare later.
        s = s.toLowerCase();

        //a char array of the word string.
        char[] normal = s.toCharArray();

        //a char array that wll have the word in reverse.
        char[] reverse = new char[s.length()];

        boolean isPalindrome = true;

        //if the word didn't have any alphabetical character (i.e. it was all special characters and numbers).
        if (s.isEmpty()) {
            return false;
        }

        //passing the reverse of the word into the reverse array and checking if the two arrays are the same.
        for (int i = s.length() - 1; i >= 0; i--)
        {
            reverse[s.length() - 1 - i] = normal[i];
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (normal[i] != reverse[i]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}

// Class for dictionary file processing
abstract class PalindromikesLexikou {
    // Method to process the dictionary file
    static int wordCount = 0;
    static int letterCount = 0;
    static int palindromeCount = 0;
    static public String[] palindromes = new String[575_000];

    //updates the appropriate above variable for each word passed.
    static private void updateData(String word)
    {
        if (PalindromikesFraseis.isPalindromikiFrash(word))
        {
            palindromes[palindromeCount] = word;
            palindromeCount++;
        }
        wordCount++;
        letterCount += word.length();
    }

    //reads the input file checks for errors and calls updateData().
    static void scanDict()
    {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\andre\\Desktop\\java\\hy252\\A1\\Project_Templates_A1\\InteliJ_Template_A1\\src\\A12\\Resources\\gr.dic");
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                updateData(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    //prints most of the variables the assignment asks for.
    static void printData()
    {
        System.out.println("word count: " + wordCount);
        System.out.println("average word length: " + (letterCount/wordCount));
        System.out.println("palindrome count: " + palindromeCount);
        printPalindromes();
        System.out.println("palindrome percentage: " + palindromeCount * 100.0 / wordCount + "%");
    }

    //prints the palindrome array elements in easy to read format.
    static void printPalindromes()
    {
        for (int i = 0; i < palindromes.length; i++)
        {
            if (palindromes[i] != null) {
                System.out.print(palindromes[i] + " ");
                if ((i+1) % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    //merge sort that sorts a string array based on the element's string length.
    static void mergesort(String[] list, int listLength) {
        if (listLength < 2) return;

        int mid = listLength / 2;
        String[] left = new String[mid];
        String[] right = new String[listLength - mid];

        for (int i = 0; i < mid; i++)
            left[i] = list[i];

        for (int i = 0; i < listLength - mid; i++)
            right[i] = list[i + mid];

        mergesort(left, mid);
        mergesort(right, listLength - mid);

        //merge function the merge the 2 halves.
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].length() > right[j].length()) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
    }
    //calls mergesort so main() cleaner.
    static void sort(){
        mergesort(palindromes, palindromeCount);
    }
}

// Class for converting palindromic words into music
class PalindromikesMusic {
    // Method to play music for palindromic words
    static void playWord(String word)
    {
        Player player = new Player();

        int wordLength = word.length();
        char[] w = word.toCharArray();

        for (int i = 0; i < wordLength; i++){
            String note = "[" + ((int)(w[i])-885) + "]i"; //945 is 'α' in unicode.
            player.play(note);
        }
    }
}
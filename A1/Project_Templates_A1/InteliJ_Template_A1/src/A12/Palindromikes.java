package A12;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Palindromikes {
    public static void main(String[] args)
    {
        // Main method to manage the selection and execution of different functionalities
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a palindrome: ");
        String palindrome = in.nextLine();
        long timeI = System.currentTimeMillis();
        System.out.println("\n" + PalindromikesFraseis.isPalindromikiFrash(palindrome));
        long timeF = System.currentTimeMillis();
        System.out.println((timeF - timeI)/1000.0);
    }
}

// Class for palindrome phrase functionality
class PalindromikesFraseis {
    // Method to check if the input string is a palindrome
    static boolean isPalindromikiFrash(String s)
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        //System.out.println("string after normalize: " + s);
        s = Pattern.compile("\\p{M}").matcher(s).replaceAll("");
        //System.out.println("string after replacing accents: " + s);
        s = s.replaceAll("[^\\p{L}]", "");
        //System.out.println("string after removing special characters: " + s);
        s = s.toLowerCase();
        //System.out.println("string after replacing to lowercase: " + s);

        char[] normal = s.toCharArray();
        char[] reverse = new char[s.length()];
        boolean isPalindrome = true;

        if (s.isEmpty())
            throw new InvalidParameterException();

        for (int i = s.length() - 1; i >= 0; i--)
        {
            reverse[s.length() - 1 - i] = normal[i];
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (normal[i] != reverse[i]){isPalindrome = false;}
        }
        return isPalindrome;
    }
}

// Class for dictionary file processing
class PalindromikesLexikou {
    // Method to process the dictionary file
}

// Class for converting palindromic words into music
class PalindromikesMusic {
    // Method to play music for palindromic words
}
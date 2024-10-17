package A12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.Scanner;

import static java.lang.System.exit;

public class Palindromikes {
    public static void main(String[] args)
    {
        // Main method to manage the selection and execution of different functionalities
        //a
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a palindrome: ");
            String palindrome = in.nextLine();
            if (palindrome.isEmpty()) {throw new InvalidParameterException();}
            else{
                long timeI = System.currentTimeMillis();
                System.out.println("\n" + PalindromikesFraseis.isPalindromikiFrash(palindrome));
                long timeF = System.currentTimeMillis();
                System.out.println("a execution time in seconds: " +  (timeF - timeI)/1000.0);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            exit(1);
        }

        //b
        long timeI = System.currentTimeMillis();
        PalindromikesLexikou.scanDict();
        long timeF = System.currentTimeMillis();
        PalindromikesLexikou.printData();
        System.out.println("b execution time in seconds: " +  (timeF - timeI)/1000.0);
        PalindromikesLexikou.mergesort(PalindromikesLexikou.palindromes);
        PalindromikesLexikou.printPalindromes();
    }
}

// Class for palindrome phrase functionality
abstract class PalindromikesFraseis {
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

        if (s.isEmpty()) {
            return false;
        }

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
            palindromes = resizeArrray(palindromes);
            System.out.println(palindromes.length);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    static void printData()
    {
        System.out.println("word count: " + wordCount);
        System.out.println("average word length: " + (letterCount/wordCount));
        System.out.println("palindrome count: " + palindromeCount);
        printPalindromes();
        System.out.println("palindrome percentage: " + palindromeCount * 100.0 / wordCount + "%");
    }

    static void printPalindromes()
    {
        for (int i = 0; i < palindromes.length; i++)
        {
            if (palindromes[i] != null) {
                System.out.print(palindromes[i] + " ");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
    static String[] resizeArrray(String[] list){
        int realLength = 0;

        while (list[realLength] != null) {
            realLength++;
        }

        String[] result = new String[realLength];
        System.arraycopy(list, 0, result, 0, realLength);
        return result;
    }
    static String[] mergesort(String[] list)
    {
        if (list.length < 2)return list;

        int mid = list.length / 2;
        String[] left = cutArray(list, true);
        String[] right = cutArray(list,false);

        mergesort(left);
        mergesort(right);
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if (left[i].length() > right[j].length()){
                list[k] = left[i];
                i++;
            }
            else{
                list[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length){
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            list[k] = right[j];
            j++;
            k++;
        }
        return list;
    }

    static String[] cutArray(String[] list, boolean leftHalf)
    {
        String[] result = new String[list.length/2];
        if(leftHalf) {
            for (int i = 0; i < list.length / 2; i++) {
                result[i] = list[i];
            }
        }
        else{
            for (int i = list.length / 2; i < list.length; i++) {
                result[i] = list[i];
            }
        }
        return result;
    }
}

// Class for converting palindromic words into music
class PalindromikesMusic {
    // Method to play music for palindromic words
}
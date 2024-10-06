package A11;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.PrintWriter;

public class DrawDelta {

    public static void main(String[] args) {
        // Main method to handle input parameters and call appropriate methods based on mode (M)
        inputCheck(args);

        String M = args[0];
        int L = Integer.parseInt(args[1]);

        if (M.equals("c"))
        {
            consoleOut(L);
        }

    }

    static void inputCheck(String[] consoleArguments) {
        String M;
        int L;
        try{
            M = consoleArguments[0];
            L = Integer.parseInt(consoleArguments[1]);

            if (!(M.equals("c") || M.equals("w") || M.equals("f") || M.equals("g"))) {throw new Exception();}
            if (L < 3 || L > 20) {throw new Exception();}
            if (M.length() > 1) {throw new Exception();}
        }
        catch(Exception e){

            System.out.println("Error. Please provide the correct inputs.");
            return;
        }
    }

    static void consoleOut(int L)
    {
        System.out.print(new String(new char[L-1]).replace("\0", " "));
        System.out.println("*");

        for (int i = 2; i < L; i++)
        {
            System.out.print(new String(new char[L-i]).replace("\0", " "));
            System.out.print("*");
            System.out.print(new String(new char[2*i-3]).replace("\0", " "));
            System.out.println("*");
        }
        System.out.println(new String(new char[2*L-1]).replace("\0", "*")); //https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
    }
}
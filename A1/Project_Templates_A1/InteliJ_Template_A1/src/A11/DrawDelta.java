package A11;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.io.PrintWriter;

public class DrawDelta {
    public static String M;
    public static int L;

    public static void main(String[] args) {
        // Main method to handle input parameters and call appropriate methods based on mode (M)
        inputCheck(true);
        while(L>2 && L<21)
        {
            String pyramid = createPyramid();
            switch (M) //(switch instead of if) intelij AI suggestion.
            {
                    case "c" -> {
                        System.out.println(pyramid);
                        inputCheck(false);
                    }
                case "w" -> {
                    windowOut(pyramid);
                }
                case "f" -> {
                    writeOnFile(pyramid);
                    inputCheck(false);
                }
                case "g" -> {
                    guiWindow();
                    inputCheck(false);
                }
            }

        }
    }

    static void inputCheck(boolean check_Mode){
        try{
            Scanner in = new Scanner(System.in);

            if(check_Mode) {
                M = in.nextLine();
            }
            //System.out.println("M: " + M);
            L = in.nextInt();
            System.out.println("L: " + L);

            if (!(M.equals("c") || M.equals("w") || M.equals("f") || M.equals("g"))) {throw new Exception();}
            if (L < 3 || L > 20) {throw new Exception();}
            if (M.length() > 1) {throw new Exception();}
        }
        catch(Exception e){

            System.out.println("Error. Please provide the correct inputs.");
        }
    }

    static String createPyramid()
    {
        StringBuilder result;

        result = new StringBuilder(new String(new char[L - 1]).replace("\0", " "));
        result.append("*\n");

        for (int i = 2; i < L; i++)
        {
            result.append(new String(new char[L - i]).replace("\0", " "));
            result.append("*");
            result.append(new String(new char[2 * i - 3]).replace("\0", " "));
            result.append("*\n");
        }
        result.append(new String(new char[2 * L - 1]).replace("\0", "*"));

        return result.toString();
    }

//    static void consoleOut()
//    {
//        System.out.print(new String(new char[L-1]).replace("\0", " "));
//        System.out.println("*");
//
//        for (int i = 2; i < L; i++)
//        {
//            System.out.print(new String(new char[L-i]).replace("\0", " "));
//            System.out.print("*");
//            System.out.print(new String(new char[2*i-3]).replace("\0", " "));
//            System.out.println("*");
//        }
//        System.out.println(new String(new char[2*L-1]).replace("\0", "*")); //https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
//    }

    static void windowOut(String stringOut)
    {
        UIManager.put("OptionPane.messageFont", new Font(Font.MONOSPACED, Font.BOLD, 14));
        JOptionPane.showMessageDialog(null, stringOut,"Παράθυρο Εξόδου", JOptionPane.INFORMATION_MESSAGE);

    }

    static void writeOnFile(String stringOut)
    {
        PrintWriter writer;
        try{
            writer = new PrintWriter("./D.html", "UTF-8");
            writer.print("<!DOCTYPE html><html><head><meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/></head><body><pre>");
            writer.print(stringOut.replace("\n", "<br>"));
            writer.print("</pre></body></html>"); //the <pre></pre> is from chatgpt.
            writer.close();
        } catch (Exception e) {
            System.out.println("Πρόβλημα: "+e);
        }
    }

    static void guiWindow()
    {
        Frame f = new Frame("ΖωγραφίζονταςτοΔ")
        {
            public void paint (Graphics g)
            {
                Graphics2D g2 = (Graphics2D) g;
                g2.draw(new Line2D.Double(50,  300, 200, 50)); // a  line
                g2.draw(new Line2D.Double(50,  300, 350, 300));
                g2.draw(new Line2D.Double(200,  50, 350, 300));
            }
        };
        f.setSize(400,400);
        f.setVisible(true);
    }
}
package lec3;

import java.util.Arrays;

public class lec3 {
    
    public static void main(String[] args)
    {
        String[][] example = new String[6][7];
        example[0][1] = Integer.toString(2);

        System.out.println("hello");
        System.out.println(example[0][1]);
        System.out.println(Arrays.toString(args));
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author bs386
 */
public class Paragraph {
    public static void main(String args[])
    {
        String input = "the THE The sdfsdf the";
        StringBuffer op = new StringBuffer();
        Scanner scan = new Scanner(input);
        HashMap<Character,Integer> freq = new HashMap<>();
        freq.put('a',0);
        freq.put('e',0);
        freq.put('i',0);
        freq.put('o',0);
        freq.put('u',0);
        for(int i=0;i<input.length();i++)
        {
            if(freq.get(input.charAt(i)) != null)
            {
                freq.put(input.charAt(i),freq.get(input.charAt(i)) + 1);
            }
        }
        System.out.println("freq="+freq);
        while(scan.hasNext())
        {
            String curr = scan.next();
            if(curr.equals("the"))
                op.append("THE ");
            else
                op.append(curr+" ");
        }
        System.out.println("output="+op);
    }
}

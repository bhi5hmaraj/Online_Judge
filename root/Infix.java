/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import javax.swing.*;
/**
 *
 * @author bs386
 */
public class Infix {
    
    static int operation(int a,int b,char ch)
    {
        //System.out.println("a="+a+"b="+b+"ch="+ch);
        switch(ch)
        {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return (a/b);
            default:
                throw new UnsupportedOperationException("The operation "+ch+" is invalid");
        }
       
    }
    
    static int process(String str)
    {
        int len =str.length();
        
        Stack<Character> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        for(int i=0;i<len;i++)
        {
            char ch = str.charAt(i);
            if(Character.isDigit(ch))
            {
                int num =0;
                while(Character.isDigit(str.charAt(i+1)))
                {
                    num =(num*10)+ (Character.getNumericValue(str.charAt(i)));
                    i++;
                }
                num =(num*10)+ (Character.getNumericValue(str.charAt(i)));
                stk2.push(num);
            }
            else
            {
                if(ch == '(')
                    stk1.push(ch);
                else if(ch == ')')
                {
                    int b = stk2.pop();
                    int a = stk2.pop();
                    int op =operation(a ,b ,stk1.pop());
                    //System.out.println("op"+op);
                    stk2.push(op);
                    stk1.pop();
                }
                else
                    stk1.push(ch);
            }
            //System.out.println("stk1"+stk1);
            //System.out.println("stk2"+stk2);
        }
        return stk2.pop();
    }
    public static void main(String args[])
    {
        //Scanner s1 =new Scanner(System.in);
        
        String input = "((((25/5)+500)-250)*2)";
        input =   JOptionPane.showInputDialog ( "type infix expression" ); 
        JOptionPane.showMessageDialog ( null, "ANSWER = "+process(input) ); 

        
    }
    
}
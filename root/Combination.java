import java.util.Scanner;

public class Combination {
    
    private static void printCombination(String str , int r)
    {
	printCombination(str,"", r);
    }
    private static void printCombination(String curr, String buffer , int r)
    {
	if(buffer.length() == r)
	    System.out.println(buffer);
	else
	    for(int i=0,len = curr.length();i<len;i++)
		printCombination(curr.substring(i+1), buffer + curr.charAt(i), r);
    }
public static void main(String[] args) {
	Scanner s1= new Scanner(System.in);
	System.out.println("Enter a string");
	String in = s1.next();
	System.out.println("Enter number of characters to choose");
	int r = s1.nextInt();
	if(r == 0 || r > in.length())
	    throw new UnsupportedOperationException("you have entered an invalid number");
	else
	    printCombination(in, r);
	s1.close();
	}
}

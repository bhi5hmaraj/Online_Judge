
import java.util.Scanner;
public class subsets {
    
    private static void printSubsets(String str)
    {
	printSubsets(str, "");
    }
    private static void printSubsets(String curr, String buffer)
    {
	if(curr.length() == 0)
	    System.out.println(buffer.length()==0?"null":buffer);
	else
	{
	    printSubsets(curr.substring(1), buffer+curr.charAt(0));
	    printSubsets(curr.substring(1), buffer);
	}
    }
    public static void main(String[] args) {
	Scanner s1= new Scanner(System.in);
	System.out.println("Enter a string");
	String in = s1.next();
	printSubsets(in);
	s1.close();
    }
}

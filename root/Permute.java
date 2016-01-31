import java.util.Scanner;

public class Permute {

    private static void printPermutation(String str)
    {
	printPermutation(str, "");
    }
    private static void printPermutation(String curr,String buffer)
    {
	if(0 == curr.length())
	    System.out.println(buffer);
	else
	    for(int i=0;i<curr.length();i++)	    
		printPermutation(curr.substring(0, i) + curr.substring(i+1),  buffer+curr.charAt(i));
    }
    public static void main(String[] args) {
	Scanner s1= new Scanner(System.in);
	System.out.println("Enter a string");
	String in = s1.next();
	printPermutation(in);
	s1.close();
    }
}

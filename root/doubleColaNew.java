import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class doubleColaNew {
public static void main(String[] args)throws IOException {
	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	int pos = Integer.parseInt(br.readLine());
	String names[] = {null,"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
	if(pos <= 5)
		System.out.println(names[pos]);
	else
	{
		int region = (int)(Math.log(pos/5)/Math.log(2));
		/*
		 * Any position can be written as pos = (5 * 2^k) because each person keeps on doubling
		 * When we round off we get the iteration of that particular postion eg . for pos=2 we are in zeroth iteration
		 * Whereas for pos=7 we are in first Iteration
		 * 
		 *  S |
		 *  L |
		 *  P |--- Zeroth iteration
		 *  R |
		 *  H |
		 *  S
		 *  S
		 *  L
		 *  L
		 *  P
		 *  P
		 *  R
		 *  R
		 *  H
		 *  H
		 * 
		 *  We can see that it is a Geometric Progression with general term = 5 * 2^x 
		 *  So the positon
		 */
	}
}
}

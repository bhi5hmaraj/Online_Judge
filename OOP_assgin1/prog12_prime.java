import java.util.Scanner;
public class prog12_prime {
	
	static boolean isPrime(int N)
	{
		int end=(int)Math.sqrt(N);
		if(N==1)
			return false;
		for(int i=2;i<=end;i++)
			if(N%i==0)
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the number of integers");
		int end=s1.nextInt();
		int ct=0;
		for(int i=1;i<=end;i++)
		{
			if(isPrime(s1.nextInt()))
				ct++;
		}
		System.out.println("Number of primes "+ct);
	}

}

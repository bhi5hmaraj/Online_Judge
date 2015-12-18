import java.util.Scanner;
public class prog13_students {
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int N=s1.nextInt();
	int arr[]=new int[101];
	for(int i=1;i<=N;i++)
	{
		arr[s1.nextInt()]++;
	}
	System.out.println("Marks  Frequency");
	for(int i=0;i<101;i++)
	{
		if(i%10==0)
			System.out.println();
		System.out.print(i+"  -  "+arr[i]+" ");

}
}
}

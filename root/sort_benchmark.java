import java.util.*;
public class sort_benchmark {
	
	static final int RAND_MAX=100000;
	
	static String primitiveBench(int len)
	{
		int arr[] = new int [len];
		Random rnd = new Random();
		for(int i=0;i<len;i++)
		{
			//arr[i]=1000000+rnd.nextInt(RAND_MAX);       //For random 
			arr[i] = i;                                   //Already accending order
		}
		
		long start =System.nanoTime();
		Arrays.sort(arr);                                //Arrays.sort
		//arr = Arrays.stream(arr).parallel().sorted().toArray();  //Java 8 fck
		long end=System.nanoTime() - start;
		
		return "Primitive sort Time = "+(long)(end/1e6)+" ms" ;
	}
	
	static String objectBench(int len)
	{
		Integer arr[] = new Integer [len];
		Random rnd = new Random();
		for(int i=0;i<len;i++)
		{
			arr[i]=new Integer(1000000+rnd.nextInt(RAND_MAX)); // For Random
			//arr[i] = new Integer(i);           //Already Accending order
		}
		
		long start =System.nanoTime();
		Arrays.sort(arr);
		long end=System.nanoTime() - start;
		
		return "Object sort Time = "+(long)(end/1e6)+" ms" ;
	}
	
	
public static void main(String[] args) {
	final int MAX = 99999999;             //Length of array
	System.out.println(primitiveBench(MAX));
	//System.out.println(objectBench(MAX));	
}
}

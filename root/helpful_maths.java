import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class helpful_maths 
{
		static int findPos(int arr[],int start,int end)
	{
		//System.out.print("Call="+call+" start="+start+" end="+end);
		int big_start=0;int big_end=-1;
		int temp=0;
		for(int i=start;i<end;i++)
		{
			if(arr[i] > arr[end])
			{
				 if(big_end == -1)
				 {
					 big_start=i;
					 big_end=i;
				 }
				else
				 {
					big_end++;
				 }		
			}
			else
			{
				if(big_end != -1)
				{
					temp=arr[i];
					arr[i]=arr[big_start];
					arr[big_start]=temp;
					
					big_end++;
					big_start++;
				}
			}
		}
		if(big_end == -1)
		{
			//System.out.println("pivot="+end);		
			return end;
			
		}
		temp=arr[big_start];
		arr[big_start]=arr[end];
		arr[end]=temp;
		//System.out.println("pivot="+big_start);
		return big_start;
	}
		
	
	static void quickSort(int arr[],int start,int end)
	{
		if(start < end)
		
		{	
			int pivot=findPos(arr,start,end);
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
	}
	
	
	public static void main(String args[])
	{
		MyScanner s1=new MyScanner();
		StringBuffer sb = new StringBuffer();
		String str=s1.next();
		int ct=0;
		int arr[]=new int[((str.length())/2)+1];
		if(arr.length > 1)
		{
		for(int i=0;i<str.length();i++)
		{
			if(Character.isDigit(str.charAt(i)))
			{
				arr[ct]=Character.getNumericValue(str.charAt(i));
				ct++;
			}
		}
		quickSort(arr,0,arr.length-1);
		String parsed="";
		for(int i=0;i<arr.length;i++)
		{
			parsed=parsed+"+"+arr[i];
		}
		sb.append(parsed.substring(1));
			
		}
		else
			sb.append(str);
		
		System.out.println(sb);
	}
}
class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
     
    String nextLine(){
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

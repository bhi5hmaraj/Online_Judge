import java.util.*;
import java.io.*;
public class AntonCurrency
{
	public static void swap(int arr[],int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void print(int arr[],PrintWriter out)
	{
		for(int i:arr)
			out.print(i);
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        String str = s1.next();
        int len =str.length();
        int arr[] = new int[len];
        int small =Integer.MAX_VALUE,pos=-1;
        boolean flag = false;
        for(int i=0;i<len;i++)
        	arr[i] = Character.getNumericValue(str.charAt(i));
        for(int i=0;i<len-1;i++)
        {
        	if((arr[i] % 2) == 0)
        	{
        		flag = true;
        		if(arr[i] < arr[len-1])
        		{
        			swap(arr,i,len-1);
        			print(arr,out);
        			out.close();
        			return;
        		}
        		else
        		{
        			pos = i;
        		}
        	}
        }
        if(flag)
        {
        	swap(arr,pos,len-1);
        	print(arr,out);
        }
        else
        	out.println("-1");
        out.close();
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
        
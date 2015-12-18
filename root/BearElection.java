import java.util.*;
import java.io.*;
public class BearElection
{
	public static int maxElemPos(int arr[],int len)
	{
		int big=0;
		int pos=0;
		for(int i=0;i<len;i++)
		{
			if(arr[i]>big)
			{
				big=arr[i];
				pos=i;
			}
		}
		return pos;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int limak=0;
        int arr[]=new int[len-1];
        for(int i=0;i<len;i++)
        {
        	int temp=s1.nextInt();
        	if(i==0)
        		limak=temp;
        	else
        	{
        		arr[i-1]=temp;
        		
        	}
        }
        int curr=limak;
        int max_pos=maxElemPos(arr, len-1);
        int curr_max=arr[max_pos];
        if(limak>curr_max)
        {
        	out.print("0");
        	out.close();
        	return;
        }
        else
        {        	
        	while(curr<=curr_max)
        	{
        		curr++;
        		arr[max_pos]--;
        		max_pos=maxElemPos(arr, len-1);
        		curr_max=arr[max_pos];
        	}
        }
        out.println(curr-limak);        
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
        
import java.util.*;
import java.io.*;
public class AddModulo
{
	/*
	static boolean isModulo(int arr[],int index,int sum,int m,int len)    //It is a naive method , it gives a TLE
	{
		//System.out.println("SUM= "+sum+"index="+index);
		if(index>=len)
		{
			
			if(sum%m==0 && sum!=0)
				return true;
			else
				return false;
		}
		else
		{
			
			return isModulo(arr,index+1,sum+(arr[index]%m),m,len) || isModulo(arr,index+1,sum,m,len);
		}
	}
	*/      
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int len=s1.nextInt();
        int m=s1.nextInt();
        int arr[]=new int[len];
        int sum=0;
        for(int i=0;i<len;i++)
        {
        	arr[i]=s1.nextInt();
        	sum+=(arr[i]%m);
        	if(arr[i]%m==0)
        	{
        		out.println("YES");
        		return;
        	}
        }		
        if(sum%m==0)
        	out.println("YES");
        else
        {
        	if(isModulo(arr, 0, 0, m,len))
        		out.println("YES");
        	else
        		out.println("NO");
        }
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
        
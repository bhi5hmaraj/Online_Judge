import java.util.*;
import java.io.*;
class SUMTRIAN
{
	static int ct=0;
	static int maxSum(int arr[][],int sum,int i,int j)
	{
		ct++;
		if(i==arr.length-1)
		{			
			return sum+arr[i][j];
		}
		else
		{
			return Math.max(maxSum(arr,sum+arr[i][j],i+1,j), maxSum(arr,sum+arr[i][j],i+1,j+1));
		}			
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        int arr[][];        
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	arr=new int[len][len];
        	for(int i=0;i<len;i++)
        	{
        		for(int j=0;j<=i;j++)
        			arr[i][j]=s1.nextInt();
        	}
        	int big=0;
        	
        	
        	//DP starts from here
        	for(int i=1;i<len;i++)
        	{
        		for(int j=0;j<=i;j++)
        		{
        			if(j-1<0)
        				arr[i][j]+=arr[i-1][j];
        			else if(j == i)
        				arr[i][j]+=arr[i-1][j-1];
        			else
        				arr[i][j]+=Math.max(arr[i-1][j-1], arr[i-1][j]);
        			
        		}
        	}
        	//Finding the maximum from the last row
        	for(int i=0;i<len;i++)
				if(arr[len-1][i] > big)
					big=arr[len-1][i];
        	sb.append(big+"\n");
        }
        out.println(sb);
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
        
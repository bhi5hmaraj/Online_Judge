//Problem Bhallaldeva

import java.util.*;
import java.io.*;
class ICPC3
{
	static long memo[]=new long[100001];
	public static void preProcess(int arr[])
	{
		long sum=0;
		int len=arr.length;
		for(int i=0;i<len;i++)
		{
			sum+=arr[i];
			memo[i+1]=sum;
		}
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int len=s1.nextInt();
        int arr[] = new int[len];
        for(int i=0;i<len;i++)
        	arr[i]=s1.nextInt();        
        Arrays.sort(arr);
        preProcess(arr);
        int query=s1.nextInt();
        for(int i=1;i<=query;i++)
        {
        	int k= s1.nextInt();
        	sb.append(memo[len-k]+"\n");        	
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
        
import java.util.*;
import java.io.*;
class SUBINC
{
	static long numSubArray(int n)
	{
		return ((long)(n)*(long)(n+1))/2;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();        
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	int curr=0,temp=0,ct=0;
        	long sum=0;
        	for(int i=1;i<=len;i++)
        	{
        		curr=s1.nextInt();
        		if(curr>=temp)
        			ct++;
        		else
        		{
        			sum+=numSubArray(ct);
        			ct=1;
        		}
        		temp=curr;
        	}
        	sum+=numSubArray(ct);
        	sb.append(sum+"\n");
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
        
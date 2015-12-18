import java.util.*;
import java.io.*;
class FLIPCOIN
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int len = s1.nextInt();
        boolean arr[]=new boolean[len];
        int q=s1.nextInt();
        int flag,start,end,ct;
        for(int i=1;i<=q;i++)
        {
        	flag=s1.nextInt();
        	start=s1.nextInt();
        	end=s1.nextInt();
        	ct=0;
        	if(flag==0)
        	{
        		for(int j=start;j<=end;j++)
        			arr[j]=!arr[j];
        	}
        	else
        	{
        		for(int j=start;j<=end;j++)
        			if(arr[j])
        				ct++;
        		sb.append(ct+"\n");
        	}
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
        
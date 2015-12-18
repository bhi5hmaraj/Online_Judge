import java.util.*;
import java.io.*;
class TWTCLOSE
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();   
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int N=s1.nextInt();
        int k=s1.nextInt();
        String str="";
        boolean arr[]=new boolean[N+1];
        int ct=0;
        for(int i=1;i<=k;i++)
        {
        	str=s1.next();
        	if(str.equals("CLICK"))
        	{
        		int tweet=s1.nextInt();
        		if(arr[tweet])
        		{
        			arr[tweet]=false;
        			ct--;
        		}
        		else
        		{
        			arr[tweet]=true;
        			ct++;
        		}
        	}
        	else
        	{
        		for(int i1=0;i1<arr.length;i1++)
        			arr[i1]=false;
        		
        		ct=0;
        	}
        	out.println(ct);
        	
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
        
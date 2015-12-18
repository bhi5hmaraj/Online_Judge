import java.util.*;
import java.io.*;
class AMR14D
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	boolean arr[]=new boolean[1001];
        	int index;
        	int i;
        	boolean flag=false;
        	for( i=1;i<=len;i++)
        	{
        		index=s1.nextInt();
        		if(arr[index] && !flag)
        		{
        			sb.append("NO\n");
        			flag=true;
        		}
        		arr[index]=true;
        	}
        	if(!flag)
        	sb.append("YES\n");      
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
            if (st == null || st.countTokens()==0) {
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
        
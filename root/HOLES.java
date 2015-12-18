import java.util.*;
import java.io.*;
class HOLES
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	String str=s1.next();
        	int len=str.length();
        	int ct=0;
        	for(int i=0;i<len;i++)
        	{
        		char ch=str.charAt(i);
        		if(ch=='A'||ch=='D'||ch=='O'||ch=='P'||ch=='R'||ch=='Q')
        			ct++;
        		else if(ch=='B')
        			ct+=2;        		
        	}
        	sb.append(ct+"\n");
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
        
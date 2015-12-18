import java.util.*;
import java.io.*;
public class FoxSnake
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int r = s1.nextInt();
        int c = s1.nextInt();
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for(int i=1;i<=r;i++)
        {
        	if(i%2 == 0)
        	{
        		if(flag)
        		{
        			flag=false;
        			for(int j=1;j<=c;j++)
        				if(j==c)
        					sb.append("#");
        				else
        					sb.append(".");
        		}
        		else
        		{
        			flag=true;
        			for(int j=1;j<=c;j++)
        				if(j==1)
        					sb.append("#");
        				else
        					sb.append(".");
        		}
        	}
        	else
        	{
        		for(int j=1;j<=c;j++)
        			sb.append("#");
        	}
        	sb.append("\n");
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
        
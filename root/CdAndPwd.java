import java.util.*;
import java.io.*;
public class CdAndPwd
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        StringBuffer sb = new StringBuffer();
        StringBuffer curr = new StringBuffer("/");
        Stack<String> stk = new Stack<>();
        for(int i=1;i<=len;i++)
        {
        	String command = s1.next();
        	if(command.equals("pwd"))
        		sb.append(curr+"\n");
        	else
        	{
        		String path = s1.next();
        		curr = new StringBuffer("/");
        		if(path.charAt(0) == '/')
        		{
        			stk.clear();        			
        			path=path.substring(1);
        		}
        		String line[] = path.split("/");
        		for(String s:line)
        		{
        			if(s.equals(".."))
        				stk.pop();
        			else
        				stk.push(s);
        		}
        		for(String s:stk)
        			curr.append(s+"/");
        	}
        }
        out.println(sb);
        out.close();
    }
}
class MyScanner2 {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner2() {
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
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
       
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

}
        
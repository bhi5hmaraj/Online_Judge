import java.util.*;
import java.io.*;
public class Anton_and_Letters
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        String input = s1.nextLine();
        input=input.substring(1, input.length()-1);
        //out.println(input);
        String tokens[] = input.split(", ",-1);
        int ct=0;
        boolean arr[] =new boolean[26];
        for(String s:tokens)
        {
        	try
        	{
        		arr[s.trim().charAt(0)-97] = true;
        	}     
        	catch(Exception e)
        	{
        		out.println("0");
        		return;
        	
        	}
        }
        for(boolean result : arr)
        {
        	if(result)
        		ct++;
        }
        out.println(ct);
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
        
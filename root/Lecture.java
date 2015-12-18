import java.util.*;
import java.io.*;
public class Lecture
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        int m = s1.nextInt();
        Map<String,String> mp = new HashMap<>(m);   //Time 93ms
        //Map<String,String> mp = new TreeMap<>();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=m;i++)
        	mp.put(s1.next(), s1.next());
        
        for(int i=1;i<=n;i++)
        {
        	String str1 = s1.next();
        	String str2 = mp.get(str1);
        	if(str1.length() <= str2.length())
        		out.print(str1+" ");
        	else
        		out.print(str2+" ");
        }
        //out.println(sb);
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
        
import java.util.*;
import java.io.*;
public class Dubstep
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        String str = s1.next();
        String tokens[] = str.split("WUB");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<tokens.length;i++)
        {
        	if(tokens[i].length()!=0 && !tokens[i].equals(" "))
        		//sb.append(tokens[i].trim() + " ");
        		out.print(tokens[i].trim() + " ");
        }
        //out.println(Arrays.deepToString(tokens));
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
        
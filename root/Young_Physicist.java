import java.util.*;
import java.io.*;
public class Young_Physicist
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    //Time : 154ms
        //Scanner s1 =new Scanner(System.in); //Time : 186ms
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int len = s1.nextInt();
        int sum_x=0,sum_y=0,sum_z=0;
        for(int i=1;i<=len;i++)
        {
        	sum_x+=s1.nextInt();
        	sum_y+=s1.nextInt();
        	sum_z+=s1.nextInt();
        }
        if(sum_x==0 && sum_y==0 && sum_z==0)
        	out.println("YES");
        else
        	out.print("NO");
        
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
        
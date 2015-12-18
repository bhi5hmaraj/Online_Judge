import java.util.*;
import java.io.*;
public class BearPoker
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int n=s1.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
        	a[i]=s1.nextInt();
        }
        for(int i=0;i<n;i++){
        	while(a[i]%2==0)
        		a[i]/=2;
        	while(a[i]%3==0)
        		a[i]/=3;
        }
        int ct=0;
        for(int i=0;i<n-1;i++){
        	if(a[i]!=a[i+1])
        		ct=1;
        }
        if(ct==0)
        	System.out.print("YES");
        else
        	System.out.print("NO");
        
        
        
        

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
        
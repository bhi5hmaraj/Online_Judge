import java.util.*;
import java.io.*;
public class SoftDrink
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n =s1.nextInt();
        int k =s1.nextInt();
        int l =s1.nextInt();
        int c =s1.nextInt();
        int d =s1.nextInt();
        int p =s1.nextInt();
        int nl=s1.nextInt();
        int np=s1.nextInt();
        int drink = (k*l)/nl;  //cups of drink
        int lime = c*d;
        int salt = p/np;
        //int min = Math.min(drink,Math.min(lime, salt));
        int min = Min(drink,lime,salt);
        int toast = min/n;
        out.println(toast);
        out.close();
    }
    static int Min(int a,int b,int c)
    {
    	if(a<b && a<c)
    		return a;
    	else if(b<c && b<a)
    		return b;
    	else
    		return c;
    }
    static class MyScanner2 {
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
}

        
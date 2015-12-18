import java.util.*;
import java.io.*;
public class TroynacciQuery
{
	public static int add(int mod,int a,int b)
	{
		return ((a%mod)+(b%mod))%mod;
	}
	public static int multiply(int mod,int a,int b)
	{
		return ((a%mod)*(b%mod))%mod;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        StringBuffer sb = new StringBuffer();
        final int mod = (int)1e9 + 7;
        final int MAX_LEN = (int)1e5;
        int troy[] = new int[MAX_LEN + 1];
        int n =s1.nextInt();
        int q= s1.nextInt();
        int  arr[] = new int[n+1];
        int f1 = s1.nextInt() , f2 = s1.nextInt();
        final int a = s1.nextInt() , b = s1.nextInt();
        troy[1] = f1;
        troy[2] = f2;
        for(int i=3;i<=MAX_LEN;i++)
        	troy[i] = add(mod,multiply(mod,a,troy[i-2]),multiply(mod,b,troy[i-1]));
        for(int i=1;i<=n;i++)
        	arr[i] = s1.nextInt();
        for(int i=1;i<=q;i++)
        {
        	int l = s1.nextInt();
        	int r = s1.nextInt();
        	for(int j=l;j<=r;j++)
        	{
        		arr[j] = add(mod,arr[j],troy[j-l+1]);
        	}        		
        }
        for(int i=1;i<=n;i++)
        	sb.append(arr[i]+" ");
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
        
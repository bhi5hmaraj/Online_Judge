import java.util.*;
import java.io.*;
public class RandomTeams
{
	static long nCk(int n,int k)
	{
		if(n==0)
			return 0;
		if(n<k)
			return 0;
		if(n==k)
			return 1;
		long ans=1;		
		k=(int)Math.min(k, n-k);
		for(int i=1;i<=k;i++,n--)
		{
			if(n % i == 0)
			{
				ans*=(n/i);
			}
			else if(ans % i ==0)
			{
				ans=(ans/i)*n;
			}
			else
			{
				ans=(ans*n)/i;
			}
		}
		return ans;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        int m = s1.nextInt();
        long min,max;
        int q = n/m;
        int r = n%m;
        min = (m-r)*(nCk(q, 2));
        min+= nCk(q+1,2)*r;
        max = nCk(n-m+1,2);
        out.println(min+" "+max);
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
        
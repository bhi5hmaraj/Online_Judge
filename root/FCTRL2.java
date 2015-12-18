import java.util.*;
import java.io.*;
import java.math.*;
class FCTRL2
{
	static BigInteger one=new BigInteger("1");
	static String fact(int N)
	{
		if(N == 0)
		return "1";
		BigInteger f=new BigInteger("1");
		BigInteger end=new BigInteger(Integer.toString(N));
		//for(BigInteger i=new BigInteger("1");i.compareTo(end)<=0;i.add(one))
		for(int i=1;i<=N;i++)
		f=f.multiply(BigInteger.valueOf(i));
		
		return f.toString();
	}
		
		
		
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int t=s1.nextInt();
        for(int i=1;i<=t;i++)
        {
			out.println(fact(s1.nextInt()));
		}
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
 
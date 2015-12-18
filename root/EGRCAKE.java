import java.util.*;
import java.io.*;
class EGRCAKE
{
	static long n,m;
	static int f(int i)
	{
		if(i <= (n-m))
			return (int)m+i;
		else
			return (int)(i-(n-m)) ;
	}
	static long gcd(long big,long small)
	{
		 long b = Math.max(big, small);
		 long s = Math.min(big, small);
		 if(s == 0)
			 return b;
		 else
			 return gcd(s,b%s);
	}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	 n = s1.nextLong();
        	 m = s1.nextLong();
        	 if(m==1 || (n-m)==1)
        	 {
        		 sb.append("Yes\n");
        		 continue;
        	 }
        	 if(m==0)
        	 {
        		 sb.append("No 1\n");
        		 continue;
        	 }
        	 if(gcd(n,(n-m)) == 1)
        	 {
        		 sb.append("Yes\n");
        		 continue;
        	 }
        	   
        	 long lcm = (m*(n-m))/gcd(m,n-m);       //The pattern can be written as a*(m) = b*(n-m) where (a+b) gives the total robots served so if gcd(m,n-m) == 1 a=m , b=n-m so total served is n. If gcd(m,n-m) !=1 then a*m=LCM(m,n-m) && b*(n-m)=LCM so, a= LCM/n-m b=LCM/m  
        	 long a = lcm/m;
        	 long b = lcm/(n-m);
        	 sb.append("No "+(a+b)+"\n");
        	 /*
        	int pos1 = 1; int pos2 = f(1),ct=1;  //This is a bruteforce solution which resulted in a TLE
        	while(pos1 != pos2)
        	{
        		pos1 = f(pos1);
        		pos2 = f(f(pos2));
        		ct++;
        	}        	
        	if(ct == n)
        		sb.append("Yes\n");
        	else
        		sb.append("No "+ct+"\n");   
        		*/        	
        }
        out.println(sb);
        out.close();
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
        
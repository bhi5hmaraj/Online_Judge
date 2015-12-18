import java.util.*;
import java.io.*;
class FIBOSUM
{
		static int mod = 1000000007;
		public static int mul(int a,int b)
		{
			return ((a%mod)*(b%mod))%mod;
		}
		public static int add(int a,int b)
		{
			return ((a%mod)+(b%mod))%mod;
		}
		public static int sub(int a,int b)
		{
			return ((a%mod)-(b%mod))%mod;
		}
		static class Matrix
		{
			int e00,e01,e10,e11;
			Matrix(int a,int b,int c,int d)
			{
				e00=a;e01=b;e10=c;e11=d;
			}
			Matrix multiply(Matrix that)
			{
				int a=add(mul(this.e00,that.e00),mul(this.e01,that.e10));
				int b=add(mul(this.e00,that.e01),mul(this.e01,that.e11));
				int c=add(mul(this.e10,that.e00),mul(this.e11,that.e10));
				int d=add(mul(this.e10,that.e01),mul(this.e11,that.e11));
				return new Matrix(a,b,c,d);
			}
			public String toString()
			{
				return e00+" "+e01+"\n"+e10+" "+e11+"\n";
			}
		}
		public static Matrix pow(Matrix m,int b)
		{
			if(b==1)
				return m;
			else
			{
				if((b&1) == 0)
				{
					return pow(m.multiply(m),b/2);
				}
				else
				{
					return m.multiply(pow(m.multiply(m),(b-1)/2));
				}
			}
		}
		
		static int fibo(int n)
		{
			if(n==0)
				return 0;
			else if(n==1)
				return 1;
			else
			{
				Matrix base = new Matrix(1, 1, 1, 0);			
				Matrix constant = new Matrix(1, 0, 0, 0);
				base = pow(base,n-1);
				Matrix ans = base.multiply(constant);
				return ans.e00;
			}
		}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int n= s1.nextInt();
        	int m= s1.nextInt();
        	int fn=sub(fibo(m+2),fibo(n+1));
        	if(fn < 0)
        		sb.append((fn%mod)+mod+"\n");
        	else
        		sb.append(fn%mod+"\n");
        }
        out.println(sb);
        out.close();
    }
}
class MyScanner2 {
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
        
import java.util.*;
import java.io.*;
class ETF
{
	static int[] PHI(int N)
	{
		boolean marked[] =new boolean[N+1];
		int phi[] = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			phi[i] = i;
		}
		for(int i=2;i<=N;i++)
		{
			if(!marked[i])  //i is prime
			{
				phi[i] = i-1;
				for(int j=i;j<=N;j+=i)
				{
					marked[j]=true;
					phi[j] -= phi[j]/i;
				}
			}
		}
		return phi;
	}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        int phi[] = PHI((int)1e6);
        for(int z=1;z<=t;z++)
        {
        	sb.append(phi[s1.nextInt()]+"\n");
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
        
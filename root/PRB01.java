import java.util.*;
import java.io.*;
class PRB01
{
	public static ArrayList<Integer> sieve(int N)     //Sieve of Erathanoses
	{
		ArrayList<Integer> primes = new ArrayList<>();
		boolean num[] = new boolean[N+1];
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}
		for(int i=2;i<num.length;i++)
			if(!num[i])
				primes.add(i);
		
		return primes;
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        final int MAX = (int)1e5;
        ArrayList<Integer> primes = sieve(MAX);
        for(int z=1;z<=t;z++)
        {
        	if(primes.contains(s1.nextInt()))
        		sb.append("yes\n");
        	else
        		sb.append("no\n");
        }
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
        
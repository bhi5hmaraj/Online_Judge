import java.util.*;
import java.io.*;
class ADTRI                      //Use Apollonius theorem for length of median
{	
	public static ArrayList<Integer> sieve(int N)
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
        ArrayList<Integer> primes = sieve((int)5e6);
        int primes_len = primes.size();
        final int MAX = 5000001;
        boolean N[] = new boolean[MAX];
        for(int i=0;i<primes_len;i++)
        {
        	int start=primes.get(i);
        	if(start % 4 == 1)             //A perfect square can be written as sum of 2 squares if it has a prime factor of the form 4k+1
        	{
        	for(int j=start;j<MAX;j+=start)
        		N[j] = true;
        	}
        }
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int input = s1.nextInt();
        	if(N[input])
        		sb.append("YES\n");
        	else
        		sb.append("NO\n");
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
        
import java.util.*;
import java.io.*;
class KFUNC
{
	static long F(long N)
	{
		long sum = 0;
		long d = N;
		while(d > 9)
		{
			long temp = d;
			sum=0;
			while(temp > 0)
			{
				sum += (temp%10);
				temp /= 10;
			}
			d = sum;
		}
		return d;
	}
	static long sum(ArrayList<Long> pattern,long n)
	{
		if(n <= 0)
			return 0;
		long sum_pat = 0;
    	//sum_pat = pattern.stream().mapToLong(Long::longValue).sum();   //0.2s slower than direct addition 
		for(long l : pattern)
			sum_pat+=l;
    	int len = pattern.size();
    	long q = n/len ;
    	long rem = n%len;
    	if(rem == 0)
    		return sum_pat*q;
    	else
    		{
    			long s =0;
    			for(int i=0;i<=rem-1;i++)
    				s += pattern.get(i);
    			return (long)(sum_pat*q)+(long)s;
    		}
	}
    public static void main(String args[])   //the sum of digits repeats after certain interval I stored the pattern in an arraylist and manipulated the final sum (make everything as long and dont forget the case when D=0 )
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	ArrayList<Long> pattern = new ArrayList<>();
        	long A = s1.nextLong();
        	long D = s1.nextLong();
        	long L = s1.nextLong();
        	long R = s1.nextLong();
        	if(D == 0)
        	{
        		long sod = F(A);
        		long ans = (R-L+1)*sod;
        		sb.append(ans+"\n");
        		continue;
        	}
        	long start = (A%D==0)?A:A%D;
        	if(A != start)   //Adjusting L and R if they are not in sync with the actual A
        	{
        	L = L + (A/D) ;
        	R = R + (A/D) ;
        	}

        	while(!pattern.contains(F(start)))
        	{
        		pattern.add(F(start));
        		start+=D;
        	}
        	//out.println(pattern);
        	long ans =( sum(pattern,R) - sum(pattern,L-1) );
        	sb.append(ans+ "\n");  
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
        
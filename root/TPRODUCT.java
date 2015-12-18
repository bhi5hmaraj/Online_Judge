import java.util.*;
import java.io.*;
class TPRODUCT
{
    public static void main(String args[])
    {
    	final int mod = 1000000007;
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int height;
        while((height=s1.nextInt())!=0)
        {
        	int len=(1<<height)-1;
        	long arr[]=new long [len+1];
        	double log[] = new double [len+1];
        	for(int i=1;i<=len;i++)
        	{
        		arr[i]=s1.nextLong();
        		if(i > (int)(len/2))
        			log[i] = Math.log10(arr[i]);
        	}

        	for(int i=len/2;i>0;i--)     
        	{
        		int max_i;
        		if(log[2*i] > log[(2*i)+1])
        			max_i=2*i;
        		else
        			max_i=(2*i)+1;
        		
        		//log[i] = Math.log10(arr[i]) + Math.log10(arr[max_i]);
        		//                                     |
        		//    Above is wrong because arr stores the mod so you should'nt find the log of mod which resulted in WA 
        		log[i] = Math.log10(arr[i]) + log[max_i];     //This is correct
        		arr[i] = ((arr[i] % mod)*(arr[max_i] % mod)) % mod;        		 
        	}
        	sb.append((arr[1])+"\n");
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
        
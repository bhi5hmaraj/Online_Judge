import java.util.*;
import java.io.*;
public class TPrime
{
	public static boolean[] isCompositeArray(int N)     //Sieve of Erathanoses
	{
		boolean num[] = new boolean[N+1];
		num[1]=true;
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}		
		return num;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        boolean isComp[] = isCompositeArray((int)1e6);
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=len;i++)
        {
        	long num = s1.nextLong();
        	/*
        	if((num&1) == 0 && num!=4)      //Bad optimization :(
        	{
        		sb.append("NO\n");
        		continue;
        	}
        	*/
        	double root = Math.sqrt(num);        	
        	if(root == Math.floor(root))       //Check if root of num is prime
        	{
        		if(!isComp[(int)root])
        			sb.append("YES\n");
        		else
        			sb.append("NO\n");
        	}
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
        
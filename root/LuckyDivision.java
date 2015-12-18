import java.util.*;
import java.io.*;
public class LuckyDivision
{
	public static boolean isLucky(int N)
	{
		while(N>0)
		{
			if(!(N%10 ==4 || N%10 == 7))
				return false;
			
			N/=10;
		}
		return true;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int N=s1.nextInt();
        if(isLucky(N))
        {
        	out.println("YES");
        	out.close();
        	return;
        }
        else
        {
        	for(int i=N/2;i>=4;i--)
        	{
        		if((i%10 ==4 || i%10 == 7))
        		{
        		if(isLucky(i) && N%i==0)
        		{
        			out.print("YES");
        			out.close();
        			return;
        		}
        		}
        		else
        			continue;
        	}
        }
        out.println("NO");
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
        
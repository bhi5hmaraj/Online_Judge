import java.util.*;
import java.io.*;
public class DUALPAL
{
	static boolean isPalin(String str)
	{
		int len=str.length();
		int end=(len%2==0)?((len)/2)-1:((len)/2);		
		for(int i=0;i<=end;i++)
		{
			if(str.charAt(i) != str.charAt(len-i-1))
				return false;
		}
		return true;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int tests=s1.nextInt();
        int num_dupal=0;
        long limit=(long)Math.pow(2,10);
        //out.println(isPalin("1221221"));
        for(int i=1;i<=tests;i++)
        {
        	int b1=s1.nextInt();
        	int b2=s1.nextInt();
        	num_dupal=0;
        	for(long num=1;num<=limit && num_dupal<=1000;num++)
        	{
        		if(isPalin(Long.toString(num, b1)) && isPalin(Long.toString(num, b2)) )
        		{
        			num_dupal++;
        			out.print(num+" ");
        		}
        	}
        	out.println();
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
        
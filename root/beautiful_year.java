import java.util.*;
import java.io.*;
public class beautiful_year
{
	public static boolean isUnique(int N)
	{
		boolean arr[]=new boolean[10];
		int temp=N;
		while(temp>0)
		{
			if(arr[temp%10] == true)
				return false;
			else
				arr[temp%10]=true;
			temp/=10;
		}
		return true;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int low=s1.nextInt();
        low++;
        while(!isUnique(low))
        	low++;
        out.println(low);
        
        
        
        
        
        
        //out.close();     
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
        
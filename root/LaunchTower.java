import java.util.*;
import java.io.*;
class LaunchTower
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        String str=s1.next();
        int arr[] =new int[str.length()];
        for(int i=0;i<arr.length;i++)
        	arr[i]=(str.charAt(i))-'0';
        int len=arr.length;
        StringBuffer curr;
        for(int i=0;i<len;i++)
        {
        	curr=new StringBuffer(str.charAt(i));
        	for(int j=i;j<len;j++)
        	{
        		
        	}
        }

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
        
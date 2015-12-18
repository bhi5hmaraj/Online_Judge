import java.util.*;
import java.io.*;
class CLEANUP
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        StringBuffer chef,assist;
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len = s1.nextInt();
        	int q = s1.nextInt();
        	boolean arr[] = new boolean[len+1];
        	chef = new StringBuffer();
        	assist = new StringBuffer();
        	int ct=0;
        	for(int i=1;i<=q;i++)
        	{
        		arr[s1.nextInt()] = true;
        	}
        	for(int i=1;i<=len;i++)
        	{
        		if(!arr[i])
        		{
        			ct++;
        			if((ct&1) == 1)
        				chef.append(i+" ");
        			else
        				assist.append(i+" ");
        		}
        	}
        	chef.append("\n");
        	assist.append("\n");
        	sb.append(chef).append(assist);
        }
        out.println(sb);
        out.close();
    }
}
class MyScanner2 {
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
        
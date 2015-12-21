import java.util.*;
import java.io.*;
class CHEFARRP
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuilder sb=new StringBuilder();
        int t=s1.nextInt();
        while(t-->0)
        {
            int len = s1.nextInt();
            int arr[] = s1.nextIntArray(len);
            long sum = 0;
            long prd =1;
            int ct = len;
            for(int i=2;i<=len;i++)
            {
        	for(int j=0;j<=len-i;j++)
        	{
        	    sum = 0;
        	    prd =1;
        	    for(int k=j;k<j+i;k++)
        	    {
        		sum += arr[k];
        		prd *= arr[k];
        	    }
        	    if(prd == sum)
        		ct++;
        	}
            }
            sb.append(ct+"\n");
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
        
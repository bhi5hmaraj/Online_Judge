import java.util.*;
import java.io.*;
class HORSES
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len = s1.nextInt();
        	int arr[] = s1.nextIntArray(len);
        	/* O(n*log(n)) soln time:0.1s */
        	arr = Arrays.stream(arr).parallel().sorted().toArray();
        	int min = Integer.MAX_VALUE;
        	for(int i =1;i<len;i++)
        	{
        		if((arr[i]-arr[i-1]) < min)
        			min = (arr[i]-arr[i-1]);
        	}
        	sb.append(min+"\n");
        	/* O(n^2) soln time:0.63s
        	int min = Integer.MAX_VALUE;
        	for(int i=0;i<len-1;i++)
        	{
        		for(int j=i+1;j<len;j++)
        		{
        			if(Math.abs(arr[i] - arr[j]) < min)
        				min = Math.abs(arr[i] - arr[j]);
        		}
        	}
        	sb.append(min+"\n");
        	*/
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
        
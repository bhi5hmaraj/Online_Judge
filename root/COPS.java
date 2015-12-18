import java.util.*;
import java.io.*;
class COPS
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        int arr[];
        for(int z=1;z<=t;z++)
        {
        	int len = s1.nextInt();
        	int x = s1.nextInt();
        	int y = s1.nextInt();
        	arr = s1.nextIntArray(len);
        	Arrays.sort(arr);
        	int dist = x*y;
        	int houses = 0;
        	if(arr[0] != 1)
        	{
        		houses = (arr[0]-dist) > 1 ? (arr[0]-dist-1):0;
        	}
        	for(int i=1;i<len;i++)
        	{
        			if(arr[i-1]+dist < arr[i]-dist-1)
        				houses+=arr[i]-arr[i-1]-(2*dist)-1;        		
        	}
        	if(arr[len-1] != 100)
        	{
        		houses+= (100-arr[len-1] > dist)?100-dist-arr[len-1]:0;
        	}
        	sb.append(houses+"\n");
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
        
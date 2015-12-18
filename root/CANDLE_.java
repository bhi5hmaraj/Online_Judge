import java.util.*;
import java.io.*;
class CANDLE_
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int arr[] =s1.nextIntArray(10);
        	int small = Integer.MAX_VALUE,num = -1;
        	for(int i=0;i<10;i++)
        	{
        		if(arr[i] < small)
        		{
        			small = arr[i];
        			num = i;
        		}
        	}
        	if(num != 0)
        	{
        		for(int i=1;i<=small+1;i++)
        			sb.append(num);
        		sb.append("\n");
        	}
        	else
        	{
        		if(arr[1] ==0)
        			sb.append("1\n");
        		else
        		{
        			if(arr[1] == arr[0]  )
        			{
        				for(int i=1;i<=arr[1]+1;i++)
        					sb.append("1");
        				sb.append("\n");
        			}
        			else
        				sb.append((long)Math.pow(10,arr[0]+1)+"\n");
        		}
        			
        	}
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
        
import java.util.*;
import java.io.*;
public class FindMarble
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int start = s1.nextInt();
        int end = s1.nextInt();
        int arr[] =new int[len+1];
        for(int i=1;i<=len;i++)
        	arr[i] = s1.nextInt();
        boolean marked[] = new boolean[len+1];
        int id[] = new int[len+1];
        int ct=0;
        for(int i=1;i<=len;i++)
        {
        	if(!marked[i])
        	{
        		int j = i;
        		while(!marked[j])
        		{
        			marked[j] = true;
        			id[j]=ct;
        			j = arr[j];
        		}
        		ct++;
        	}        	
        }
        if(id[start] != id[end])
        	out.println("-1");
        else
        {
        	int ops = 0;
        	for(int i=start;i != end;i=arr[i])
        		ops++;
        	out.println(ops);
        }
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

        
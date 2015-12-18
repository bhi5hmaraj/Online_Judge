import java.util.*;
import java.io.*;
public class VanyaLanterns
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        int l = s1.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        	arr[i] = s1.nextInt();
        if(n==1)
        {
        	out.println(Math.max(arr[0], l-arr[0]));
        	out.close();
        	return;
        }
        int segment[] = new int[n-1];
        //arr = Arrays.stream(arr).parallel().sorted().toArray();
        Arrays.sort(arr);
        for(int i=0;i<segment.length;i++)
        	segment[i]  = arr[i+1] - arr[i] ;
        
        double max = Arrays.stream(segment).parallel().max().getAsInt() /(double)2;
        if(arr[0] != 0)
        {
        	if(max < arr[0])
        		max=arr[0];
        }
        if(arr[n-1] != l)
        {
        	if(max < (l-arr[n-1]))
        		max=(l-arr[n-1]);
        }
        out.println(max);
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
        
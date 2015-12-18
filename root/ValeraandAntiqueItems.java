import java.util.*;
import java.io.*;
public class ValeraandAntiqueItems
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        int v = s1.nextInt();
        int arr[];
        List<Integer> sellers = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
        	int len = s1.nextInt();
        	arr = s1.nextIntArray(len);
        	if(v > Arrays.stream(arr).min().getAsInt())
        		sellers.add(i);
        }
        StringBuffer sb = new StringBuffer();
        if(sellers.size() == 0)
        	sb.append("0");
        else
        {
        	sb.append(sellers.size()+"\n");
        	for(int INT:sellers)
        		sb.append(INT+" ");
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
        
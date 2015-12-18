import java.util.*;
import java.io.*;
public class arrays //Added by bhis edited by Badri
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len1=s1.nextInt();
        int len2=s1.nextInt();
        int arr1[]=new int[len1];
        int arr2[]=new int[len2];
        int m=s1.nextInt(),k=s1.nextInt();
        for(int i=0;i<len1;i++)
        	arr1[i]=s1.nextInt();
        for(int i=0;i<len2;i++)
        	arr2[i]=s1.nextInt();
        
        int ptr1=m-1;
        for(int ptr2=0;ptr2<=(len2-k);ptr2++)
        {
        	if(arr2[ptr2] > arr1[ptr1])
        	{
        		out.println("YES");
        		return;
        	}
        }
        out.println("NO");
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
        
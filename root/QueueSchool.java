import java.util.*;
import java.io.*;
public class QueueSchool
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int t = s1.nextInt();
        char arr[] = new char[len];
        String order = s1.next();
        for(int i=0;i<len;i++)
        	arr[i]=order.charAt(i);
        
        List<Integer> arl = new ArrayList<>();      
        for(int i=1;i<=t;i++)
        {
        	for(int j=0;j<len-1;j++)
        	{
        		if(arr[j]=='B' && arr[j+1]=='G')
        			arl.add(j);
        	}
        	for(int pos:arl)
        	{
        		char temp = arr[pos];
        		arr[pos] = arr[pos+1];
        		arr[pos+1] = temp;
        	}
        	arl.clear();
        }
        for(char print:arr)
        	out.print(print);
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
        
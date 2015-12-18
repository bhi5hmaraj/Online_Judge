import java.util.*;
import java.io.*;
public class Sechedule
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int len = s1.nextInt();
        int arr[]= new int[len];
        int last_one=-1;
        for(int i=0;i<len;i++)
        {
        	arr[i] = s1.nextInt();
        	if(arr[i] == 1)
        		last_one=i;
        }
        int i = 0;
        int ct_0=0,ct_1=1,sum=0;
        while(i<len && arr[i] == 0)
        	i++;
        while(i <= last_one)
        {
        	ct_0 = 0;
        	ct_1 = 0;
        	while(i<=last_one && arr[i]==0)
        	{
        		ct_0++;
        		i++;
        	}
        	while(i<=last_one && arr[i]==1)
        	{
        		ct_1++;
        		i++;
        	}
        	sum+=ct_1;
        	if(ct_0 == 1)
        		sum+=1;
        }
        		
        out.println(sum);
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
        
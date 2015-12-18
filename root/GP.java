import java.util.*;
import java.io.*;
public class GP
{             

    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int k=s1.nextInt();
        int arr[]=new int[len];
        int temp=0;
        int ct=0;
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt(); 
        }
        //out.println("ct"+ct);
        int ct_left=0,ct_right=0;
        int curr=0;
        int numseq=0;
        for(int i=1;i<len-1;i++)
        {
            curr=arr[i];
            ct_left=0;
            ct_right=0;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j]*k == curr)
                    ct_left++;
            }
            if(ct_left == 0)
                continue;
            
            for(int j=i+1;j<len;j++)
            {
                if(curr*k == arr[j])
                    ct_right++;
            }
            numseq+=(ct_left*ct_right);
        }        
        out.print(numseq);      
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
        
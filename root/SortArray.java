import java.util.*;
import java.io.*;
public class SortArray
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int arr[] = new int [len+2];
        arr[0] = Integer.MIN_VALUE;
        arr[len+1] = Integer.MAX_VALUE;
        for(int i=1;i<=len;i++)        
        	arr[i] = s1.nextInt();        
        //boolean started = false;
        boolean flag = true;
        int start=1,end=1;
        boolean started =false;
        for(int i=1;i<=len;i++)
        {
        	if(arr[i+1] < arr[i])
        	{
        			if(!started)
        			{
        				started = true;
        				start = i;
        				while(i<len && arr[i] > arr[i+1])
        					i++;
        				end = i;
        				if(arr[start-1]<arr[end] && arr[start] < arr[end+1])
        				{
        					flag=true;
        				}
        				else
        				{
        					flag=false;
        				}
        			}
        			else
        			{
        				flag=false;
        				break;
        			}
        	}
        }
        if(flag)
        	out.println("yes\n"+start+" "+end);
        else
        	out.println("no");
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
        
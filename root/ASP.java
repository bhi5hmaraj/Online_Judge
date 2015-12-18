import java.util.*;
import java.io.*;
class ASP
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len = s1.nextInt();
        	int arr[] =new int[len+1];
        	for(int i=1;i<=len;i++)
        		arr[i] =s1.nextInt();
        	boolean flag =true;
        	outer:
        	for(int i=0;i<len-1;i++)     //Check like insertion sort whether a pos differs by at most 1
        	{
        		int ct=0;
        		int temp=arr[i];
        		int j=i;
        		while(j<len-1 && temp > arr[j+1])
        		{
        			j++;        			
        			ct++;
        			if(ct>1)
        			{
        				sb.append("NO\n");
        				flag = false;
        				break outer;
        			}
        		}
        	}
        	if(flag)
        		sb.append("YES\n");
        }
        out.println(sb);
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
        
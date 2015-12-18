import java.util.*;
import java.io.*;
class DONUTS_sappai
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int nums=s1.nextInt();
        	int len=s1.nextInt();
        	int arr[]=new int[len];
        	for(int i=0;i<len;i++)
        		arr[i]=s1.nextInt();
        	Arrays.sort(arr);
        	int f=0;
        	int l=len-1;
        	int ct=0;
        	outer:
        	while(f!=l)
        	{
        		while(arr[f]!=0)
        		{
        			arr[f]--;
        			l--;
        			ct++;
        			if(f==l)
        				break outer;
        		}
        		f++;        		
        	}
        	sb.append(ct+"\n");        
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
        
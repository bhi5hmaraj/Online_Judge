import java.util.*;
import java.io.*;
class MSTEP_sappai
{
	private static class element
	{
		int r,c;
		element(int r,int c)
		{
			this.r=r;
			this.c=c;
		}
		public String toString()
		{
			return "("+r+", "+c+") ";
		}
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	int steps=0;
        	element arr[]=new element[(len*len)+1]; 
        	for(int i=1;i<=len;i++)
        	{
        		for(int j=1;j<=len;j++)
        		{
        			int temp=s1.nextInt();
        			arr[temp]=new element(i,j);
        		}
        	}
        	
        	/*for(element x:arr)
        		out.println(x);*/
        	for(int i=1;i<(len*len);i++)
        	{
        		steps+=(int)((int)Math.abs(arr[i].r-arr[i+1].r)+(int)Math.abs(arr[i].c-arr[i+1].c));     
        		//out.println(steps);
        	}
        	sb.append(steps+"\n");
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
        
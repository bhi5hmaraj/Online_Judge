import java.util.*;
import java.io.*;
class CLOST
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int T=s1.nextInt();
        char arr[];        
        for(int z=1;z<=T;z++)
        {
			int len=s1.nextInt();
			arr=new char[len];
			int rem=0;
			for(int i=0;i<len;i++)
			{
				if(rem == 0)
				{
					rem++;
					arr[i]='(';
				}
				else
				{
					rem--;
					arr[i]=')';
				}
			}
			rem=0;
			for(int nq=s1.nextInt();nq>0;nq--)
			{
				 int x=s1.nextInt();
				 int y=s1.nextInt();			
					for(int i=x;i<=y;i++)
					 {
						 	if(rem == 0)
							{
								rem++;
								arr[i]='(';
							}
							else
							{
								rem--;
								arr[i]=')';
							}
								
						 
					 }
			 }
			 for(int k=0;k<len;k++)
			 {	
				if(arr[k] == '\u0000')
				out.print("("); 			 
				else
				out.print(arr[k]);
			 
 
			}
		out.println();
		}
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
import java.util.*;
import java.io.*;
class TWOSTR
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int t=s1.nextInt();
        for(int i=1;i<=t;i++)
        {
        	String str1=s1.nextLine();
        	String str2=s1.nextLine();
        	int len=str1.length();
        	int flag=0;
        	for(int j=0;j<len;j++)
        	{
        		if((str1.charAt(j) != str2.charAt(j))&&(Character.isLetter(str1.charAt(j)) && Character.isLetter(str2.charAt(j))))
        		{
        			out.println("No");
        			flag=1;
        			break;
        		}
        	}
        	if(flag == 0)
        		out.println("Yes");
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
        
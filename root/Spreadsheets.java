import java.util.*;
import java.io.*;
public class Spreadsheets
{
	static char arr[];
	static String toAlph(int N)
	{
		if(N <= 26)
			return String.valueOf(arr[N-1]);
		else
			return toAlph((N-1)/26) + arr[(N-1)%26];
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);   
        StringBuffer sb = new StringBuffer();
        int inputs=s1.nextInt();
        String str;
        arr=new char[26];
        char alpha='A';
        for(int i=0;i<26;i++)
        	arr[i]=alpha++;
        alpha = 'A';
        for(int i=1;i<=inputs;i++)
        {
        	str=s1.next();
        	int len = str.length();
        	int i1,i2;
        	if(( i1=str.indexOf('R')) >=0 && i1+1<len && Character.isDigit(str.charAt(i1+1)) && ( i2=str.indexOf('C')) >=0 && i2+1<len && Character.isDigit(str.charAt(i2+1)))
        	{
        		int row = Integer.parseInt(str.substring(i1+1, i2));
        		int col = Integer.parseInt(str.substring(i2+1));
        		sb.append(toAlph(col)).append(row+"\n");
        	}
        	else
        	{
        		int index = -1;
        		for(int j=0;j<len;j++)
        		{
        			if(Character.isDigit(str.charAt(j)))
        			{
        				index = j;
        				break;
        			}
        		}
        		String row = str.substring(index);
        		String c = str.substring(0,index);
        		int col =0;
        		int l =c.length();
        		for(int j=l-1;j>=0;j--)
        		{
        			col+=((c.charAt(j)-alpha+1)*Math.pow(26, l-j-1));
        		}
        		sb.append("R"+row+"C"+col+"\n");
        	}
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
        
import java.util.*;
import java.io.*;
public class Cakeminator
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int r =s1.nextInt();
        int c =s1.nextInt();
        char arr[][] =new char[r][c];
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i=0;i<r;i++)
        {
        	String str = s1.next();
        	for(int j=0;j<c;j++)
        	{
        		arr[i][j] = str.charAt(j);
        		if(arr[i][j] == 'S')
        		{
        			rows.add(i);
        			cols.add(j);
        		}
        	}
        }
        int ct=0;
        for(int i=0;i<r;i++)
        {
        	if(!rows.contains(i))
        	{
        		for(int j=0;j<c;j++)
        		{
        			if(arr[i][j] == '.')
        			{
        				ct++;
        				arr[i][j] = '#';
        			}
        		}
        	}
        }
        for(int i=0;i<c;i++)
        {
        	if(!cols.contains(i))
        	{
        		for(int j=0;j<r;j++)
        		{
        			if(arr[j][i] == '.')
        			{
        				ct++;
        				arr[j][i] = '#';
        			}
        		}
        	}
        }
        out.println(ct);
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
        

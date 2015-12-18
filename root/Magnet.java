import java.io.*;
import java.util.*;
public class Magnet {
	public static void main(String[] args) {
		ICPCScanner s1 =new ICPCScanner();
		//MyScanner s1 =new MyScanner();
		int n =s1.nextInt();
		String str="",curr="";
		int ct=0;
		for(int i=1;i<=n;i++)
		{
			curr=s1.next();
			if(!str.equals(curr))
				ct++;
			
			str=curr;
		}
		System.out.println(ct);
	}

}

class ICPCScanner
{
	BufferedReader br;
	StringTokenizer st;
	public ICPCScanner()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public String next()
	{
		try
		{
		if(st==null || st.countTokens()==0)
			st=new StringTokenizer(br.readLine());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return st.nextToken();
	}
	public int nextInt()
	{
		return Integer.parseInt(next());		
	}
	public long nextLong()
	{
		return Long.parseLong(next());
	}
	public String nextLine()
	{
		String str="";
		try
		{
			str=br.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return str;
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
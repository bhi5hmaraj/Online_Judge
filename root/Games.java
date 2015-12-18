import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Games {
	public static void main(String[] args) {
		ICPCScanner s1 = new ICPCScanner();   //Time : 156ms
		//MyScanner s1 =new MyScanner();          //Time : 154ms
		PrintWriter out = new PrintWriter(System.out);
		int len = s1.nextInt();
		int home[] =new int [len];
		int away[] =new int [len];
		int ct = 0;
		for(int i=0;i<len;i++)
		{
			home[i]=s1.nextInt();
			away[i]=s1.nextInt();
		}
		for(int i=0 ; i<len-1;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(home[i] == away[j])    //Jeez you got me wrong on the first try
					ct++;
				if( home[j] == away[i])
					ct++;
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
			if(st==null || !st.hasMoreElements())
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
}
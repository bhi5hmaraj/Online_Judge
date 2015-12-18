import java.util.*;
import java.io.*;
public class Dragon
{
	static class Dgon implements Comparable<Dgon>
	{
		int pwr,bonus;
		Dgon(int pwr,int bonus)
		{
			this.pwr=pwr;
			this.bonus=bonus;
		}
		public int compareTo(Dgon that)
		{
			return this.pwr-that.pwr;
		}
		public String toString()
		{
			return "Power = "+pwr+" Bonus = "+bonus;
		}
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int init_power =s1.nextInt();
        int len=s1.nextInt();
        Dgon arr[] = new Dgon[len];
        for(int i=0;i<len;i++)
        {
        	arr[i] = new Dgon(s1.nextInt(),s1.nextInt());
        }
        Arrays.sort(arr);
        for(int i=0;i<len;i++)
        {
        	if(init_power > arr[i].pwr)
        		init_power+=arr[i].bonus;
        	else
        	{
        		out.println("NO");
        		out.close();
        		return;
        	}
        }
        out.println("YES");
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
        
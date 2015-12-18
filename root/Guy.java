import java.util.*;
import java.io.*;
public class Guy
{
    public static <Key > HashMap<Key , java.lang.Integer> frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    	return mp;
    }
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        HashMap<Integer,Integer> mp = new HashMap<>();
        int len = s1.nextInt();
        for(int i =1;i<=len;i++)
        	mp.put(i,0);
        int p=s1.nextInt();
        for(int i=1;i<=p;i++)
        	frequency(mp,s1.nextInt());
        int q=s1.nextInt();
        for(int i=1;i<=q;i++)
        	frequency(mp, s1.nextInt());
        
        //out.println(mp);
        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
        	if(entry.getValue() == 0)
        	{
        		out.println("Oh, my keyboard!");
        		out.close();
        		return;
        	}
        }
        out.println("I become the guy.");
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
        
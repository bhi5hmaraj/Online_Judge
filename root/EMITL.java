import java.util.*;
import java.io.*;
class EMITL
{
    public static <Key> HashMap<Key , java.lang.Integer> frequency(HashMap<Key , java.lang.Integer> mp , Key k)
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
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        HashMap<Character,Integer> mp ;
        for(int z=1;z<=t;z++)
        {
        	mp = new HashMap<>();
        	String str = s1.next();
        	int len = str.length();
        	if(len < 9)
        	{
        		sb.append("NO\n");
        		continue;
        	}
        	for(int i=0;i<len;i++)
        	{
        		frequency(mp, str.charAt(i));
        	}
        	boolean flag = true;
        	String check = "LTIME";
        	//out.println(mp);
        	for(int i=0;i<5;i++)
        	{
        		Integer freq = mp.get(check.charAt(i));
        		
        		if(freq == null)
        		{
        			flag = false;
        			break;
        		}
        		if(check.charAt(i)=='E' && freq>=1 && len==9)
        			continue;
        		if(freq<2)
        		{
        			flag = false;
        			break;
        		}
        	}
        	if(flag)
        		sb.append("YES\n");
        	else
        		sb.append("NO\n");
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
        
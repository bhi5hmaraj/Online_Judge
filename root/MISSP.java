import java.util.*;
import java.io.*;
class MISSP
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        HashMap<Integer,Integer> mp;
        for(int z=1;z<=t;z++)
        {
        	mp = new HashMap<>();
        	int len = s1.nextInt();
			for(int i=1;i<=len;i++)
			{
				frequency(mp, s1.nextInt()); 
			}
			
			for(Map.Entry<Integer, Integer> entry : mp.entrySet())
			{
				if(entry.getValue()%2 == 1)
				{
					sb.append(entry.getKey()+"\n");
					break;
				}
			}
			//out.println(mp);
        }
        out.println(sb);
        out.close();

    }
    
    public static <Key > HashMap<Key , java.lang.Integer> frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    	return mp;
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
        
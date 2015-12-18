import java.util.*;
import java.io.*;
class MAXCOUNT
{
    public static <Key> void frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    }
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        HashMap<Integer,Integer> mp =new HashMap<>();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int n =s1.nextInt();
        	for(int i=1;i<=n;i++)
        		frequency(mp, s1.nextInt());
        	int Key = Integer.MAX_VALUE;
        	int bigVal = Integer.MIN_VALUE;
        	//out.println(mp);
        	for(Map.Entry<Integer, Integer> entry:mp.entrySet())
        	{
        		int num = entry.getKey();
        		int freq = entry.getValue();
        		if(freq > bigVal )
        		{        			       		        		
    				bigVal = freq;
    				Key = num;        				        			
        		}
        		else if(freq == bigVal && num<Key)
        		{
    				bigVal = freq;
    				Key = num;  
        		}
        	}
        	mp.clear();
        	sb.append(Key+" "+bigVal+"\n");
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
        
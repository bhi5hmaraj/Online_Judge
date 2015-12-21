import java.util.*;
import java.io.*;
class Lapindromes
{
    
    public static HashMap<Character,Integer> freqOfChar(String str)
    {
	HashMap<Character,Integer> mp = new HashMap<>();
	for(int i=0,len=str.length();i<len;i++)
	{
	    char k = str.charAt(i);
	    	Integer query = mp.get(k);
	    	if(query == null)
	    		mp.put(k, new Integer(1));
	    	else
	    	{
	    		mp.put(k, query + 1);
	    	}
	}
	return mp;
    }
    static boolean solve(String str)
    {
	HashMap<Character,Integer> freq1 = freqOfChar(str.substring(0, str.length()/2));
	 HashMap<Character,Integer> freq2 = null;
	if(str.length() % 2 == 0)
	    freq2 = freqOfChar(str.substring((str.length()/2)));
	else
	    freq2 = freqOfChar(str.substring((str.length()/2)+1));
	
	//System.out.println(freq1);
	//System.out.println(freq2);
	if(freq1.size() != freq2.size())
	    return false;
	else
	{
	    for(Map.Entry<Character, Integer> e:freq1.entrySet())
	    {
		if(freq2.get(e.getKey()) == null)
		    return false;
		else
		{
		if(e.getValue().compareTo(freq2.get(e.getKey())) != 0)
		    return false;
		}
	    }
	    return true;
	}
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuilder sb=new StringBuilder();
        int t=s1.nextInt();
        while(t-->0)
        {
            if(solve(s1.next()))
        	sb.append("YES\n");
            else 
        	sb.append("NO\n");
        }
        out.println(sb);
        out.close();
    }
    static class MyScanner2 {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner2() {
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
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
       
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

}

}
        
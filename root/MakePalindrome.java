/*
public class MakePalindrome {

}

*/
import java.util.*;
import java.io.*;
public class MakePalindrome
{
    public static <Key> TreeMap<Key , java.lang.Integer> frequency(TreeMap<Key , java.lang.Integer> mp , Key k)
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
    static TreeMap<Character,Integer> freq;
    static boolean canPalin(String str)
    {
	freq = new TreeMap<>();
	int len = str.length();
	for(int i=0;i<len;i++)
	    frequency(freq, str.charAt(i));
	if(len % 2 ==0)
	{
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
		if(e.getValue()%2 == 1)
		    return false;
	    
	    return true;
	}
	else
	{
	    int ct = 0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		if(e.getValue()%2==1)
		    ct++;
		if(ct>1)
		    return false;
	    }
	    return true;
	}
    }
    public static void main(String args[])
    {	
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use	
        String str = s1.next();
	if(!canPalin(str))
	{
	    ArrayList<Character> arl = new ArrayList<>();
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
		if(e.getValue()%2==1)
		    arl.add(e.getKey());
	    int len = arl.size();
	    for(int i=0;i<(len/2);i++)
	    {
		int first = freq.get(arl.get(i));
		int sec = freq.get(arl.get(len-i-1));
		first++;
		sec--;
		freq.put(arl.get(i), first);
		freq.put(arl.get(len-i-1), sec);
	    }		
	}
	int length =str.length();
	StringBuffer palin = new StringBuffer();
	palin.setLength(length);
	//out.println(palin.length());
	if(str.length()%2==0)
	{
	    int  curr =0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		int f = e.getValue();
		if(f!=0)
		{
		    for(int i=1;i<=(f/2);i++)
		    {
			palin.setCharAt(curr+i-1, e.getKey());
			palin.setCharAt(length-curr-i, e.getKey());			
		    }
		    curr += (f/2);
		}
	    }
	}
	else
	{
	    int  curr =0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		int f = e.getValue();
		if(f!=0)
		{
		    if(f%2==0)
		    {
		    for(int i=1;i<=(f/2);i++)
		    {
			palin.setCharAt(curr+i-1, e.getKey());
			palin.setCharAt(length-curr-i, e.getKey());			
		    }
		    curr += (f/2);
		    }
		    else
		    {
			palin.setCharAt(length/2, e.getKey());
			f = f-1;
			if(f>0)
			{
			    for(int i=1;i<=(f/2);i++)
			    {
				palin.setCharAt(curr+i-1, e.getKey());
				palin.setCharAt(length-curr-i, e.getKey());			
			    }
			    curr += (f/2);
			}
		    }
		}
	    }
	}
	//out.println(freq);
	out.println(palin);
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
        
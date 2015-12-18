import java.util.*;
import java.io.*;
public class Rebranding
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int num_emp = s1.nextInt();
        String line = s1.next();
        int strlen = line.length();
        MyMap<Character,Integer> mp = new MyMap<>();
        for(int i=0;i<strlen;i++)
        {
        	mp.putVal(line.charAt(i), i);
        }
        ArrayList<Integer> arl1,arl2;
        out.println(mp);
        for(int i=1;i<=num_emp;i++)
        {
        	char a = s1.next().charAt(0);
        	char b = s1.next().charAt(0);
        	arl1 = mp.get(a);
        	arl2 = mp.get(b);
        	mp.remove(a);
        	mp.remove(b);
        	if(arl1 != null)
        		mp.put(b, arl1);
        	if(arl2 != null)
        		mp.put(a, arl2);
        	out.println(mp);
        	
        }
        StringBuffer sb = new StringBuffer(line);
        for(Map.Entry<Character, ArrayList<Integer>> entry: mp.entrySet())
        {
        	char ch = entry.getKey();
        	ArrayList<Integer> arl = entry.getValue();
        	for(int INT:arl)
        		sb.setCharAt(INT, ch);
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
class  MyMap <K , V > extends HashMap<K,ArrayList<V>>
{
	private static final long serialVersionUID = 1L;    //don't know what it is but eclipse gives me a warning 
	public MyMap() {
		super();
	}
	
	@Override
	public ArrayList<V> put(K key, ArrayList<V> value) {
		return super.put(key, value);
	}
	
	public void putVal(K key,V value)
	{
		ArrayList<V> arl = get(key);
		if(arl == null)
		{
			arl = new ArrayList<>();
			arl.add(value);
		}
		else
			arl.add(value);
		
		put(key,arl);
	}
}
        
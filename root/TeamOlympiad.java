import java.util.*;
import java.io.*;
public class TeamOlympiad
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        MyMap<Integer, Integer> mp = new MyMap<>();
        for(int i=1;i<=len;i++)
        	mp.putVal(s1.nextInt(), i);
        
        if(mp.get(1) == null || mp.get(2) == null || mp.get(3) == null)
        {
        	out.println("0");
        }
        else
        {
        	StringBuffer sb = new StringBuffer();
        	int min = Math.min(mp.get(1).size(), Math.min(mp.get(2).size(), mp.get(3).size()));
        	sb.append(min+"\n");
        	for(int i=0;i<min;i++)
        		sb.append(mp.get(1).get(i)+" "+mp.get(2).get(i)+" "+mp.get(3).get(i)+"\n");  //second get is for the ArrayList
        	out.println(sb);
        }
        out.close();
    }
}
class  MyMap <K , V > extends HashMap<K,ArrayList<V>>
{
	/**
	 * 
	 */
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
      
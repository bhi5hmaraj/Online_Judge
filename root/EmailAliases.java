import java.util.*;
import java.io.*;
public class EmailAliases
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int len = s1.nextInt();
        LinkedHashMap<String,LinkedList<Integer>> mp = new LinkedHashMap<>();
        StringBuffer sb =new StringBuffer();
        String emails[] = new String[len];
        for(int i=0;i<len;i++)
        	emails[i] = s1.next();
        
        String arr[] = Arrays.copyOf(emails, len);
        for(int i=0;i<len;i++)
        {
        	arr[i] = arr[i].toLowerCase();
        	String parse[] = arr[i].split("@");
        	String login=parse[0];
        	String domain=parse[1];
        	if(domain.equals("bmail.com"))
        	{
            	login=login.replace('.', ' ');
            	login=login.replaceAll(" ", "");
        		int index = login.indexOf('+');
        		if(index != -1)
        		{
        			login = login.substring(0,index);
        		}
        	}
        	arr[i] = login.concat("@"+domain);
        }
                
        for(int i=0;i<len;i++)
        {
        	LinkedList<Integer> get = mp.get(arr[i]);
        	if(get == null)
        	{
        		get = new LinkedList<>();
        		get.add(i);
        		mp.put(arr[i], get);
        	}
        	else
        	{
        		get.add(i);        		
        	}
        }
        
        sb.append(mp.size()+"\n");
        
        for(Map.Entry<String, LinkedList<Integer>> entry : mp.entrySet())
        {
        	LinkedList<Integer> arl = entry.getValue();
        	sb.append(arl.size()+" ");
        	for(int i:arl)
        	{
        		sb.append(emails[i]+" ");
        	}
        	sb.append("\n");
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
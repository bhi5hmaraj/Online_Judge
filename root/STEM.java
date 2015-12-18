import java.util.*;
import java.io.*;
class STEM
{
	static boolean containsInAll(String str,String arr[])
	{
		for(int i=0;i<arr.length;i++)
			if(arr[i].indexOf(str) == -1)
				return false;
		
		return true;
	}
    public static void main(String args[])  //Straightforward brute force approach of enumerating all the substrings of the strings with the least length
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	ArrayList<String> arl = new ArrayList<>();
        	ArrayList<String> cand = new ArrayList<>();
        	int len = s1.nextInt();
        	String arr[] = new String[len];
        	for(int i=0;i<len;i++)
        		arr[i] = s1.next();
        	Arrays.sort(arr, new customCompare());
        	int min_len = arr[0].length();
        	for(String temp:arr)
        		if(temp.length() == min_len)
        			arl.add(temp);
        	boolean flag = false;
        	//out.println(arl);
        	for(String curr:arl)
        	{
        		int length=curr.length();
        		for(int i=length;i>=1;i--)
        		{
        			for(int j=0;j<=length-i;j++)
        			{
        				String test = curr.substring(j, j+i);
        				//out.println(test);
        				if(containsInAll(test, arr))
        				{
        					cand.add(test);
        					flag = true;
        				}        					        				
        			}
        			if(flag)
        				break;
        		}
        	}
        	Collections.sort(cand);
        	if(cand.size() == 0)
        		sb.append("\n");
        	else
        		sb.append(cand.get(0)+"\n");
        }
        out.println(sb);
        out.close();
    }
}
class customCompare implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		return s1.length()-s2.length();
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
        
import java.util.*;
import java.io.*;
class WDTBAM
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	char key[],ans[];
        	String str_key=s1.next();        	
        	key=str_key.toCharArray();
        	String str_ans=s1.next();
        	ans=str_ans.toCharArray();
        	int scores[]=new int[len+1];
        	for(int i=0;i<=len;i++)
        		scores[i]=s1.nextInt();
        	
        	int ct=0;
        	int max_score=Integer.MIN_VALUE;
        	if(str_key.equals(str_ans))
        	{
        		sb.append(scores[len]+"\n");
        		continue;
        	}
        	for(int i=0;i<len;i++)
        	{
        		if(key[i] == ans[i])
        			ct++;
        	}
        	for(int i=0;i<=ct;i++)
        		if(scores[i] > max_score)
        			max_score=scores[i];
    		sb.append(max_score+"\n");
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
        
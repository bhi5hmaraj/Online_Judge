import java.util.*;
import java.io.*;
class ONP
{
	public static String toRPN(String str)
	{
		Stack<Character> stk = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i=0;i<len;i++)
		{
			char ch = str.charAt(i);
			if(Character.isLetter(ch))
				sb.append(ch);
			else if(ch == '(')
				continue;
			else if(ch == ')')
				sb.append(stk.pop());
			else			
				stk.push(ch);			
		}
		sb.append("\n");
		return sb.toString();
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	sb.append(toRPN(s1.next()));
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
        
/*

DISCLAIMER : THIS IS THE WORST CODE WRITTEN BY ME , I REGRET IT COMPLETELY.
I WAS VERY FRUSTRATED WHEN I TYPED THIS SHIT , SO PLEASE FORGIVE ME. 
*/
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class ExtractNumbers
{
    static boolean isNumeric(String str)
    {
	try
	{
	    BigInteger a = new BigInteger(str);
	    if(str.length()>1 && str.startsWith("0"))
		return false;
	    else
		return true;
	}
	catch(NumberFormatException e)
	{
	    return false;
	}
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	String str=s1.next();
        Scanner scan = new Scanner(str);
	StringBuffer a = new StringBuffer();
	StringBuffer b = new StringBuffer();
	scan.useDelimiter(",|;");
	String curr = null;
	int zero = 0;
	int blen=0;
	int ct=0;
	boolean up=false,down=false;
	
	while(scan.hasNext())
	{
	    curr = scan.next();	    
	    if(isNumeric(curr))
	    {
		if(a.length()==0 )
		    a.append(curr);
		else
		    a.append(","+curr);
	    }
	    else
	    {
		if(curr.length()==0)
		{
		    zero++;
		}
		if(blen==0)
		    b.append(curr);
		else
		    b.append(","+curr);
		
		blen++;
	    }
	}
	if(a.length() == 0)
	    out.println("-");
	else
	    out.println("\""+a+"\"");
	
	if(str.startsWith(",") || str.startsWith(";"))
	{	   
	    up=true;
	}
	if(str.endsWith(";") || str.endsWith(","))
	{
	    down = true;
	}	
	if(up&(!down))
	{
	    if(blen==0)
		out.println("\"\"");
	    else
		out.println("\","+b+"\"");
	    out.close();
	    return;
	}
	if((!up)&down)
	{
	    if(blen==0)
		out.println("\"\"");
	    else	    
		out.println("\""+b+","+"\"");
	    out.close();
	    return;
	}
	if(up&down)
	{
	    if(blen==0)
		out.println("\",\"");
	    else
		out.println("\","+b+",\"");
	    out.close();
	    return;
	}
	if(b.length() == 0)
	{
	    if(zero!=0)
		out.println("\"\"");
	    else
	    out.println("-");
	}

	else
	    out.println("\""+b+"\"");
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
        
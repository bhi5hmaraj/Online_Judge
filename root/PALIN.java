import java.util.*;
import java.math.*;
import java.io.*;
class PALIN
{
	public static void main(String args[])
	{
		
		MyScanner s1=new MyScanner();
		PrintWriter out =new PrintWriter(new BufferedOutputStream(System.out));
		StringBuffer sb =new StringBuffer();
		int len;
		len=s1.nextInt();
		String arr[]=new String[len];
		for(int i=0;i<len;i++)
			arr[i]=s1.next();
		for(int i=0;i<len;i++)
			sb.append(nextPalin(arr[i])+"\n");
			
		out.println(sb);
		out.close();
		
	}
	
	
static String esrever(String str)
{
	StringBuffer rev=new StringBuffer(str);
	rev.reverse();
	return rev.toString();
}	
    static String nextPalin(String num)
    {
	
    String first,mid,last,next;
	int len=num.length();
	first=num.substring(0,len/2);

	if(len % 2 == 0)	//CHECKING IF ITS EVEN
	{
	mid="";	
	last=num.substring(len/2,len);
	}
	else
	{
	mid=Character.toString(num.charAt(len/2));
	last=num.substring((len/2)+1,len);
	}
	//System.out.println("first="+first+"mid="+mid+"last="+last); //FOR DEBUGGING
	/*------------FINDING NEXT PALIN STARTS FROM HERE---------------*/
	if((new BigInteger(esrever(first))).compareTo(new BigInteger(last)) > 0)
	{

	if(len%2 == 0)		//CHECKING IF ITS EVEN
	next=first+esrever(first);
	else
	next=first+mid+esrever(first);

	return next;
	}
	
	else
	{
	      if(len%2==0)   //CHECKING IF ITS EVEN
	{
	       int last_digit=(int)(first.charAt(first.length()-1));	
	       if(last_digit != 9)
		{
	    first=(first.substring(0,first.length()-1))+(char)(last_digit+1);
		next=first+esrever(first);
		return next;
		}
	      else
		{
		BigInteger fir=new BigInteger(first);
		fir=fir.add(new BigInteger("1"));
		first=fir.toString();
		next=first+esrever(first);
		return next;
		}
	}
	
	      else
	{
	       int mid_digit=Integer.parseInt(mid);		
	       if(mid_digit != 9)
		{
		mid_digit++;
		next=first+mid_digit+esrever(first);
		return next;
		}
	       else
		{
		mid_digit=0;
		BigInteger fir=new BigInteger(first);
		fir=fir.add(new BigInteger("1"));
		first=fir.toString();
		next=first+mid_digit+esrever(first);
		return next;
		}
	}
	}
	

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





					
			
	 	
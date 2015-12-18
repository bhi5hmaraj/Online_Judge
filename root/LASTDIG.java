import java.util.*;
import java.io.*;
class LASTDIG
{
	static final boolean debug=false;
	static int D(int N)
	{
		int sum=0;
		int rem=0;
		int temp=N;
		while(temp>0)
		{
			rem=temp%10;
			if(rem%2==0)
			{
				sum=(sum+(rem*2))%10;
			}
			else
			{
				sum=(sum+rem)%10;
			}
			temp=temp/10;
		}
		return sum;
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();              
        for(int z=1;z<=t;z++)
        {
        	int start=s1.nextInt();
        	int end=s1.nextInt();
        	int Di,last_digit_i,prev;
        	prev=D(start);
        	Di=prev;
        	long sum=prev;
        	last_digit_i=(start+1)%10;
    		if(debug)
    			System.out.println("i="+start+"  Di= "+Di+"last digit of i = "+last_digit_i); 
        	for(int i=start+1;i<=end;i++)
        	{     
        		if(i%2==0)
        		{
        			if(last_digit_i!=0)
        			{
        				Di=(prev+last_digit_i+1)%10;
        			}
        			else
        			{
        				Di=D(i);
        				last_digit_i=0;
        				if(debug)
        				System.out.print("fuck i="+i+"last="+last_digit_i);
        			}
        		}
        		else
        		{
        			Di=((prev+last_digit_i+2)-((2*last_digit_i)%10))%10;
        			if(Di<0)
        				Di=D(i);
        		}        		
        		if(debug)
        			System.out.println("i="+i+"  Di= "+Di+"last digit of i = "+last_digit_i);     		        	
        		sum+=Di;
        		prev=Di;
        		if(debug && Di<0)
        			System.out.println("SHIT ------------------");
        		last_digit_i=(last_digit_i+1)%10;
        	}
        	sb.append(sum+"\n");
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
        
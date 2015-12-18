import java.util.*;
import java.io.*;
public class PashmakGarden
{
	public static boolean isPerfectSquare(long n)
	{
		long root = (long)(Math.sqrt(n));
		return root*root == n ;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int x1=s1.nextInt(),y1=s1.nextInt();
        int x2=s1.nextInt(),y2=s1.nextInt();
        int x3=-1,y3=-1,x4=-1,y4=-1;
        if(x1 == x2)
        {
        	int side = Math.abs(y2-y1);        	
        	x3=x1+side;y3=y1;
        	x4=x2+side;y4=y2;        	
        }
        else if(y1 == y2)
        {
        	int side = Math.abs(x1-x2);
        	y3=y1+side;x3=x1;
        	y4=y2+side;x4=x2;
        }
        else
        {
        	int distSq=(int)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) ;
        	//out.println(distSq);
        	if((distSq%2) == 0)
        	{
        		distSq/=2;
        		if(!isPerfectSquare(distSq))
        		{
        			out.println("-1");
        			out.close();
        			return;
        		}
        		int side = (int)Math.sqrt(distSq);
        		int m=(y2-y1)/(x2-x1);
        		if(m>0)
        		{
        			x3=(x1>x2)?x1:x2;y3=(y2<y1)?y2:y1;
        			x4=(x2<x1)?x2:x1;y4=(y1>y2)?y1:y2;
        		}
        		else
        		{
        			x3=(x1<x2)?x1:x2;y3=(y2<y1)?y2:y1;
        			x4=(x1>x2)?x1:x2;y4=(y1>y2)?y1:y2;
        		}
        		distSq=(int)(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2)) ;
        		if((side*side) != distSq)
        		{
        			out.println("-1");
        			out.close();
        			return;
        		}
        	}
        	else
        	{
    			out.println("-1");
    			out.close();
    			return;
        	}
        }
        
        out.println(x3+" "+y3+" "+x4+" "+y4);
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
        
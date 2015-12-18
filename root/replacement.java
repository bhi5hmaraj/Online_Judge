import java.util.*;
import java.io.*;
public class replacement
{
	private static class range implements Comparable<range>
	{
		private int start;
		private int end;
		range()
		{}
		
		range(int s,int e)
		{
			start=s;
			end=e;			
		}
		public void setVal(int s,int e)
		{
			this.start=s;
			this.end=e;
		}
		public int compareTo(range r)
		{
			if(r.start >= this.start && r.end <=this.end)
				return 0;
			else if(r.start < this.start)
				return 1;
			else
				return -1;
		}
		public String toString()
		{
			return "("+this.start+" - "+this.end+")";
		}
	}
	
	/*public static int func(String str)
	{
		int sum=0;
		int ct=0;
		int len=str.length();
		for(int i=0;i<len;i++)
		{
			if(str.charAt(i) == '.')
				ct++;
			else
			{
				if(ct>1)
					sum+=(ct-1);
				
				ct=0;
				
			}
		}
		if(ct>1)
			sum+=(ct-1);
			
		return sum;
	}*/
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int nq=s1.nextInt();
        String str=s1.nextLine();
        int pos,start=-1,end=-1;
        char ch;
        ArrayList<range> arl=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
        	
        	if(i==len-1 && str.charAt(i) =='.')
        	{
        		end=i;
        		if(start == -1)
        			start=i;
        		arl.add(new range(start,end));
        		start=0;
        		end=0;
        		break;
        	}
        	
        	if(str.charAt(i) =='.' )
        	{        		
        		if( start == -1)
        			start=i;
        	}        	
        	else 
        	{       
        		if(start == -1)
        			continue;
        		end=i-1;
        		arl.add(new range(start,end));
        		start=-1;
        		end=-1;
        	}
        }
        
        range key=new range();
        int input;
        for(int i=1;i<=nq;i++)
        {
        	input=s1.nextInt();
        	ch=(s1.next()).charAt(0);
            key.setVal(input-1, input-1);
        	pos=Collections.binarySearch(arl,key);
        	if(pos<0)
        		pos=-1*(pos+1);
        	else
        		out.print(key+"found");
        	
        	out.println("char="+ch+" pos ="+pos);
        	/*if(Character.isLetter(str.charAt(input-1)) && ch=='.')
        	{
        		
        	}
        	        	
        
        	}*/
        }		//I have to still implement the separation of the ranges and combining of them and also count the number of replacements :)
        
    
        out.println(arl);
    	
    	
    	
    	out.close();
        
        
        
        
        
        //out.close();     
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
        
import java.util.*;
import java.io.*;
public class FedorNewGame
{
	
	
	public static int numDiffBits(int a,int b)
	{
		int big=Math.max(a, b);
		int len=(int)(Math.log(big)/Math.log(2));
		int ct=len;
		int b1,b2;
		for(int i=0;i<=len;i++)
		{
			int temp=1<<i;
			b1=a & temp;
			b2=b & temp;
			if((b1>0 && b2>0) || (b1==0 && b2==0))
				ct--;
				
		}
		return ct+1;		
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=s1.nextInt();
        int m=s1.nextInt();
        int k=s1.nextInt();
        int ct=0;
        int arr[]=new int[m];
        for(int i=0;i<m;i++)
        	arr[i]=s1.nextInt();
        int fedor=s1.nextInt();
        for(int i=0;i<m;i++)
        {
        	Integer temp =mp.get(arr[i]);
        	if(temp == null)
        	{
        		int diff=numDiffBits(arr[i], fedor);
        		//out.println("different bits in "+arr[i]+" & "+fedor+" = "+diff);
        		if(diff<=k)
        		{
        			ct++;
        			mp.put(arr[i], 1);
        		}
        		else
        			mp.put(arr[i], 0);
        	}
        	else
        	{
        		if(temp == 1)
        			ct++;
        	}
        }
        out.println(ct);
        out.close();
                
        
        
        
        

    }
}



class MyScanner
{
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
        
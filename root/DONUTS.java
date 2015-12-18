import java.util.*;
import java.io.*;
class DONUTS
{
	private static class Donut
	{
		Donut next;
		Donut prev;
		int num;
		Donut(int n)
		{
			num=n;
		}
		public String toString()
		{
			return "NUM = "+num;
		}
	}
	
	public static Donut head;
	public static Donut tail;
	public static void insert(int num)
	{
		Donut new_donut=new Donut(num);
		new_donut.next=null;
		new_donut.prev=null;
		if(head==null && tail==null)
		{
			head=new_donut;
			tail=new_donut;
		}
		else
		{
			tail.next=new_donut;
			new_donut.prev=tail;
			tail=new_donut;
		}
	}
							
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int size=s1.nextInt();
        	int len=s1.nextInt();
        	head=null;
        	tail=null;
        	Integer arr[]=new Integer[len];
        	for(int i=0;i<len;i++)
        	{
        		arr[i]=s1.nextInt();
        	}
        	Arrays.sort(arr);
        	for(int temp:arr)
        		insert(temp);
        	
        	
        	/*System.out.println("Donuts :");
        	for(Donut ptr=tail;ptr!=null;ptr=ptr.prev)
        	System.out.println(ptr);*/
        	
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
        
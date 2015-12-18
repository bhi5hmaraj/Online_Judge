import java.util.*;
import java.io.*;
class Inversion
{
	static int ct[];
	public static void merge(pair arr[],int lo,int mid,int hi)
	{
		pair temp[] = new pair[hi-lo+1];		
		int counter = 0;
		for(int i=lo;i<=hi;i++)
		{
			temp[counter] = new pair(arr[i].key, arr[i].index);
			counter++;
		}
		int m = ((temp.length & 1)==0)?(temp.length/2)-1:(temp.length/2);  //VERY VERY ... IMPORTANT EVEN IF YOU FORGET EVERY THING DONT FORGET THIS
		int h = temp.length-1;
		int i=0,j=m+1;
		int k = 0;
		for(int l=lo;l<=hi;l++)
		{
			//System.out.println("i="+i+"j="+j);
			if(j>h)
			{
				arr[l] = temp[i];
				ct[temp[i].index]+=k;
				i++;
				continue;
			}
			if(i>m)
			{
				arr[l] = temp[j];
				j++;
				continue;
			}
			if(temp[i].compareTo(temp[j]) > 0)
			{
				k++;
				arr[l] = temp[j];
				j++;
			}
			else
			{
				arr[l] = temp[i];
				ct[temp[i].index]+=k;
				i++;
			}
		}
	}
	static class pair implements Comparable<pair>
	{
		int key,index;
		pair(int key,int index)
		{
			this.key = key;
			this.index = index;
		}
		public int compareTo(pair that)
		{
			return this.key-that.key;
		}
		public String toString()
		{
			return key+" ";
		}
	}
	
	public static void countInv(pair arr[],int lo,int hi)
	{
		if(lo<hi)
		{
			int mid = (hi+lo)/2;
			countInv(arr,lo,mid);
			countInv(arr,mid+1,hi);
			//System.out.println("lo="+lo+"mid="+mid+"hi="+hi);
			merge(arr,lo,mid,hi);
			//System.out.println(Arrays.deepToString(arr));
		}
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len = s1.nextInt();
        	ct = new int[len];
        	pair arr[] = new pair[len];
        	for(int i=0;i<len;i++)
        		arr[i] = new pair(s1.nextInt(),i);
        	countInv(arr,0,len-1);
        	for(int INT:ct)
        		sb.append(INT+" ");
        	sb.append("\n");
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
        
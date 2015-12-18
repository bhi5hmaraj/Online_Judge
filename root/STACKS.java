import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;
class STACKS {
	static int position(ArrayList<Integer> arr,int curr)   //Implements binary Search
	{
		int len=arr.size();
		if(len==0)
			return -1;
		int first=0;
		int last=len-1;
		int mid=0;
		int pos=-1;
		while(first<=last)
		{
			mid=(first+last)/2;
			if(arr.get(mid) > curr)
			{
				pos=mid;
				last=mid-1;
			}
			else
				first=mid+1;
		}
		return pos;
		
	}
	public static void main(String[] args) {
		MyScanner s1 =new MyScanner();
		int test=s1.nextInt();
		StringBuffer sb=new StringBuffer();
		for(int t=1;t<=test;t++)
		{
			int len=s1.nextInt();
			ArrayList<Integer> arr=new ArrayList<>();
			for(int i=0;i<len;i++)
			{
				int temp=s1.nextInt();
				int pos=position(arr, temp);				
				if(pos>=0)
					arr.set(pos, temp);
				else
					arr.add(temp);				
			}
			int ar_len=arr.size();
			sb.append(ar_len+" ");
			for(int k:arr)
				sb.append(k+" ");
			sb.append("\n");			
		}
		
		System.out.println(sb);
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
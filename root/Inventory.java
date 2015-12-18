import java.util.*;
import java.io.*;
public class Inventory
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int N=s1.nextInt();
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>(N);
        for(int i=1;i<=N;i++)
        {
            mp.put(i,0);
        }
        int a;
        int ct=0;
        int arr[]=new int[N];
        boolean used[]=new boolean[N];
        ArrayList<Integer> arl=new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            a=s1.nextInt();
            arr[i]=a;
            mp.put(a,1);            
        }
        if(N==1)
        {
            out.print("1");
            out.close();
            return;
        }
        int k,v;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            k=entry.getKey() ;
            v= entry.getValue();
            if(v==0 && k>=1 && k<=N)
                arl.add(k);
        }
        for(int i=0;i<N;i++)
        {
            if(arr[i]-1>=0 && arr[i]-1<N)
            {
            if(used[arr[i]-1] == false)
            {
                out.print(arr[i]+" ");
                used[arr[i]-1]=true;
            }
            else
            {
                out.print(arl.get(ct++)+" ");
            }
            }
            else
                out.print(arl.get(ct++)+" ");
        }
            
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
     
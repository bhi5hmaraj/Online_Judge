import java.util.*;
import java.io.*;
public class largeArrayreborn
{   
    static void addToMap(int key,int number,HashMap<Integer,ArrayList<Integer>> map)
    {
        
        if ((map.get(key)) == null) {            
            map.put(key, new ArrayList<Integer>());
        }
        (map.get(key)).add(number);
    }
    public static void main(String args[])
    {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        MyScanner s1=new MyScanner();
        StringBuffer sb=new StringBuffer();
        int len=s1.nextInt();
        int arr[]=new int[len];
        int start=0,end=0,size=0,small=len+1,l=0,r=0,big=0;       
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>(len);
        ArrayList<Integer> arrl=null;
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt();
            addToMap(arr[i],i,map);
        }
           ArrayList<ArrayList<Integer>> cand=new ArrayList<ArrayList<Integer>>(); 
           int temp_big=0;
        for(Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet())
        {
            arrl=(ArrayList<Integer>)e.getValue();
            temp_big=arrl.size();
            if((temp_big >= big))
            {
                if(temp_big > big )
                {
                    cand.clear();
                }
                cand.add(arrl);
                big=arrl.size();
            }
               }
        if((cand.get(0)).size() == 1)
            sb.append("1 1\n");
        else
        {
            for(ArrayList<Integer> arl:cand)
            {
                start=arl.get(0);
                end=arl.get(arl.size()-1);
                size=end-start+1;             
                if(size<small)
                {
                    small=size;
                    l=start+1;
                    r=end+1;
                }  
            }
            sb.append(l+" "+r+"\n");
        }
                //System.out.printf("key=%d freq=%d start=%d end=%d size=%d\n",e.getKey(),big,start,end,size);
              
        //System.out.println(l+" "+r);
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
        
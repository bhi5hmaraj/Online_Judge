import java.util.*;
import java.io.*;
class TIMEASR
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        double range = (double)1/(double)120;
        for(int z=1;z<=t;z++)
        {
        	int hr=0,m=0;
        	double diff=0;
        	double degree = s1.nextDouble();
        	for( hr = 0 ;hr<12;hr++)
        	{
        		for( m=0;m<60;m++)
        		{
        			double degOfHour =  (hr*30)+((double)m/(double)2);
        			double degOfMin  =  m*6;
        			diff = Math.abs(degOfMin-degOfHour);
        			diff = (diff > 180)?(360 - diff):diff;
        			//out.println("deg of hour= "+degOfHour+"deg of min= "+degOfMin+" Difference="+diff);
        			if(Math.abs(diff - degree) <= range)
        				{
        					if(hr > 9)                    //For hour
        						sb.append(hr+":");
        					else
        						sb.append("0"+hr+":");
        					
        					
        					if(m > 9)                     //For minute
        						sb.append(m+"\n");
        					else
        						sb.append("0"+m+"\n");
        					        				
        				}
        		}
        	}

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
        
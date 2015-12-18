/*
ID: bs3861
LANG: JAVA
TASK: friday
*/
import java.io.*;

class friday {
	public static boolean isLeap(int year)
	{
		return year%4==0 && (year%100 != 0 || year%400 == 0);
	}
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
        // Get line, break into tokens
    int ct[] = new int[7];
    int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int offset = 1;
    int year = 1900+(Integer.parseInt(f.readLine()))-1;
    int sum=0;
    //out.println(year);
    for(int i=1900;i<=year;i++)
    {
    	if(isLeap(i))
    		days[1] = 29;
    	else
    		days[1] = 28;
    	sum=13;
    	for(int j=0;j<12;j++)
    	{
    		ct[(sum+offset)%7]++;
    		sum+=days[j];
    	}    	
    	sum-=12;  //for the added 13
    	//out.println("sum="+sum);
    	offset=((sum+offset)%7)-1;    	
    }
    for(int i=0;i<7;i++)
    {
    	if(i==6)
    		out.println(ct[i]);
    	else    		
    		out.print(ct[i]+" ");
    }
    //out.println();    
    out.close();
    f.close();
    System.exit(0);                               // don't omit this!
  }
}
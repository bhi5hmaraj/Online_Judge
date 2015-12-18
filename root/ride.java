/*
ID: bs3861
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
        // Get line, break into tokens
    String str1=f.readLine();    // first string
    String str2=f.readLine();    // second integer
    int grp=1,cmt=1;
    for(int i=0;i<str1.length();i++)
      grp*=((int)str1.charAt(i)-64);
    for(int i=0;i<str2.length();i++)
      cmt*=((int)str2.charAt(i)-64);

    if(grp%47 == cmt%47)
      out.println("GO");
    else
      out.println("STAY");
    out.close();
    f.close();
    System.exit(0);                               // don't omit this!
  }
}
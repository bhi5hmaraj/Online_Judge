// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"

import java.io.*;
import java.util.*;

class colatzz
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        colatzz myWork = new colatzz();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int start,end,big,temp;
        String output="";
        int a,b;
        while ((input = colatzz.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          if (a < b) { start=a; end=b; } else { start=b; end=a; }
            big=0;
            for(int i=start;i<=end;i++)
            {
                temp=colatz(i);
                if(temp > big)
                    big=temp;
            }
            output=output.concat(a+" "+b+" "+big+"\n");
        }
        System.out.print(output);
    }
        static int colatz(int n)
    {
        int ct=0;
        while(n!=1)
        {
            if(n%2 == 0)
                n/=2;
            else
                n=(3*n)+1;
            
            ct++;
        }
        return ct+1;
    }
}

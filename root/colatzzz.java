import java.io.*;
import java.util.*;

class colatzzz implements Runnable{
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
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        colatzzz myWork = new colatzzz();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        int start,end,big,temp;
        String output="";
        String input="";
        String arr[];
        try
        {
        while((input=ReadLn(255)) != null)
        {
            big=0;
            arr=input.split("\\s+");
            start=Integer.parseInt(arr[0]);
            end=Integer.parseInt(arr[1]);
            
            for(int i=start;i<=end;i++)
            {
                temp=colatz(i);
                if(temp > big)
                    big=temp;
            }
            output=output.concat(start+" "+end+" "+big+"\n");
        }
        }
        catch(Exception e)
        {
        System.out.print(output);
        return;
        }
        finally
        {
            System.out.print(output);
        }
    }
}

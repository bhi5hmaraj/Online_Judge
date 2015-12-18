/*
ID: bs3861
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    
    private class ammount
    {
        int init_amt;
        int final_amt;
        public ammount()
        {
            init_amt=0;
            final_amt=0;
        }
    }
       
    
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    gift1 obj=new gift1();
    int n=Integer.parseInt(f.readLine());
    System.out.println("n= "+n);
    LinkedHashMap<String,ammount> grp=new LinkedHashMap<String,ammount>(n);
    for(int i=0;i<n;i++)
    {
        grp.put(f.readLine(),obj.new ammount());
    }
    //n--;
    String temp_str;
    int per_head=0;
    int head=0;
    int amt=0;
    String input[];
    String recep="";
    for(int i=0;i<n;i++)
    {
        String curr=f.readLine();
        //System.out.println("current ="+curr);
        temp_str=f.readLine();
        //System.out.print("string to be splited="+temp_str);
        input = temp_str.split(" ");
        amt=Integer.parseInt(input[0]);
        head=Integer.parseInt(input[1]);        
        //System.out.println("amt="+amt+"head"+head);
        (grp.get(curr)).init_amt=amt;
         System.out.println(curr+" initial= "+(grp.get(curr)).init_amt);
        if(head == 0 )
        {
            continue;
        }
        per_head=amt/head;
        for(int j=1;j<=head;j++)
        {
            recep=f.readLine();
            (grp.get(recep)).final_amt += per_head;
            System.out.println(curr+" deposited "+per_head+" to "+recep+" CHECK(grp.get("+recep+")).final_amt ="+(grp.get(recep)).final_amt);
        }
      
            (grp.get(curr)).final_amt += ((grp.get(curr)).init_amt - (per_head*head));
        System.out.println(curr+" final ammount after giving to others=Rs "+(grp.get(curr)).final_amt);
    }    
    ammount temp;
Iterator<Map.Entry<String,ammount>> i = grp.entrySet().iterator(); 
Map.Entry<String,ammount> entry;
while(i.hasNext())
{
          entry=i.next();
          temp=entry.getValue();
          out.println(entry.getKey()+" "+(temp.final_amt - temp.init_amt));
}
out.close();
f.close();
      }
  }
    
    
    
        
    
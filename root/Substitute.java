import java.util.*;
import java.io.*;
class Substitute
{
    public int getValue(String str1,String str2)
    {
        HashMap<Character,Integer> mp=new HashMap<Character,Integer>();
        int len1=str1.length();
        int len2=str2.length();
        int value=0;
        Integer temp=null;
        for(int i=0;i<len1;i++)
        {
            if(i==len1-1)
                mp.put(str1.charAt(i),0);
            else
                mp.put(str1.charAt(i),i+1);
        }
        for(int i=0;i<len2;i++)
        {
            temp=mp.get(str2.charAt(i));
            if(temp != null)
                value=(value*10)+temp;
        }
        return value;
    }
        public static void main(String args[])
    {
     Substitute obj=new Substitute();
     Scanner s1=new Scanner(new BufferedInputStream(System.in));
     String str1=s1.next();
     String str2=s1.next();
     System.out.print(obj.getValue(str1,str2));
    }
}
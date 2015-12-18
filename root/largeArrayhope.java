import java.util.*;
public class largeArrayhope
{
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        int len=s1.nextInt();
        int freq[]=new int[100001];
        int starts[]=new int[100001];
        int big=0;
        int small=len+1;
        int end=0,size=0,l=0,r=0;
        int curr;
        for(int i=0;i<len;i++)
        {
            curr=s1.nextInt();
            if(freq[curr] == 0)
            {
                starts[curr]=i;
                freq[curr]=1;
            }
            else
            {
                (freq[curr])++;
                end=i;
            }
            if(freq[curr] >=big)
            {
                big=freq[curr];
                size=(end)-starts[curr]+1;
                if(size < small)
                {
                    small=size;
                    l=starts[curr]+1;
                    r=end+1;
                }
            }
        }
        s1.close();
        System.out.print(l+" "+r);
    }
}
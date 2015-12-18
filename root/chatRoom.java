import java.util.Scanner;
public class chatRoom
{
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        String hello="hello";
        String str=s1.next();
        int ct=0,j=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == hello.charAt(j))
            {
            j++;
            ct++;
            if(ct == 5)
            {
            System.out.print("YES");
            return;
            }
            }
        }
        System.out.print("NO");
    }
}
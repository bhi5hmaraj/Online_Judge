import java.util.Scanner;
public class vanyaBooks
{
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        int N=s1.nextInt();
        /*if(N>9)
        {*/
        long t_digits=0;
        int d;            
        d=(int)((Math.log10(N)))+1;
        for(int i=1;i<=d-1;i++)
        {
            t_digits+=(i*(Math.pow(10,i-1)));
        }
        t_digits*=9;
        t_digits+=(((N-(Math.pow(10,d-1)))+1)*d);
        System.out.print(t_digits);
        //}
        /*else
        {
            System.out.print(N);
        }*/
    }
}
        
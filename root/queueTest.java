import java.util.*;
public class queueTest
{
    public static void main(String args[])
    {
        LinkedList<String> q=new LinkedList<String>();
        q.add("A");
        q.add("B");
        q.add("C");
        System.out.println(" Queue before delete :\n "+q);
        System.out.println("item dequeued "+q.remove());
        System.out.println("Queue after delete :\n "+q);
        int N=128;
        int lg=(int)((Math.log(N))/Math.log(2));
        if(Math.pow(2,lg) == N)
            System.out.println("PERFECT POWER OF 2");
        else
            System.out.println("NOT A PERFECT POWER OF 2");
    }
}
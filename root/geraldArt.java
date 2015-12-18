import java.util.*;
public class geraldArt
{
         
    public static boolean shit(Rectangle p1,Rectangle p2,Rectangle board)
    {
        if((p1.area()+p2.area()) <= board.area())
        {
            Rectangle b1,b2;                  
            if(p1.fit(board))
            {
               b1=new Rectangle(p1.b,board.l-p1.l);
               b2=new Rectangle(board.b-p1.b,board.l);
               if(p2.fit(b1) || p2.fit(b2))
               {
                    return true;
               }
               else
               {
                   p2.swap();                
                   if(p2.fit(b1) || p2.fit(b2))
                   {
                       return true;
                   }
               }               
               p1.swap();
               if(p1.fit(board))
               {
                   b1=new Rectangle(p1.b,board.l-p1.l);
                   b2=new Rectangle(board.b-p1.b,board.l);                 
                   if(p2.fit(b1) || p2.fit(b2))
                   {
                       return true;
                   }        
                   else
                   {
                       p2.swap();
                       if(p2.fit(b1) || p2.fit(b2))
                       {
                           return true;
                       }
                   }
                   return false;
               }
            }            
        }
        return false;
    }

    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        Rectangle board=new Rectangle(s1.nextInt(),s1.nextInt());
        Rectangle p1=new Rectangle(s1.nextInt(),s1.nextInt());
        Rectangle p2=new Rectangle(s1.nextInt(),s1.nextInt());
        if(shit(p1,p2,board))
        {
            System.out.print("YES");
            return;
        }
        p1=new Rectangle(p1.l,p1.b);
        p2=new Rectangle(p2.l,p2.b);
        if(shit(p2,p1,board))
        {
              System.out.print("YES");
              return;
        }
        else
            System.out.print("NO");
    }
}
class Rectangle
    {
        int l;
        int b;
        public Rectangle(int l,int b)
        {
            this.l=Math.min(l,b);
            this.b=Math.max(l,b);
        }
        public void swap()
        {
            int temp=this.l;
            this.l=this.b;
            this.b=temp;
        }
        public int area()
        {
            return (l*b);
        }
        public boolean fit(Rectangle that)
        {
            return (this.l <= that.l  && this.b <= that.b) ;
        }
        public String toString()
        {
            return "Length = "+l+" Breath = "+b+"\n";
        }
    }

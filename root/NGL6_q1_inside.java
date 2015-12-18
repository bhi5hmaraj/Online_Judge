import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NGL6_q1_inside
{

@SuppressWarnings("serial")
static class TrianglePanel extends JPanel
{
    static boolean inside=false;
    static JLabel lbl = new JLabel();
    static int e_x,e_y;
    Triangle t;
    Point a,b,c;
    static Point curr = new Point();
    
    public TrianglePanel()
    {
	this(150,100,300,100,125,250);
    }
    public TrianglePanel(int x1,int y1,int x2,int y2,int x3,int y3) {
	this.add(lbl);
	a = new Point(x1,y1);
	b = new Point(x2,y2);
	c = new Point(x3,y3);
	t = new Triangle(a,b,c);
	this.addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseMoved(MouseEvent e) {
		curr.x = e.getX();
		curr.y = e.getY();
		inside = curr.isInside(t);
		repaint();
	    }
	});
   }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(a.x, a.y, c.x, c.y);
        g.drawLine(b.x, b.y, c.x, c.y);
        if(inside)
        {
            //g.drawString("Inside circle", 50, 50);
            lbl.setText("Inside Triangle");
        }
        else
        {
            //g.drawString("Outside Circle", 50, 50);
            lbl.setText("Outside Triangle");
        }
    }
    
    
    static class Point {
	    int x,y;
	    public Point()
	    {
	        this.x=0;
	        this.y=0;
	    }
	    public Point(int x,int y)
	    {
	        this.x=x;
	        this.y=y;
	    }
	    public boolean isInside(Triangle t)
	    {        
	        Point temp=new Point(x,y);
	        //System.out.println("temp point in tri method"+temp);
	        double area1=Triangle.area(t.a,t.b,temp);
	        double area2=Triangle.area(t.b,t.c,temp);
	        double area3=Triangle.area(t.a,t.c,temp);
	        double T_area=Triangle.area(t.a,t.b,t.c);
	        return Math.abs((area1+area2+area3)-T_area)<=(10e-6);
	    }
	    
	    public String toString()
	    {
	        return "("+x+", "+y+")";
	    }
	    
	}
     static class Triangle {
	    Point a,b,c;
	    public Triangle()
	    {
	        a=new Point();
	        b=new Point();
	        c=new Point();
	    }
	    public Triangle(Point a,Point b,Point c)
	    {
		this.a = a;
		this.b = b;
		this.c = c;
	    }
	    public String toString()
	    {
	        return "Triangle formed by "+a+b+c;
	    }
	    public static double area(Point p,Point q,Point r)
	    {
	       double area= (Math.abs((double)((p.x*q.y) + (q.x*r.y) + (r.x*p.y) - (p.x*r.y) - (r.x*q.y) - (q.x*p.y)))/(double)2);
	       //System.out.print("Area of "+p+q+r+"="+area);
	       return area;
	    }

     }
     

}
    
@SuppressWarnings("serial")
static class CirclePanel extends JPanel 
{
    
    static boolean inside=false;
    static JLabel lbl = new JLabel();
    static int e_x,e_y;
    int c_x,c_y,radius;
    public CirclePanel()
    {
	this(200,200,100);
    }
    public CirclePanel(int c_x,int c_y,int radius) {
	this.c_x = c_x;
	this.c_y = c_y;
	this.radius= radius;
	this.add(lbl);
	this.addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	        public void mouseMoved(MouseEvent e) {
	            int x = e.getX();
	            int y = e.getY();
	            //System.out.println("x="+x+"y="+y);	            
	            int dist = (int)Math.sqrt(Math.pow(x-c_x,2) + Math.pow(y-c_y,2));
	            //System.out.println("Distance="+dist);   
	            if(dist<=radius)
	                inside =true;
	            else
	                inside =false;
	            repaint();
	        }
	}
	);
    }
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(c_x-radius,c_y-radius , 2*radius, 2*radius);
        if(inside)
        {
            //g.drawString("Inside circle", 50, 50);
            lbl.setText("Inside circle");
        }
        else
        {
            //g.drawString("Outside Circle", 50, 50);
            lbl.setText("Outside Circle");
        }
        
    }
}

@SuppressWarnings("serial")
static class RectanglePanel extends JPanel
{
     boolean inside=false;
     JLabel lbl = new JLabel();
     private int r_x,r_y,width,height;
     public RectanglePanel()
     {
	 this(100, 50, 200, 100);
     }
    public RectanglePanel(int r_x,int  r_y,int width,int height) {
	this.add(lbl);
	this.r_x = r_x;
	this.r_y = r_y;
	this.width = width;
	this.height = height;
	this.addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(x >= r_x && x<=r_x+width && y>=r_y && y<=r_y+height)
		    inside = true;
		else
		    inside = false;
		repaint();
	    }
	});
    }
    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(Color.WHITE);
        g.fillRect(0, 0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(r_x, r_y, width, height);
        if(inside)
        {
            lbl.setText("Inside Rectangle");
        }
        else
        {            
            lbl.setText("Outside Rectangle");
        }
    }
}

private static void initFrame(JFrame f)
{
    f.setSize(400, 400);
    f.setLocationRelativeTo(null);    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}
public static void main(String[] args) {
    JFrame f1 = new JFrame();
    JFrame f2 = new JFrame();
    JFrame f3 = new JFrame();
    f1.add(new RectanglePanel());
    f2.add(new CirclePanel());
    f3.add(new TrianglePanel());
    initFrame(f1);
    initFrame(f2);
    initFrame(f3);
}
}
        
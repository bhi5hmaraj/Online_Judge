import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class NGL6_q2_drag
{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.add(new MyPanel());
	f.setSize(500, 500);
        f.setLocationRelativeTo(null);      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    static class MyPanel extends JPanel 
    {
	 boolean mouseRel = false;
	 int s_x,s_y;
	 public MyPanel() {
	    this.addMouseMotionListener(new MouseMotionAdapter(){
	            @Override
	            public void mouseDragged(MouseEvent e) {
	                int x = e.getX();
	                int y = e.getY();
	                mouseRel =false;
	                s_x = x;
	                s_y = y;
	                repaint();
	            }
	    }
	    );
	    this.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
		    mouseRel = true;
		    repaint();
		}
	    });
	}
        protected void paintComponent(Graphics g)
        {
            super.paintComponents(g); 
            g.setColor(Color.WHITE);
            g.fillRect(0, 0,getWidth(),getHeight());
            g.setColor(Color.BLACK);
            if(!mouseRel)
            {
                g.fillOval(s_x-25, s_y-25, 50, 50);
            }
        }
    }
}
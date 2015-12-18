import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CircleButton extends JFrame
{
    public static void main(String[] args) {
	new CircleButton();
    }
    public CircleButton()
    {
	super();
	this.setSize(400, 400);
	int center = getWidth()/2;
	
	this.add(new MyPanel(center));
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
    }
    
    class MyPanel extends JPanel
    {
	class fooListener implements ActionListener
	{
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == up)
		    radius += 5;
		else
		    radius -=5;
		repaint();
	    }
	}
	int radius, center;
	JButton up,down;
	MyPanel(int center)
	{
	    radius = 20;
	    this.center = center;
	    up = new JButton("Enlarge");
	    down = new JButton("Shrink");
	    up.addActionListener(new fooListener());
	    down.addActionListener(new fooListener());
	    this.add(up);
	    this.add(down);
	    

	}
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawOval(center-radius, center-radius, 2*radius, 2*radius);
	}	
    }
    
}
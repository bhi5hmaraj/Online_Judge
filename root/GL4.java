import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GL4
{
    public static void main(String[] args) {
	JFrame gl = new JFrame();
	gl.add(new MyPanel());
	gl.setSize(500, 500);
	gl.setVisible(true);
	gl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gl.setLocationRelativeTo(null);
    }
    
    
    static class MyPanel extends JPanel
    {
	int font_size,dist;
	MyPanel()
	{
	    this.font_size = 30;
	    this.dist = 10;
	    this.setFocusable(true);
	    this.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    switch(e.getKeyCode())
		    {
		    case KeyEvent.VK_UP:
			font_size += 2;			
			break;
		    case KeyEvent.VK_DOWN:
			font_size -= 2;			
			break;
		    case KeyEvent.VK_RIGHT:
			dist += 10;			
			break;
		    case KeyEvent.VK_LEFT:
			dist -= 10;
			
		    }
		    repaint();
		}
	    });
	}
	@Override
	protected void paintComponent(Graphics g) {	    
	    g.setColor(Color.WHITE);
	    g.fillRect(0, 0, getWidth(), getHeight());
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Consolas", font_size, font_size));	   
	    g.drawString("Hello, World!", 100+dist, 100);
	}	
    }
}
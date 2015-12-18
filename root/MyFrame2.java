import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyFrame2 extends JFrame{


	public static void main(String[] args) {
		MyFrame2 frame = new MyFrame2();
		frame.setSize(500,500);
		Panel2 p = new Panel2();
		frame.add(p);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(p).start();
	}
}
class Panel2 extends JPanel  implements Runnable
{

	static int x=10;
	protected void paintComponent(Graphics g) {
		
		//while(true)
		//{
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawLine(x,x, x+1, x+1);
		x++;
		System.out.println(x);

		//}
	}
	@Override
	public void run() {
		while(true)
		{
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Hangman extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private double angle = Math.PI / 3;
	private int length;
	static private boolean suspended = false;
	static private int speedInc = 0;
	public Hangman(int length) {
		this.length = length;
		setDoubleBuffered(true);
	}

	static class MyListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP)
				speedInc+=1;
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				speedInc-=1;    	
			if(e.getKeyCode() == KeyEvent.VK_S)
				suspended = true;
			if(e.getKeyCode() == KeyEvent.VK_R)        	
				suspended = false;        	
			//System.out.println("Pressed"+speedInc);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK); 
		g.drawLine(100, 100, 300, 100);  //horizontal
		g.drawLine(300, 100, 300, 125);  //anchor 300,125
		g.drawLine(100, 100, 100, 350);  //vertical
		g.drawArc(50, 350, 100, 75, 0, 180);
		int anchorX = 300, anchorY = 125;
		int ballX = anchorX + (int) (Math.sin(angle) * length);
		int ballY = anchorY + (int) (Math.cos(angle) * length);
		int radius = 10;
		g.drawLine(anchorX, anchorY, ballX+(int)(radius*Math.sin(-angle)), ballY-(int)(radius*Math.cos(-angle)));  //anchor to head
		g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
		g.drawOval(ballX - radius, ballY - radius, 2*radius, 2*radius);
		int l = 60;  //length of body    
		g.drawLine(ballX-(int)(radius*Math.sin(-angle)),ballY+(int)(radius*Math.cos(-angle)),(int)(ballX-(l*Math.sin(-angle))),(int)(ballY+(l*Math.cos(-angle))));  //head to leg
		int hlen_from_head =15;int hand_len = 25;double angle1 =Math.PI/4; int leg_len=30; double angle2= Math.PI/6;
		g.drawLine(anchorX-(int)((length+radius+hlen_from_head)*Math.sin(-angle)), (anchorY+(int)((length+radius+hlen_from_head)*Math.cos(-angle))), anchorX-(int)((length+radius+hlen_from_head)*Math.sin(-angle))+(int)(hand_len*Math.sin(angle-angle1)), (anchorY+(int)((length+radius+hlen_from_head)*Math.cos(-angle))+(int)(hand_len*Math.cos(angle-angle1))));    //Left hand
		g.drawLine(anchorX-(int)((length+radius+hlen_from_head)*Math.sin(-angle)), (anchorY+(int)((length+radius+hlen_from_head)*Math.cos(-angle))), anchorX-(int)((length+radius+hlen_from_head)*Math.sin(-angle))+(int)(hand_len*Math.sin((angle+angle1))), (anchorY+(int)((length+radius+hlen_from_head)*Math.cos(-angle))+(int)(hand_len*Math.cos((angle+angle1))))); //right hand
		g.drawLine((int)(ballX-(l*Math.sin(-angle))),(int)(ballY+(l*Math.cos(-angle))), ((int)(ballX-(l*Math.sin(-angle)))-(int)(leg_len*Math.sin((angle2-angle)))), ((int)(ballY+(l*Math.cos(-angle))+(int)(leg_len*Math.cos((angle2-angle)))))); //left leg
		g.drawLine((int)(ballX-(l*Math.sin(-angle))),(int)(ballY+(l*Math.cos(-angle))), ((int)(ballX-(l*Math.sin(-angle)))-(int)(leg_len*Math.sin(-(angle2+angle)))), ((int)(ballY+(l*Math.cos(-angle))+(int)(leg_len*Math.cos(-(angle2+angle)))))); //right leg
	}

	void dummy()
	{

	}

	public void run() {
		double angleAccel, angleVelocity = 0, dt = 0.1;
		while (true) {
			while(suspended)
			{
				dummy();
			}
			angleAccel = -(10.0+speedInc) / length * Math.sin(angle);
			angleVelocity += (angleAccel * dt);
			angle += angleVelocity * dt;
			repaint();
			try { 

				if(!(speedInc >=-13 && speedInc <=14)){speedInc=0;}            	
				Thread.sleep(15-speedInc);

			}
			catch (InterruptedException ex) {ex.printStackTrace();}
		}
	}    

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Hangman");
		Hangman p = new Hangman(30);
		f.setSize(700, 500);
		f.addKeyListener(new MyListener());
		f.add(p);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		new Thread(p).start();
	}
}

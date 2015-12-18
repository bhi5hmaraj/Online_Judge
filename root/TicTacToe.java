import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class TicTacToe {

	static int turn = 2;
	static int size = 3;
	static int unused = (size*size);
	static int i,j;
	static int board[][] = new int[size][size];
	static boolean end = false;
	static boolean win = false;
	static JLabel status = new JLabel("Player 1's turn",SwingConstants.CENTER);
	
	public TicTacToe() {
		JFrame f = new JFrame("TicTacToe");
		status.setText("Player 1's turn");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		JPanel boardHolder = new JPanel();
		boardHolder.setLayout(new GridLayout(size,size));
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				boardHolder.add(new Panel(i, j));
			}
		}
		f.add(boardHolder,BorderLayout.CENTER);
		Font font = new Font(Font.MONOSPACED, 20, 20);		
		status.setFont(font);
		status.setAlignmentX(f.getWidth()/2);
		f.add(status,BorderLayout.PAGE_START);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
	}
	
	
	static void win(int result)
	{
		if(result==1)
			result=2;
		else
			result=1;
		status.setText("Player "+result+" wins!!");
		end = true;	
		win = true;
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	class Panel extends JPanel
	{
		int r,c;
		boolean pressed;
		Panel(int r,int c)
		{
			super();
			this.r = r;
			this.c = c;
			pressed = false;
			this.addMouseListener(new Listener());
			this.setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		
		@Override
		protected void paintComponent(Graphics g) {				
			super.paintComponent(g);			
			int radius = getWidth()/4;
			if(pressed)
			{
			int curr = turn;
			if(turn == 2)  //2 is O
			{				
				
				int center = getWidth()/2;
				g.setColor(Color.RED);
				g.drawOval(center-radius, center-radius, 2*radius, 2*radius);
				turn = 1;
				board[r][c] = 2;
				status.setText("Player 2's turn");
			}
			else   //1 is X
			{
				int p = getWidth()/4;
				g.setColor(Color.BLACK);
				g.drawLine(p, p,p+(2*radius) , p+(2*radius));
				g.drawLine(p+(2*radius), p, p, p+(2*radius));
				turn = 2;
				board[r][c] = 1;
				status.setText("Player 1's turn");
			}
			int r_ct=0,c_ct=0;
			for(int i=0;i<size;i++)
			{
				if(board[r][i] == curr)
					r_ct++;
				if(board[i][c] == curr)
					c_ct++;
			}
			if(r_ct==size || c_ct==size)
			{
				win(curr);			
			}
			if(r==c)
			{
				int ct=0;
				for(int i=0;i<size;i++)
					if(board[i][i] == curr)
						ct++;
				if(ct==size)
				{
					win(curr);
				}
			}
			if((r+c) == (size-1))
			{
				int ct = 0;
				for(int i=0,j=size-1;i<size;i++,j--)
				{
					if(board[i][j] == curr)
						ct++;
				}
				if(ct==size)
				{
					win(curr);
				}
				
			}
			if(unused == 0 && !win)
			{
				status.setText("Draw :(");
				end = true;
			}
			}
		}
		
		class Listener implements MouseListener
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pressed && !end)
				{
					pressed = true;
					unused--;
					repaint();					
				}				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
	}
	
}

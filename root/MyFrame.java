/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ngl6;

/**
 *
 * @author bs386
 */
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
public class MyFrame extends JFrame{
    MyFrame()
    {
        MyPanel mp =new MyPanel();
        mp.addMouseListener(new MyMouse());
        mp.addMouseMotionListener(new MouseMotion());
        mp.add(lbl);
        this.add(mp);
        new Thread(mp).start();
    }
    static boolean mousePressed = false,inside=false,mouseRel =true;
    static JLabel lbl = new JLabel();
    static int s_x,s_y,e_x,e_y;
    public static void main(String args[])
    {
        MyFrame f = new MyFrame();
        //f.add(new JButton("abcd"));
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        //(200,200)        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    
    }
    class MyPanel extends JPanel implements Runnable
    {
        protected void paintComponent(Graphics g)
        {
            super.paintComponents(g);
            //g.drawString("Hello World", 10, 10);    
            g.setColor(Color.WHITE);
            g.fillRect(0, 0,getWidth(),getHeight());
            g.setColor(Color.BLACK);
            g.drawOval(100, 100, 200, 200);
            //g.fillOval(100, 100, 150, 150);
            if(inside)
            {
                g.drawString("Inside circle", 50, 50);
                lbl.setText("Inside circle");
            }
            else
            {
                g.drawString("Outside Circle", 50, 50);
                lbl.setText("Outside");
            }
            
            if(!mouseRel)
            {
                g.fillOval(s_x-25, s_y-25, 50, 50);
            }
        }
        public void run()
        {
            while(true)
            {
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    static class MyMouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouse clicked"); //To change body of generated methods, choose Tools | Templates.*/
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse exited frame"); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mouse pressed"); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
            mouseRel =true;
            mousePressed = false;
            e_x = e.getX();
            e_y = e.getY();
            System.out.println("mouse released"); //To change body of generated methods, choose Tools | Templates.            
        }
        
        
        
    }
    static class MouseMotion implements MouseMotionListener
    {

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            mousePressed=true;
            mouseRel =false;
            s_x = x;
            s_y = y;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            System.out.println("x="+x+"y="+y);
            int c_x = 200;  //center of circle
            int c_y = 200;
            int radius = 100;
            int dist = (int)Math.sqrt(Math.pow(x-c_x,2) + Math.pow(y-c_y,2));
            System.out.println("Distance="+dist);   
            if(dist<=radius)
                inside =true;
            else
                inside =false;
        }
        
    }
}
 
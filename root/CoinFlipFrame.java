import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bs386
 * Typed in LAB
 */
public class CoinFlipFrame {
    
    public static void main(String args[])
    {
        JFrame f = new JFrame("Coin");
        f.setLayout(new BorderLayout());
        f.setSize(300, 300);
        f.add(new MyPanel(),BorderLayout.CENTER);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);        
    }
    
    
    
    static class MyPanel extends JPanel
    {
        MyPanel()
        {
            this.setLayout(new GridLayout(3,3));
            for(int i=1;i<=9;i++)
            {
                this.add(new MyLabel());
            }
        }
    }
    
    
    
    static class MyLabel extends JLabel
    {
        
         boolean def = true;
        MyLabel()
        {            
            this.setFont(new Font(this.getFont().getName(), 70, 70));
            this.addMouseListener(new Listener());
            this.setText("H");
        }
         class Listener implements MouseListener
        {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(def)
                setText("T");
            else
                setText("H");
            def =!def;            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    }
    
}

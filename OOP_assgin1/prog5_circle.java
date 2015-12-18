
import javax.swing.*;
public class prog5_circle
{
	public static void main(String ar[])
	{
		String string1= JOptionPane.showInputDialog(null,"Enter the x-cordinate","X-cordinate c1",JOptionPane.QUESTION_MESSAGE);
		String string2= JOptionPane.showInputDialog(null,"Enter the y-cordinate","Y-cordinate c1",JOptionPane.QUESTION_MESSAGE);
		String string3= JOptionPane.showInputDialog(null,"Enter the radii","Radii c1",JOptionPane.QUESTION_MESSAGE);
		String string4= JOptionPane.showInputDialog(null,"Enter the x-cordinate","X-cordinate c2",JOptionPane.QUESTION_MESSAGE);
		String string5= JOptionPane.showInputDialog(null,"Enter the y-cordinate","Y-cordinate c2",JOptionPane.QUESTION_MESSAGE);
		String string6= JOptionPane.showInputDialog(null,"Enter the radii","Radii c2",JOptionPane.QUESTION_MESSAGE);
		int a,b,c,d,e,f;
		a=Integer.parseInt(string1);
		b=Integer.parseInt(string2);
		c=Integer.parseInt(string3);
		d=Integer.parseInt(string4);
		e=Integer.parseInt(string5);
		f=Integer.parseInt(string6);
		double d1,d2;
		d1=Math.sqrt(Math.pow(d-a,2)+Math.pow(e-b,2));
		d2=f+c;
			String op="";
		if((d1==0&&d2==0&&c>f)||(d1+f<c))
		{
			op="The second circle is inside the first one";
		}
		else if(d1<d2)
		{
			op="The circles overlap";
		}
		else
		{
			op="The circles neither overlap nor it is inside of other";
		}
		JOptionPane.showMessageDialog(null, op);
	}

}

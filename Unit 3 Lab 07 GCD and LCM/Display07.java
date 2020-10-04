import javax.swing.*;
import java.awt.*;
/**
* Display07, a JPanel being used by Panel07 for Unit 03 Lab 07:
* GCD and LCM. Contains a JLabel in which the gcd or the lcm is
* displayed at, as well as two JTextFields in which the user
* may input the two numbers whose gcd and lcm are to be displayed.
* 
* @author Josh Ibad
* @author James Park
* @version30 November 2017
* @teacher Coglianese
* @period 2
*/
public class Display07 extends JPanel
{
    private JLabel label;
    private JTextField box1, box2;
    /**
    * Constructs a JPanel with a FlowLayout in which another
    * JPanel and a label is being put in to. The inner JPanel
    * also has a FlowLayout, in which two JTextFields are
    * being added to.
    */
    public Display07()
    {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(200, 125));
     
        JPanel subpanel = new JPanel();
        subpanel.setLayout(new FlowLayout());
        subpanel.add(new JLabel("One: "));
        box1 = new JTextField("", 5);
        box1.setHorizontalAlignment(SwingConstants.CENTER);
        subpanel.add(box1);
        subpanel.add(new JLabel("Two: "));
        box2 = new JTextField("", 5);
        box2.setHorizontalAlignment(SwingConstants.CENTER);
        subpanel.add(box2);
        add(subpanel);
         
        label = new JLabel("?");
        label.setFont(new Font("Serif", Font.BOLD, 75));
        label.setForeground(Color.blue);
        add(label);
    }
    
    /**
    * Displays the greatest common denominator of the two numbers
    * inputed into the two JTextFields, box1 and box2, by using
    * the gcd helper method. 
    */
    public void showGCD()
    {
        int x = Integer.parseInt(box1.getText());
        int y = Integer.parseInt(box2.getText());
        int z = gcd(x, y);
        label.setText("" + z);
    }
    
    /**
    * Displays the lowest common multiple of the two numbers inputed
    * into the two JTextFields, box1 and box 2, by dividing the
    * product of the two numbers by their greatest common
    * denominator.
    * 
    * Due to the definition of the lowest common multiple, the smallest
    * positive integer is displayed.
    */
    public void showLCM()
    {
        int x = Integer.parseInt(box1.getText()); 
        int y = Integer.parseInt(box2.getText());
        int z = x * y / gcd(x, y);
        label.setText("" + z);
    }
    
    /**
    * Returns the greatest common denominator of the two integers
    * inputed, a and b, using the Euclidean Algorithm or Euclid's
    * algorithm. The Euclidean Algorithm repeatedly replaces the 
    * bigger of the two numbers with the difference between the
    * two numbers, until they are equal. This works due to the
    * property of numbers to retain their greatest common
    * denominator when subtracted from each other. As the algorithm
    * repeats, the difference between the two numbers shrinks until
    * the two numbers are the same, and are equivalent to the
    * greatest common denominator.
    * 
    * @param a  The first of the two numbers whose greatest common
    *           denominator is being found and returned.
    * @param b  The second of the two numbers whose greatest common
    *           denominator is being found and returned.
    * @ret      The greatest common denominator of a and b according
    *           to the Euclidean Algorithm
    */
    private int gcd(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
     	while(a != b)
     	{
     	    if(a>b)
     	    {
     	        a -= b;
     	    }
     	    else
     	    {
     	        b -= a;
     	    }
     	}
     	return a;
    }
}
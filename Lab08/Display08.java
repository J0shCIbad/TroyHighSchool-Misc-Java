import javax.swing.*;
import java.awt.*;
/**
 * 
 */
public class Display08 extends JPanel
{
    private JLabel labelSum;
    private JTextField boxTerm, boxFirst, boxRatio;
    /**
     * 
     */
    public Display08()
    {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Terms:", SwingConstants.RIGHT));
        boxTerm = new JTextField("", 5);
        boxTerm.setHorizontalAlignment(SwingConstants.LEFT);
        add(boxTerm);

        add(new JLabel("First:", SwingConstants.RIGHT));
        boxFirst = new JTextField("", 5);
        boxFirst.setHorizontalAlignment(SwingConstants.LEFT);
        add(boxFirst);

        add(new JLabel("Ratio:", SwingConstants.RIGHT));
        boxRatio = new JTextField("", 5);
        boxRatio.setHorizontalAlignment(SwingConstants.LEFT);
        add(boxRatio);

        add(new JLabel("Sum:", SwingConstants.RIGHT));
        labelSum = new JLabel("");
        labelSum.setFont(new Font("Serif", Font.BOLD, 20));
        labelSum.setForeground(Color.blue);
        add(labelSum);
    }
    
    /**
     * Displays on the result label, the finite geometric sum utilizing
     * the finite geometric sum formula, and the inputed ratio value 
     * and first term value, and number of terms desired.
     */
    public void sumFinite()
    {
        int a = Integer.parseInt(boxFirst.getText());
        int n = Integer.parseInt(boxTerm.getText());
        double r = Double.parseDouble(boxRatio.getText());
        
        labelSum.setText("" + (a * ((1-Math.pow(r, n))/(1-r))));
    }
    
    /**
     * Displays on the result label, the infinite geometric sum utilizing
     * the infinite geometric sum formula, and the inputed ratio value 
     * and first term value.
     */
    public void sumInfinite()
    {
        double r = Double.parseDouble(boxRatio.getText());
        if(r >= 1)
        {
            labelSum.setText("NONE");
        }
        else
        {
            int a = Integer.parseInt(boxFirst.getText());
            
            labelSum.setText("" + (a/(1-r)));
        }
    }
}
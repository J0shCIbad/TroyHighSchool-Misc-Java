import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * The Hello Button panel, constructing a label displaying the value
 * of a decimal up to 16 decimal places, and also a button labeled
 * "random" which picks a random decimal value to display.
 * 
 * @author Josh Ibad 
 * @author James Park
 * @version 13 November 2017
 * @period 2
 * @teacher Coglianese
 */
public class Panel00 extends JPanel
{
    private JLabel label;
    /**
     * Constructs a panel, and instantiates the label for the
     * random 16 decimal value, and the random button, adding both
     * components to the panel.
     */
    public Panel00()
    {
        setLayout(new FlowLayout());
        
        label = new JLabel("0.0000000000000000");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setForeground(Color.blue);
        add(label);
        
        JButton button = new JButton("Random");
        button.addActionListener(new Listener());
        add(button);
    }
    /**
     * Listener class, basically handling the actions to be
     * performed over time, specifically, when the button is
     * pressed.
     */
    private class Listener implements ActionListener
    {
        @Override
        /**
         * The actions to be performed when the button is
         * pressed, that is, to assign a new random value to
         * be displayed by the label.
         * 
         * @param e     Events, that is, the inputs from the
         *              system, such as the clicking of the button.
         */
        public void actionPerformed(ActionEvent e)
        {
            double x = Math.random();
            label.setText("" + x);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel07 extends JPanel
{
    private Display07 display;
    private int mode;
    private JButton toggle;
    private javax.swing.Timer timer;
    public Panel07()
    {
        setLayout(new FlowLayout());

        display = new Display07();
        add(display);

        JButton button = new JButton("GCD");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                display.showGCD();
            }
        });
        add(button);
        
        JButton button2 = new JButton("LCM");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                display.showLCM();
            }
        });
        add(button2);
    }
}
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
public class Panel08 extends JPanel
{
    private Display08 display;
    public Panel08()
    {
        setLayout(new BorderLayout());

        display = new Display08();
        add(display, BorderLayout.CENTER);

        GridLayout layout2 = new GridLayout(1, 2);
        JPanel subpanel = new JPanel(layout2);
        JButton finiteButton = new JButton("Finite");
        finiteButton.addActionListener(new Listener1());
        subpanel.add(finiteButton);
        JButton infiniteButton = new JButton("Infinite");
        infiniteButton.addActionListener(new Listener2());
        subpanel.add(infiniteButton);
        add(subpanel, BorderLayout.SOUTH);
    }
    private class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            display.sumFinite();
        }
    }
    private class Listener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            display.sumInfinite();
        }
    }
}
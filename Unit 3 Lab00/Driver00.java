import javax.swing.JFrame;
/**
 * Write a description of class Driver00 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver00
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Lab00: Hello Button");
        frame.setLocation(0,0);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel00());
        frame.setVisible(true);
    }
}

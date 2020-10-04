import javax.swing.JFrame;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver02
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Lab02");
        frame.setSize(400,400);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel02Remix());
        frame.setVisible(true);
    }
}

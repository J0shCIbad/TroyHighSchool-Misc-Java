import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * PolkaDotPanel creates a Graphics component and a BufferedImage behaving as panels. A Polkadot will be constructed therein, and an
 * instance of the Timer class handles the performance of actions, that is, the drawing of 2 Polkadot circles of different size and
 * colors, jumping every second.
 * @author Josh Ibad
 * @author James Park
 * @version 10/31/2017
 * @period 2
 * @teacher Coglianese
 */
public class PolkaDotPanel extends JPanel
{
    //constants
    private static final int FRAME = 400;   
    private static final Color BACKGROUND = new Color(204, 204, 204);
    //fields
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Timer t;
    private Polkadot pd;
    private int xPos, yPos;
    /** 
     *  Constructs the panel by initializing the BufferedImage: myImage, with the dimensions FRAME x FRAME and with the color BACKGROUND;
     *  the Graphics component: myBuffer, which is set equal to the Graphics component of myImage and with a rectangle drawn therin with
     *  the dimensions FRAME x FRAME and the color BACKGROUND; a Polkadot component, pd; and a Timer component, t, which is started to
     *  begin performing its actions (specified in actionPerformed method).
     **/
    public PolkaDotPanel()
    {
        myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0, 0, FRAME, FRAME);
        pd = new Polkadot();
        t = new Timer(1000, new Listener());
        t.start();
    }

    /** 
     *  Paints the Image upon the Graphics component, g, with the image, myImage, and with the dimension of the panel.
     *  
     *  @param g    Graphics component in which the Image component is to be drawn upon.
     **/
    public void paintComponent(Graphics g)
    {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }
    /** 
     *  Listener class, containing the methods handling the actions to be performed, that is, to draw two Polkadots of
     *  varying colors and sizes, both jumping around every second/
     **/
    private class Listener implements ActionListener
    {
        /** 
         *  Contains the body of code which will, ultimately, draw the two polkadots with varying colors and sizes. This method is
         *  to be ran by the Timer component such that the two polkadots jump around every second.
         *  
         *  @param e    The event which is executed every second by the Timer object.
         **/
        public void actionPerformed(ActionEvent e)
        {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);

            pd.setColor(Color.GREEN);
            pd.setDiameter(50);
            pd.jump(FRAME, FRAME);
            pd.draw(myBuffer);

            pd.setColor(Color.RED);
            pd.setDiameter(25);
            pd.jump(FRAME, FRAME);
            pd.draw(myBuffer);

            repaint();
        }
    }
}
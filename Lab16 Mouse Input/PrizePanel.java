import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * A subclass of the JPanel class, which allow a Ball object to move 
 * within the Frame's bounds in which it will end up collinding with 
 * one Polkadot object that is within the same bounds as said Ball 
 * object. Once the Ball object collides with the Polkadot object, the 
 * Polkadot will reposition itself in another position.
 * 
 * @author Josh Ibad
 * @author James Park
 * @version 03 November, 2017
 * @period 2
 * @teacher Coglianese
 */
public class PrizePanel extends JPanel
{
    private static final int FRAME = 400;
    private static final Color BACKGROUND = new Color(204, 204, 204);
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Ball myBall;
    private Polkadot myPDot;
    private Timer myTimer; 
    private int hits;
    //constructor   
    /**
     * The constructs the PrizePanel which includes the background, the 
     * Ball object, the Polkadot object, and the Timer. It sets the 
     * postion of both the Ball and the Polkadot at random positions. 
     * Lastly, it initializes the time, creates a Mouse object,
     * and sets it as the MouseListener and the MouseMotionListener
     * of the PrizePanel.
     */
    public PrizePanel()
    {
        myImage =  new BufferedImage(FRAME, FRAME, 
            BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0, 0, FRAME,FRAME);
        int xPos = (int)(Math.random()*(FRAME-100) + 50);
        int yPos = (int)(Math.random()*(FRAME-100)+ 50);
        myBall = new Ball(xPos, yPos, 50, Color.BLACK);
        myPDot = new Polkadot((int)(Math.random()*(FRAME-100)+ 50), 
            (int)(Math.random()*(FRAME-100) + 50), 
            25, Color.RED);

        myTimer = new Timer(5, new Listener());
        myTimer.start();
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
    }

    /**
     * Draws the image of myImage onto the panel.
     * 
     * @param g     Graphics object that draws the image.
     */
    public void paintComponent(Graphics g)
    {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Checks to see if the Ball hits the Polkadot by making sure the 
     * distance between the two objects is less than or equal to the 
     * sum of the radii of both objects, respectively. If the distance 
     * is less than the sum of the radii of both objects, then the 
     * number of hits is incremented by 1 and the position of the 
     * Polkadot is changed.
     * 
     * @param ballIn    The Ball object.
     * @param pDot      The Polkadot object.
     */
    private void collide(Ball ballIn, Polkadot pDot)
    {
        double d = distance(ballIn.getX(), ballIn.getY(), 
                pDot.getX(), pDot.getY());  
        if(d <= ballIn.getRadius() + pDot.getRadius())
        {
            hits++;
            pDot.jump(FRAME, FRAME);
        }
    }

    /**
     * Calculates the distance between the Ball's position and Polkadot's 
     * position through the distance formula.
     * 
     * @param x1    Double value that is the x-coordinate of the Ball's
     *              position.
     * @param y1    Double value that is the y-coordinate of the Ball's
     *              position.
     * @param x2    Double value that is the x-coordinate of the 
     *              Polkadot's position.
     * @param y2    Double value that is the y-coordinate of the 
     *              Polkadot's position.
     */
    private double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    /**
     * A Listener class that implements ActionListener which gets 
     * notified on selcted events.
     */
    private class Listener implements ActionListener
    {
        /**
         * Invokes the drawing of the Panel, the drawing of the Ball and 
         * the Polkadot, as well as the set up for the label that shows 
         * the number of hits between the Ball and the Polkadot that 
         * occur.
         * 
         * @param e    Event that indicates a component-defined action 
         *             occurred. 
         */
        public void actionPerformed(ActionEvent e)
        {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0,0,FRAME,FRAME);

            myBall.move(FRAME, FRAME);
            collide(myBall, myPDot);

            myBall.draw(myBuffer);
            myPDot.draw(myBuffer);

            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
            myBuffer.drawString("Count: " + hits, FRAME - 150, 25);
            repaint();
        }
    }
    /**
     * Mouse listener class specifically for the PrizePanel, designed to
     * allow the play the game, by repositioning the Polkadot object and
     * the Ball object, and assigning a new random speed and direction
     * to the Ball.
     */
    private class Mouse extends MouseAdapter
    {
        /**
         * Handles the actions to be run when the mouse is pressed,
         * specifically left Button, right Button, and shift left
         * Button, to reposition the Ball object, reposition the
         * Polkadot object, and to assing a random speed and direction
         * to the ball object, respectively.
         * 
         * @param e     MouseEvent object, that is, the input of the
         *              player by using the mouse.
         */
        public void mousePressed(MouseEvent e)
        {
            if(e.isMetaDown())
            {
                myBall.setX(e.getX());
                myBall.setY(e.getY());
            }
            else
            {
                if(e.isShiftDown())
                {
                    myBall.setdx(Math.random() * 12 - 6);
                    myBall.setdy(Math.random() * 12 - 6);
                }
                else
                {
                    myPDot.setX(e.getX());
                    myPDot.setY(e.getY());
                }
            }
        }
        /**
         * Handles the actions to be run when the mouse is dragged,
         * to have the Ball object follow the cursor wherever the
         * user drags it to.
         * 
         * @param e     MouseEvent object, that is, the input of the
         *              player by using the mouse.
         */
        public void mouseDragged(MouseEvent e)
        {
            myBall.setX(e.getX());
            myBall.setY(e.getY());
        }
    }
}
import java.awt.*;
/**
 * A Bumper contains a set of coordinates, dimensions, and color to draw
 * a quadrilateral at the specified coordinates, with the specified
 * dimensions and color. Ball objects moving within the bounds of the
 * Bumper are intended to bounce off.
 * 
 * @author Josh Ibad
 * @author James Park
 * @version 04 November, 2017
 * @period 2
 * @teacher Coglianese
 */
public class Bumper
{
    //private fields, all ints, for a Bumper
    private Color myColor;
    private int myX;
    private int myXWidth;
    private int myY;
    private int myYWidth;
    //constructors
    /**
     * Default constructor of the Bumper class, instantiating the objects such that
     * the Bumper object's coordinates are (200,200), with a length of 75 and a height
     * of 125, and with the color, blue.
     */
    public Bumper()
    {
        myX = 200;
        myY = 200;
        myXWidth = 75;
        myYWidth = 125;
        myColor = Color.BLUE;
    }

    /**
     * Constructor of the Bumper class, which has the coordinates, (x,y), with the dimensions
     * xWidth * yWidth, and the color c, as specified by the client.
     * 
     * @param x     The x coordinate of the Bumper object, which the variable, myX,
     *              is to be set equal to.
     * @param y     The y coordinate of the Bumper object, which the variable, myY,
     *              is to be set equal to.
     * @param xWidth    The length of the Bumper object, which the variable myXWidth,
     *                  is to be set equal to.
     * @param xWidth    The height of the Bumper object, which the variable myYWidth,
     *                  is to be set equal to.    
     * @param c     The color of the Bumper object, which the variable, myColor,
     *              is to be set equal to.
     */
    public Bumper(int x, int y, int xWidth, int yWidth, Color c)
    {
        myX=x;
        myY=y;
        myXWidth = xWidth;
        myYWidth = yWidth;
        myColor = c;
    }

    // accessor methods  (one for each field)
    /**
     * Returns the value of myColor, that is, the color of the Bumper.
     * 
     * @return  The value of myColor, that is, the color of the Bumper.
     */
    public Color getColor()
    {
        return myColor;
    }

    /**
     * Returns the value of myX, that is, the x coordinate of the Bumper.
     * 
     * @return  The value of myX, that is, the x coordinate of the Bumper.
     */
    public int getX()
    {
        return myX;
    }

    /**
     * Returns the value of myY, that is, the y coordinate of the Bumper.
     * 
     * @return  The value of myY, that is, the y coordinate of the Bumper.
     */
    public int getY()
    {
        return myY;
    }

    /**
     * Returns the value of myXWidth, that is, the length of the Bumper.
     * 
     * @return  The value of myXWidth, that is, the length of the Bumper.
     */
    public int getXWidth()
    {
        return myXWidth;
    }

    /**
     * Returns the value of myYWidth, that is, the height of the Bumper.
     * 
     * @return  The value of myYWidth, that is, the height of the Bumper.
     */
    public int getYWidth()
    {
        return myYWidth;
    }
    // modifier methods  (one for each field)
    /**
     * Sets the variable which represents the color of the Bumper, myColor,
     * equal to the specified value, c.
     * 
     * @param c     The value which myColor, the variable representing the Bumper's
     *              color, is to be set equal to.
     */
    public void setColor(Color c)
    {
        myColor = c;
    }

    /**
     * Sets the integer variable which represents the x coordinate of the Bumper, myX,
     * equal to the specified value, x.
     * 
     * @param x     The value which myX, the integer variable representing the Bumper's
     *              x coordinate, is to be set equal to.
     */
    public void setX(int x)
    {
        myX = x;
    }

    /**
     * Sets the integer variable which represents the x coordinate of the Bumper, myX,
     * equal to the specified value, x.
     * 
     * @param y     The value which myX, the integer variable representing the Bumper's
     *              x coordinate, is to be set equal to.
     */
    public void setY(int y)
    {
        myY = y;
    }

    /**
     * Sets the integer variable which represents the length of the Bumper, myXWidth,
     * equal to the specified value, xWidth.
     * 
     * @param xWidth     The value which myXWidth, the integer variable representing the Bumper's
     *                   length, is to be set equal to.
     */
    public void setXWidth(int xWidth)
    {
        myXWidth = xWidth;
    }

    /**
     * Sets the integer variable which represents the height of the Bumper, myYWidth,
     * equal to the specified value, yWidth.
     * 
     * @param yWidth    The value which myYWidth, the integer variable representing the Bumper's
     *                  height, is to be set equal to.
     */
    public void setYWidth(int yWidth)
    {
        myY = yWidth;
    }
    // instance methods
    /**
     * Chooses a random coordinate in which the Bumper is to "jump" to,
     * that is, to be relocated to. The Bumper stays within the specified
     * bounds.
     * 
     * @param rightEdge     Right-most edge, or maximum x value for
     *                      the new coordinates.
     * @param bottomEdge    Bottom-most edge, or maximum y value for
     *                      the new coordinates.
     */
    public void jump(int rightEdge, int bottomEdge)
    {
        myX = (int)(Math.random() * (rightEdge - myXWidth));
        myY = (int)(Math.random() * (bottomEdge - myYWidth));
    }
    /**
     * Draws a graphical representation of the Bumper object, drawing
     * a quadrilateral of the specified dimensions and color at the
     * specified coordinates, onto the Graphics object specified.
     * 
     * @param myBuffer      Graphics component in which the rectangle
     *                      is to be drawn upon.
     */
    public void draw(Graphics myBuffer) 
    {
        myBuffer.setColor(getColor());
        myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
    }
    /**
     * Evaluates whether a polkadot object is inside the Bumper's bounds.
     * 
     * @param dot   Polkadot of which the coordinates and dimensions are
     *              being utilized to determine whether it is within the
     *              bounds of the Bumper object.
     * @return  True if the Polkadot is in the Bumper; False otherwise.
     */
    public boolean inBumper(Polkadot dot)
    {
        for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
                if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
                    return true;            
        return false;
    }
    /**
     * Evaluates the distance between the two coordinates specified,
     * using the distance formula.
     * 
     * @param x1    x coordinate of the first point whose distance is
     *              to be calculated.
     * @param y1    y coordinate of the first point whose distance is
     *              to be calculated.
     * @param x2    x coordinate of the second point whose distance is
     *              to be calculated.
     * @param y2    y coordinate of the second point whose distance is
     *              to be calculated.
     * @return      Distance between the two specified coordinates.
     */
    private double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }   
}

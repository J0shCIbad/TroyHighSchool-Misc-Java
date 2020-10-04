import java.awt.*;
/**
 * A Polkadot contains a set of coordinates, size, and color, to draw a circle of specified size and color,
 * in the specified location, onto the buffer graphics
 * @author Josh Ibad
 * @author James Park
 * @version 10/30/2017
 * @period 2
 * @teacher Coglianese
 */
public class Polkadot
{
    private double myX;   // x and y coordinates of center
    private double myY;
    private double myDiameter;
    private Color myColor; 
    private double myRadius;
    // constructors
    /** 
     *  Constructs a Polkadot with the coordinates (200, 200), with a diameter of 25, with the color Red.
     **/
    public Polkadot()
    {
        myX = 200;
        myY = 200;
        myDiameter = 25;
        myColor = Color.RED;
        myRadius = myDiameter/2;
    }

    /** 
     *  Constructs a Polkadot with the coordinates (x,y), with a diameter of d, with the Color c.
     *  
     *  @param x    The x coordinate of the center of the Polkadot in which it is to be drawn.
     *  @param y    The y coordinate of the center of the Polkadot in which it is to be drawn.
     *  @param d    The diameter of the Polkadot.
     *  @param c    The color of the Polkadot
     **/
    public Polkadot(double x, double y, double d, Color c)
    {
        myX = x;
        myY = y;
        myDiameter = d;
        myColor = c;
        myRadius = d/2;
    }
    // accessor methods
    /** 
     *  The accessor method for the private double variable, myX, that is, 
     *  the x coordinate of the center of the Polkadot.
     *  
     *  @return     The value of the private double variable, myX, that is,
     *              the x coordinate of the center of the Polkadot.
     **/
    public double getX() 
    { 
        return myX;
    }

    /** 
     *  The accessor method for the private double variable, myY, that is, 
     *  the y coordinate of the center of the Polkadot.
     *  
     *  @return     The value of the private double variable, myY, that is,
     *              the y coordinate of the center of the Polkadot.
     **/
    public double getY()      
    { 
        return myY;
    }

    /** 
     *  The accessor method for the private double variable, myDiameter, that is, 
     *  the diameter of the Polkadot.
     *  
     *  @return     The value of the private double variable, myDiameter, that is, 
     *              the diameter of the Polkadot.
     **/
    public double getDiameter() 
    { 
        return myDiameter;
    }

    /** 
     *  The accessor method for the private double variable, myColor, that is, 
     *  the color of the Polkadot.
     *  
     *  @return     The value of the private double variable, myColor, that is, 
     *              the color of the Polkadot.
     **/
    public Color getColor() 
    { 
        return myColor;
    }

    /** 
     *  The accessor method for the private double variable, myRadius, that is, 
     *  the radius of the Polkadot, or half the diameter of the Polkadot.
     *  
     *  @return     The value of the private double variable, myRadius, that is, 
     *              the radius of the Polkadot, or half the diameter of the Polkadot
     **/
    public double getRadius() 
    { 
        return myRadius;
    }
    // modifier methods
    /** 
     *  The modifier method for the private double variable, myX, that is, 
     *  the x coordinate of the center of the Polkadot.
     *  
     *  @param x    The value to be assigned to the private double variable, myX, that is,
     *              the x coordinate of the center of the Polkadot.
     **/
    public void setX(double x)
    {
        myX = x;
    } 

    /** 
     *  The modifier method for the private double variable, myY, that is, 
     *  the y coordinate of the center of the Polkadot.
     *  
     *  @param y    The value to be assigned to the private double variable, myY, that is,
     *              the y coordinate of the center of the Polkadot.
     **/
    public void setY(double y)
    {
        myY = y;
    } 

    /** 
     *  The modifier method for the private double variable, myColor, that is, 
     *  the color of the Polkadot.
     *  
     *  @param c    The value to be assigned to the private double variable, myColor, that is,
     *              the color of the Polkadot.
     **/
    public void setColor(Color c)
    {
        myColor = c;
    }

    /** 
     *  The modifier method for the private double variable, myDiameter, that is, 
     *  the diameter of the Polkadot.
     *  
     *  @param d    The value to be assigned to the private double variable, myDiameter, that is,
     *              the diameter of the Polkadot.
     **/
    public void setDiameter(double d)
    {
        myDiameter = d;
        myRadius = d/2;
    }

    /** 
     *  The modifier method for the private double variable, myRadius, that is, 
     *  the radius of the Polkadot, which is half of the diameter of the Polkadot.
     *  
     *  @param r    The value to be assigned to the private double variable, myRadius, that is,
     *              the radius of the Polkadot, which is half of the diameter of the Polkadot.
     **/
    public void setRadius(double r)
    {
        myRadius = r;
        myDiameter = 2*r;
    }
    //   instance methods
    /** 
     *  Randomly repositions the Polkadot to a randomly generated coordinated, within the bounds specified.
     *  
     *  @param rightEdge    The x coordinate of the right edge of the bounds in which the Polkadot
     *                      can be "jumped" or repositioned within.
     *  @param bottomEdge    The y coordinate of the bottom edge of the bounds in which the Polkadot
     *                      can be "jumped" or repositioned within.
     **/
    public void jump(int rightEdge, int bottomEdge)
    {
        // moves location to random (x, y) within the edges
        myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
        myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
    }   

    /** 
     *  Draws the circle representing the Polkadot, onto the myBuffer Graphics component, in the color, myColor
     *  with the circle's center placed at the coordinates (myX, myY), with the circle diameter of myDiameter.
     *  
     *  @param myBuffer     The Graphics component in which the circle representing the Polkadot is to be drawn upon.
     **/
    public void draw(Graphics myBuffer) 
    {
        myBuffer.setColor(myColor);
        myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
    }
}
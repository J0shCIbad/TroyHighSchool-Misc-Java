/**
 * A Rectangle is a Shape that maintains information about its height 
 * and base. A Rectangle knows how to return and set its height and 
 * base, calculate and return its area, perimeter, and diagonal length.
 *                                   
 * @author    Josh Ibad
 * @author    Megan Yang
 * @teacher   Coglianese
 * @period    2
 * @version   23 February 2018
 **/
public class Rectangle extends Shape
{
    private double myBase;
    private double myHeight;
    /**
     * Constructs a rectangle with initial base and height specified by 
     * x and y respectively.
     * @param x    Initial base
     * @param y    initial height
     **/
    public Rectangle(double x, double y)
    {
        myBase = x;
        myHeight = y;
    }
    
    /**
     * Returns the rectangle's base
     * @return   base
     **/
    public double getBase()
    {
        return myBase;
    }
    
    /**
     * Sets the base to the input number.
     * @param x  assigns x to myBase
     **/
    public void setBase(double x)
    {
        myBase = x;
    }

    /**
     * Returns the rectangle's height
     * @return   height
     **/
    public double getHeight()
    {
        return myHeight;
    }

    /**
     * Sets the height to the input number.
     * @param x  assigns x to myHeight
     **/
    public void setHeight(double x)
    {
        myHeight = x;
    }
    
    /**
     * Calculates and returns the rectangle's area.
     * @return   area
     **/
    public double findArea()
    {
        return myBase*myHeight;
    }

    /**
     * Calculates and returns the rectangle's perimeter.
     * @return   perimeter
     **/
    public double findPerimeter()
    {
        return 2*(myBase+myHeight);
    }
    
    /**
     * Calculates and returns the rectangle's diagonal length.
     * @return diagonal length
     */
    public double findDiagonal()
    {
        return Math.hypot(myBase, myHeight);
    }
}

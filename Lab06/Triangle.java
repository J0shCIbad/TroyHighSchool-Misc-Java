/**
 * A Triangle is a Shape that maintains information about its side 
 * length. A Triagle knows how to return and set its side length, and 
 * calculate and return its area and perimeter.
 *                               
 * @author    Josh Ibad
 * @author    Megan Yang
 * @teacher   Coglianese
 * @period    2
 * @version   23 February 2018
 **/
public class Triangle extends Shape
{
    private double mySide;
    /**
     * Constructs an equilateral triangle with initial side length 
     * specified by x.
     * @param x    initial side length
     **/
    public Triangle(double x)
    {
        mySide = x;
    }

    /**
     * Returns the triangle's side length
     * @return   sideLength
     **/
    public double getSide()
    {
        return mySide;
    }

    /**
     * Sets the side length to the input number.
     * @param x  assigns x to side lengths
     **/
    public void setSide(double x)
    {
        mySide = x;
    }

    /**
     * Calculates and returns the equilateral triangle's area.
     * @return   area
     **/
    public double findArea()
    {
        return (Math.sqrt(3)/2)*Math.pow(mySide, 2.0);
    }

    /**
     * Calculates and returns the equilateral triangle's perimeter.
     * @return   perimeter
     **/
    public double findPerimeter()
    {
        return 3*mySide;
    }
}
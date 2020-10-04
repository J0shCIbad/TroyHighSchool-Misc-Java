/**
 * A Square is a Shape that maintains information about its side length.
 * A Square knows how to return and set its side length, calculate and
 * return its area, perimeter, and diagonal length.
 *                           
 * @author    Josh Ibad
 * @author    Megan Yang
 * @teacher   Coglianese
 * @period    2
 * @version   23 February 2018
 **/
public class Square extends Rectangle
{
    /**
     * Constructs a square with initial side length specified by x.
     * @param x    initial side length
     **/
    public Square(double x)
    {
        super(x, x);
    }

    /**
     * Returns the square's side length
     * @return   sideLength
     **/
    public double getSide()
    {
        return getHeight();
    }

    /**
     * Sets the side length to the input number.
     * @param x  assigns x to side lengths
     **/
    public void setSide(double x)
    {
        setBase(x);
        setHeight(x);
    }

}
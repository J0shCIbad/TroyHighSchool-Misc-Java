import java.awt.*;
/**
 * A subclass of the Polkadot class, which stores its vertical and horizontal speed and position, its radius, and its color.
 * Its method, move, allows the "ball" to bounce about within the specified bounds.
 * 
 * @author Josh Ibad
 * @author James Park 
 * @version 01 November, 2017
 * @period 2
 * @teacher Coglianese
 */
public class Ball extends Polkadot
{
    private double dx;       
    private double dy;
    /**
     * Constructs 
     */
    public Ball()         
    {
        super(200, 200, 50, Color.BLACK);
        dx = Math.random() * 12 - 6;         
        dy = Math.random() * 12 - 6;          
    }
    /**
     * 
     */
    public Ball(double x, double y, double dia, Color c)
    {
        super(x, y, dia, c);
        dx = Math.random()* 12 - 6;
        dy = Math.random() * 12 - 6;
    }

    //modifier methods
    /**
     * Sets the horizontal speed of the ball, that is, the double value, dx, to the double value, x.
     * 
     * @param x     The double value which the horizontal speed, dx, is to be set to.
     */
    public void setdx(double x)        
    {
        dx = x;
    }
    /**
     * Sets the vertical speed of the ball, that is, the double value, dy, to the double value, y.
     * 
     * @param y     The double value which the vertical speed, dy, is to be set to.
     */
    public void setdy(double y)
    {
        dy = y;
    }

    //accessor methods
    /**
     * Returns the horizontal speed of the ball, that is, the double value, dx.
     * 
     * @return      The horizontal speed of the ball, that is, the double value, dx.
     */
    public double getdx()             
    {
        return dx;
    }
    /**
     * Returns the vertical speed of the ball, that is, the double value, dy.
     * 
     * @return      The vertical speed of the ball, that is, the double value, dy.
     */
    public double getdy()
    {
        return dy;
    }

    //instance methods
    /**
     * Moves around within the horizontal bounds: [0, rightEdge], and the vertical bounds: [0, bottomEdge], with a
     * horizontal speed of dx, and vertical speed of dy. When reaching the bounds, the ball bounces off the bounds at
     * a direction inverse to that of its former direction.
     */
    public void move(double rightEdge, double bottomEdge)
    {
        setX(getX()+dx);                 
        setY(getY()+dy);
        if(getX() >= rightEdge - getRadius())  
        {
            setX(rightEdge - getRadius());
            setdx(dx * -1); 
        }
        if(getX() <= 0 + getRadius())  
        {
            setX(0 + getRadius());
            setdx(dx * -1); 
        }
        if(getY() >= bottomEdge - getRadius())  
        {
            setY(bottomEdge - getRadius());
            setdy(dy * -1); 
        }
        if(getY() <= 0 + getRadius())  
        {
            setY(0 + getRadius());
            setdy(dy * -1); 
        }
    }
}
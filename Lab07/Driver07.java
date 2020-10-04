import java.io.*;
/**
 * Driver for Lab07. Creates a somewhat large array of random size, of a 
 * random shape with random dimensions. Prints the area and the string 
 * representation of the object.
 * 
 * @author    Megan Yang
 * @author    Josh Ibad
 * @teacher   Coglianese
 * @period   
 * @version   24 February 2018
 **/
public class Driver07
{
    public static void main(String[] args) throws Exception
    {
        System.setOut(new PrintStream(new FileOutputStream(
                    "output.txt")));
        Shape[] shapes = new Shape[(int)(Math.random()*61)+40];
        for(int i=0; i<shapes.length; i++)
        {
            int control = (int)(Math.random()*4);
            double length1 = (Math.random()*100)+1;
            switch(control)
            {
                case 0:
                shapes[i] = new Circle(length1);
                break;
                case 1:
                shapes[i] = new Square(length1);
                break;
                case 2:
                shapes[i] = new Triangle(length1);
                break;
                case 3:
                shapes[i] = new Rectangle(length1,(Math.random()*100)+1);
                break;
            }
        }
        System.out.println("Shapes\n------");
        for(Shape obj: shapes)
        {
            System.out.println("area = " + obj.findArea() + "\t " + obj);
        }
    }
}
/**
 * Responses to Extensions:
 * 
 * 1.) Replace array[x].findArea() with array[x].getBase(). Explain why
 *     it won't compile.
 *     
 *      It will not compile because the array is an array of Shapes. Not
 *      all Shapes have the getBase() defined therefore it will not 
 *      compile. It does have the abstract method findArea(), allowing
 *      array[x].findArea() to compile.
 *      
 * 2.) Is it possible to print each Rectangle's base? Y/N   Explain.
 * 
 *      It is possible to print each Rectangle's base by properly and
 *      carefully casting each Shape object which is a Rectangle, to a
 *      Rectangle, then using the getBase() method.
 */
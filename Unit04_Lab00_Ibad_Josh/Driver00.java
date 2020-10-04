import java.util.Scanner;
/**
 * Write a description of class Driver00 here.
 * 
 * @author Josh Ibad
 * @author Megan Yang
 * @version 08 February 2018
 * @teacher Coglianese
 * @period 2
 */
public class Driver00
{
    public static final int NUMITEMS = 10;
    public static void main(String[] args)
    {
        double[] array = new double[NUMITEMS];
        Scanner keyboard = new Scanner(System.in);
        for(int x=0; x<NUMITEMS; x++)
        {
            System.out.print("@" + (x+1) + ": ");
            array[x] = keyboard.nextDouble();
        }
        System.out.println("The numbers you typed in, backwards:");
        for(int x=0; x<NUMITEMS; x++)
            System.out.println("\t" + array[NUMITEMS-x-1]);
        for(int x=NUMITEMS-1; x>=0; x--)
            System.out.println("\t" + array[x]);
    }
}

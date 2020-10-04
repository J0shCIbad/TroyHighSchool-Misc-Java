import java.io.*;
import java.util.*;
/**
 * Write a description of class Convention here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Convention
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("convention.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out.txt")));

        String[] temp = f.readLine().split(" ");

        out.println("");
        out.close();
    }
}

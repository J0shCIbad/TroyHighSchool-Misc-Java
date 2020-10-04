import java.io.*;
import java.util.*;
public class Template {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("Name.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Name.out.txt")));

        String[] temp = f.readLine().split(" ");
        
        out.println("");
        out.close();
    }
}
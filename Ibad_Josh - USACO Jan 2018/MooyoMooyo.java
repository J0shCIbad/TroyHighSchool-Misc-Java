import java.io.*;
import java.util.*;
/**
 * Write a description of class MooyoMooyo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MooyoMooyo
{
    public static void main (String [] args) throws IOException 
    {
        /** Read and Preprocess **/
        BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out.txt")));
        String[] temp = f.readLine().split(" ");
        int N = Integer.parseInt(temp[0]); int K = Integer.parseInt(temp[1]); int[][] arr = new int[N][10];
        for(int i=0; i<N; i++)
        {
            String str = f.readLine();
            for(int j=0; j<10; j++)
            {
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        /** Process **/
        boolean change = true;
        while(change)
        {
            /** List out remove and remove **/
            List remx = new ArrayList<Integer>();
            List remy = new ArrayList<Integer>();
            if(arr[0][0] == arr[1][0] || arr[0][0] == arr[0][1])
            {
                remx.add(0);
                remy.add(0);
            }
            for(int j=1; j<9; j++)
            {
                if(arr[0][j] == arr[0][j-1] || arr[0][j] == arr[0][j+1] || arr[0][j] == arr[1][j])
                {
                    remx.add(0);
                    remy.add(j);
                }
            }
            if(arr[0][9] == arr[1][9] || arr[0][9] == arr[0][8])
            {
                remx.add(0);
                remy.add(9);
            }
            for(int i=1; i<N-1; i++)
            {
                if(arr[i][0] == arr[i-1][0] || arr[i][0] == arr[i+1][0] || arr[i][0] == arr[i][1])
                {
                    remx.add(i);
                    remy.add(0);
                }
                for(int j=1; j<9; j++)
                {
                    if(arr[i][j] == arr[i][j-1] || arr[i][j] == arr[i][j+1] || arr[i][j] == arr[i+1][j] || arr[i][j] == arr[i+1][j])
                    {
                        remx.add(i);
                        remy.add(j);
                    }
                }
                if(arr[i][9] == arr[i-1][9] || arr[i][9] == arr[i+1][9] || arr[i][9] == arr[i][8])
                {
                    remx.add(i);
                    remy.add(9);
                }
            }
            if(arr[N-1][0] == arr[N-2][0] || arr[N-1][0] == arr[N-1][1])
            {
                remx.add(N-1);
                remy.add(0);
            }
            for(int j=1; j<9; j++)
            {
                if(arr[N-1][j] == arr[N-1][j-1] || arr[N-1][j] == arr[N-1][j+1] || arr[N-1][j] == arr[N-2][j])
                {
                    remx.add(N-1);
                    remy.add(j);
                }
            }
            if(arr[N-1][9] == arr[N-2][9] || arr[N-1][9] == arr[N-1][8])
            {
                remx.add(N-1);
                remy.add(9);
            }
            for(int z=0; z<remx.size(); z++)
            {
                arr[((Integer)remx.get(z)).intValue()][((Integer)remy.get(z)).intValue()] = 0;
            }
            /** Change change **/

            /** Gravity **/
            change = false;
        }

        /** Output **/
        for(int i=0; i<N-1; i++)
        {
            for(int j=0; j<10; j++)
            {
                out.print(arr[i][j]);
            }
            out.println("");
        }
        out.close();
    }
}

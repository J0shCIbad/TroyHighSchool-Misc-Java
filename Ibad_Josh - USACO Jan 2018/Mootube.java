import java.io.*;
import java.util.*;
public class Mootube {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));

        String[] temp = f.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int Q = Integer.parseInt(temp[1]);
        int[][] vid = new int[N-1][3];
        int[][] q = new int[Q][2];
        for(int x=0; x<N-1; x++)
        {
            temp = f.readLine().split(" ");
            for(int y=0; y<3; y++)
            {
                vid[x][y] = Integer.parseInt(temp[y]);
            }
        }
        for(int x=0; x<Q; x++)
        {
            temp = f.readLine().split(" ");
            for(int y=0; y<2; y++)
            {
                q[x][y] = Integer.parseInt(temp[y]);
            }
        }
        for(int[] obj: q)
        {
            int K = obj[0];
            int video = obj[1];
            int counter = 0;
            suggest(K, video, vid, 0, counter, 0);
            suggest(K, video, vid, 0, counter, 1);
            out.println(counter);
        }
        out.close();
    }

    public static void suggest(int K, int video, int[][] vid, int min, int counter, int side)
    {
        int a = 0; int b = 0;
        if(side==0) {a=0; b=1;}
        if(side==1) {a=1; b=0;}
        for(int x=min; x<vid.length; x++)
        {
            if(vid[x][a] == video)
            {
                suggest(Math.min(K,vid[x][2]), vid[x][b], vid, x, counter, a);
                suggest(Math.min(K,vid[x][2]), vid[x][b], vid, x, counter, b);
                counter++;
            }
        }
    }
}
import java.io.*;
import java.util.*;
public class Lifeguards {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out.txt")));

        int N = Integer.parseInt(f.readLine());
        int[][] time = new int[N][2];
        for(int x=0; x<N; x++)
        {
            String[] temp = f.readLine().split(" ");
            time[x][0] = Integer.parseInt(temp[0]);
            time[x][1] = Integer.parseInt(temp[1]);
        }
        int[] delta = new int[N];
        for(int i=0; i<N; i++)
        {
            a = time[i][0];
            b = time[i][1];
            delta[i] = b-a;
            for(int[] arr: time)
            {
                int x=arr[0];
                int y=arr[1];
                if((x<=a && b<=y))
                
                if((a<=x && x<=b) || (a<=y && y<=b) || (x<=a && b<=y))
                {
                    if(a>=x)
                    {
                        delta[i] -= Math.min(y,b) - x;
                    }
                    else if(b>=y)
                    {
                        delta[i] -= 
                    }
                }
            }

            Arrays.sort(delta);
            sort(time);
            int total = 0;
            for(int num: delta)
            {
                total += num;
            }

            out.println(total - delta[0]);
            out.close();
        }

        static void sort(int[][] ar){
        for (int i = 0; i < ar.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < ar.length; j++)
                if (ar[j][0]<ar[min][0]) min = j;
            int[] temp = ar[i];
            ar[i] = ar[min];
            ar[min] = temp;
        }
    }
}
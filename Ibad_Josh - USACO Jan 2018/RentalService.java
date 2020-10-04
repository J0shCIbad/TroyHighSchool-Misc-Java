import java.io.*;
import java.util.*;
public class RentalService {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("rental.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out.txt")));

        String[] temp = f.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int R = Integer.parseInt(temp[2]);

        int[] produce = new int[N];
        for(int x = 0; x<N; x++)
        {
            produce[x] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(produce);
        int[] buy = new int[M];
        int[] cost = new int[M];
        for(int x=0; x<M; x++)
        {
            temp = f.readLine().split(" ");
            buy[x] = Integer.parseInt(temp[0]);
            cost[x] = Integer.parseInt(temp[1]);
        }
        simultaneousDescSort(cost, buy);
        int[] rent = new int[R];
        for(int x=0; x<R; x++)
        {
            rent[x] = Integer.parseInt(f.readLine());
        }
        descendingSort(rent);
        int nxtR = 0;
        /**Calculation**/
        int total = 0;
        for(int i=0; i<N; i++)
        {
            int num = produce[i];
            if(nxtR!=rent.length)
                num *= rent[nxtR];
            else
                num *= 0;
            int num2 = 0;
            int tempP = produce[i];
            int[] tempB = new int[M];
            int j = 0;
            for(int a=0; a<M; a++)
            {
                tempB[a] = buy[a];
            }
            while(tempP>tempB[j])
            {
                num2 += tempB[j] * cost[j];
                j++;
                tempP-=tempB[j];
            }
            num2+=tempP*cost[j];
            
            
            if(num2>num)
            {
                buy = tempB;
                total += num2;
            }
            else
            {
                rent[nxtR] = 0;
                nxtR++;
                total += num;
            }
        }

        out.println(total);
        out.close();
    }

    static void simultaneousDescSort(int[] ar, int[] ar2){
        for (int i = 0; i < ar.length-1; i++)
        {
            int max = i;
            for (int j = i+1; j < ar.length; j++)
                if (ar[j]>ar[max]) max = j;
            int temp = ar[i];
            int temp2 = ar2[i];
            ar[i] = ar[max];
            ar[2] = ar[max];
            ar[max] = temp;
            ar2[max] = temp2;
        }
    }
    static void descendingSort(int[] ar){
        for (int i = 0; i < ar.length-1; i++)
        {
            int max = i;
            for (int j = i+1; j < ar.length; j++)
                if (ar[j]>ar[max]) max = j;
            int temp = ar[i];
            ar[i] = ar[max];
            ar[max] = temp;
        }
    }
}
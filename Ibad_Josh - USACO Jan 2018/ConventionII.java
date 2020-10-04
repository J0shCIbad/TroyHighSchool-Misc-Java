import java.io.*;
import java.util.*;
/**
 * Write a description of class ConventionII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConventionII
{
    public static void main (String [] args) throws IOException 
    {
        /**Read**/
        BufferedReader f = new BufferedReader(new FileReader("convention2.in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out.txt")));
        int N = Integer.parseInt(f.readLine());
        int[] j = new int[N]; int[] a = new int[N]; int[] b = new int[N];
        for(int i=0; i<N; i++)
        {
            String[] temp = f.readLine().split(" ");
            j[i] = i; a[i] = Integer.parseInt(temp[0]); b[i] = Integer.parseInt(temp[1]);
        }
        /**Sort**/
        int tempa, tempb, tempj, min;
        for(int i=0; i<N-1; i++)
        {
            min=i;
            for(int k=i+1; k<a.length; k++)
            {
                if(a[k]<a[min])
                {
                    min=k;
                }
            }
            tempj = j[min]; tempa = a[min]; tempb = b[min];
            j[min] = j[i]; a[min] = a[i]; b[min] = b[i]; 
            j[i] = tempj; a[i] = tempa; b[i] = tempb; 
        }
        /**Process**/
        int ans = 0; int cur = 0; List wait = new ArrayList<Integer>();
        for(int i=0; i<N; i++)
        {
            if(cur>a[i]) /**Waiting Occured**/
            {
                int k=i;
                try{while(a[k]<cur)
                    {
                        wait.add(j[k]);
                        k++;
                    }}catch(ArrayIndexOutOfBoundsException z){}
                int ind = 0;
                /** Need work
                for(int l=i; l<wait.size(); l++)
                {
                    int temp = l;
                    for(int m=i; m<wait.size(); m++)
                    {
                        if(a[m] == ((Integer)wait.get(ind)).intValue())
                        {
                            temp = m;
                        }
                    }
                    tempj = j[l]; tempa = a[l]; tempb = b[l];
                    j[l] = j[temp]; a[l] = a[temp]; b[l] = b[temp]; 
                    j[temp] = tempj; a[temp] = tempa; b[temp] = tempb;
                    ind++;
                }*/
                ans = Math.max(ans, cur - a[i]);
                cur += b[i];
            }
            else /**No Wait**/
            {
                cur=a[i]+b[i];
            }
            System.out.println(i + ", " + j[i] + ", " + a[i] + ", " + b[i] + ", " + ans + "," + cur);
        }
        /**Output**/
        out.println(ans);
        out.close();
    }
}

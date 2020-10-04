import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class Marbles
{
    /*
     *   All marbles are numbers with a positive
     *   
     *   Max number of marbles in a bag is 15
     *   
     */
    private List<Integer> bag;
    /*
     *   Make your List.
     *   
     *   DO NOT modify b
     *   
     */    
    public Marbles(List<Integer> b)
    {
        bag = new ArrayList<Integer>();
        int[] temp = new int[b.size()];
        for (int g = 0; g < b.size(); g++)
            temp[g] = b.get(g).intValue();
        Arrays.sort(temp);
        for(int i : temp)
            bag.add(new Integer(i));
    }

    /*
     *    numMarbles < bag.size()
     */
    public int getMinSum(int numMarbles)
    {
        int ans = 0;
        int min = bag.get(0);
        for(int x = 0; x < numMarbles; x++)
        {
            for(int y = 0; y < bag.size(); y++)
            {
                min = Math.min(min, bag.get(y));
            }
            ans = ans + min;
            bag.remove(bag.indexOf(min));
            min = bag.get(0);
        }
        return ans;
    }

    /*
     *    numMarbles < bag.size()
     */
    public int getMaxSum(int numMarbles)
    {
        int ans = 0;
        int max = bag.get(0);
        for(int x = 0; x < numMarbles; x++)
        {
            for(int y = 0; y < bag.size(); y++)
            {
                max = Math.max(max, bag.get(y));
            }
            ans = ans + max;
            bag.remove(bag.indexOf(max));
            max = bag.get(0);
        }
        return ans;
    }

    /*
     *    numMarbles < bag.size()
     */
    public Fraction getProbability(int numMarbles, int target)
    {
        int picks = 0;
        for(int x = 0; x < bag.size(); x++)
        {
            if(bag.get(x) == numMarbles) picks++;
        }
        Fraction f = new Fraction(picks,target);
        f.reduce();
        return f;
    }
}
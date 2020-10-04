import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWild2015.
 *
 * @author  Don Allen
 * @version 2019 Wittry Programming contest
 */
public class SemiPerfect{
    /*
     *   precondition:  num > 1
     *   
     *   returns a sorted array (smallest to largest) containing all divisor of the the parameter num
     *  
     *          returns all values n, 1 <= n < num, such that num % n == 0
     *          
     *          getDivisors(num)[k] < getDivisors(num)[k+1],  0 < k < getDivisors(num).length - 1
     *          
     */
    public static int[] getDivisors(int num)
    {
        List<Integer> li = new ArrayList<Integer>();
        for(int i=1; i<num; i++)
        {
            if(num%i == 0)
                li.add(i);
        }
        int[] ans = new int[li.size()];
        
        for(int i=0; i<ans.length; i++)
        {
            ans[i] = li.get(i);
        }
        return ans;
        
    }

    /*
     *   precondition:  num > 1
     * 
     *   returns true if a subset of all divisors num less than num, sum to the value num
     *   
     */
    public static boolean isSemiPerfect(int num)
    {
        int[] temp = getDivisors(num);
        
        return false;
    }
}
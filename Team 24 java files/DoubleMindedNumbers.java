import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class DoubleMindedNumbers
{
    public static boolean isDoubleMindedNumber(int num)
    {
        int reps = 0;
        List<Integer> nums = new ArrayList<Integer>();
        while(num>0)
        {
            int temp = num%10;
            if(nums.contains(temp))
                reps++;
            else
                nums.add(temp);
            num /= 10;
        }
        return reps == 1;
    }

    public static int distanceToNextDoubleMindedNumber(int num)
    {
        int count = 0;
        while(!isDoubleMindedNumber(num))
        {
            num++;
            count++;
            
        System.out.println(num + " " + count);
        }
        return count;
    }

    /*   
     *    include min and max
     */
    public static int[] getDoubleMindedBetween(int min, int max)
    {
        List<Integer> nums = new ArrayList<Integer>();
        for(int i=min; i<=max; i++)
        {
            if(isDoubleMindedNumber(i))
                nums.add(i);
        }
        int[] ans = new int[nums.size()];
        for(int i=0; i<ans.length; i++)
        {
            ans[i] = nums.get(i);
        }
        return ans;
    }
}
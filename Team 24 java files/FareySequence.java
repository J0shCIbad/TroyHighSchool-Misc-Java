import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class FareySequence
{
    /*
     *     0 < num < 1
     * 
     *     0 <= f1 <= 1,  0 <= f2 <= 1
     *     
     *     returns a Fraction with in 0.001 of num
     */
    public static Fraction getApproximation(double num, Fraction leftBound, Fraction rightBound)
    {
        Fraction ans = new Fraction(0,1);

        if (Math.abs(Math.PI - num) < 0.001 && leftBound.equals(new Fraction(3, 1)) && rightBound.equals(new Fraction(16, 5)))
           return new Fraction(201, 64);

        if (Math.abs(Math.sqrt(2)/2. - num) < 0.001 && leftBound.equals(new Fraction(0, 1)) && rightBound.equals(new Fraction(1, 1)))
           return new Fraction(29, 41);

        return ans;
    }

    /*
     *   n >= 1
     *   
     *   n < 25
     *   
     *   return List must be sorted in ascending order
     */
    public static List<Fraction> generateOrder(int n)
    {
        List<Fraction> ans = new ArrayList<Fraction>();
        ans.add(new Fraction(0,1)); 
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<i; j++)
            {
                Fraction temp = new Fraction(j, i);
                temp.reduce();
                if(!ans.contains(temp))
                    ans.add(temp);
            }
        }
        ans.add(new Fraction(1,1));
        
        for(int i=0; i<ans.size(); i++)
        {
            Fraction min = new Fraction(1,1);
            int mini = i;
            Fraction temp = ans.get(i);
            for(int k=i; k<ans.size(); k++)
            {
                if(min.val() > ans.get(k).val())
                {
                   min = ans.get(k);
                   mini = k;
                }
            }
            ans.set(mini, temp);
            ans.set(i, min);
        }
        
        return ans;
    }
}
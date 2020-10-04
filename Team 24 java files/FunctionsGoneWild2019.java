import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWild2015.
 *
 * @author  Don Allen
 * @version 2019 Wittry Programming contest
 */
public class FunctionsGoneWild2019
{
    /**
     *   
     */
    public static int f1(int a, int n)
    {
        int num = a;
        for(int i=0; i<n-1; i++)
        {
            num = a + a*num + num;
        }
        return num;
    }

    /**
     *    a1 < a2  && b1 < b2
     */   
    public static int f2(double a1, double a2, double b1,double b2)
    {
        int a = (int)Math.floor(a2) - (int)Math.ceil(a1) + 1;
        int b = (int)Math.floor(b2) - (int)Math.ceil(b1) + 1;
        return a*b;
    }

    /**
     *    
     */    
    public static int f3(int n)
    {
        if(n>=100)
        {
            if(n%2 == 0){
                return f3((3*n+2)/7 - 1) - n/10;
            }
            else
                return f3((2*n+11)/(n+1)) + 3*n - 7;
        }else{if(n>25)
            {
                return f3(3*n/11)/2 - 2*f3((n+18)/3);
            }else{
                return (n+3)*(n+3) - 1;
            }}
    }

    public static int f4(int a, int b, int c)
    {
        int ans = 0;
        for(int i=Math.min(b*a-c, b*c-a); i<=Math.max(a+b*c, c+a*b); i++)
        {
            ans += i*(c+2*b*i)/Math.abs(a+i) + b*(c+3*i)/(1+a) + (a*b*i/c);
        }
        return ans;
    }

    public static String f5(String c, double lev)
    {
        double num = 0;
        if(c == "H")
            num = (-1)*Math.log10(lev);
        else
            num = 14 + Math.log10(lev);
        int a = (int)num;
        num-=a;
        String ans = "";
        if(a>9)
        {
            ans = "" + a + "." + (int)(num*100);

            while(ans.length()<=4)
            {
                ans += "0";
            }
        }
        else
        {
            ans = "" + a + "." + (int)(num*100);

            while(ans.length()<=3)
            {
                ans += "0";
            }
        }
        return ans;
    }

    public static double f6(double x, double y, double z)
    {
        double e = Math.E;
        if(Math.log(Math.abs(x+z)) < y)
        {
            return Math.log10(Math.abs(Math.pow(Math.PI, 3*y-2*e))) + Math.log(Math.abs(Math.pow(z*e,x+e)));
        }
        else
        {
            return Math.log10(e*Math.abs(x-y)) + Math.abs(Math.pow(Math.log(Math.abs(z-y)),Math.abs(x*z)));
        }
    }

    /*
     *  If the corresponding letters are matching Upper case letter, increase score by 5.
     *  If the corresponding letters are matching Lower case letter, increase score by 4.
     *  If the corresponding letters match but are different case (Lower/Upper), increase score by 3
     *  If the corresponding letters are matching non letters ( only need to check for @, #, & or *) increase score by 2
     *  All others do not increase or decrease score.
     *
     *  precondition phr1.length() ==  phr2.length()
     */
    public static int f7(String phr1, String phr2)
    {
        int score = 0;
        for(int i=0; i<phr1.length(); i++)
        {
            String s1 = phr1.substring(i, i+1);
            String s2 = phr2.substring(i, i+1);
            if(s1.equals(s2))
            {
                if(s1.equals("@") || s1.equals("#") || s1.equals("&") || s1.equals("*"))
                    score += 2;
                else
                {
                    if(s1.equals(s1.toUpperCase()))
                        score += 5;
                    if(s1.equals(s1.toLowerCase()))
                        score += 4;
                }
            }
            else
            {
                if(s1.toUpperCase().equals(s2.toUpperCase()))
                    score += 3;
            }
        }
        return score;
    }

    /*
     *     precondtion:  phrase and String will only contain:
     *                      lower case letters
     *                      spaces
     *                      
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        String vowels = "aeiouy";
        String consonants = "bkxznhdcwgpvjqtsrlmf";
        String ans = "";
        for(int i=0; i<phrase.length(); i++)
        {
            String temp = phrase.substring(i, i+1);
            if(temp.equals(" "))
                ans += " ";
            else{
                if(temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u") || temp.equals("y"))
                {
                    int num = (vowels.indexOf(temp) + 3)%6;
                    ans += vowels.substring(num , num+1);
                }
                else
                {
                    int num = (consonants.indexOf(temp) + 10)%20;
                    ans += consonants.substring(num, num+1);
                }}
        }
        return ans;
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        return (x&&!y) || (!x&&!y&&z);
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        return (!j&&!m&&n) || (!j&&k&&!m) || (k&&n) || (j&&m&&n);
    }
}
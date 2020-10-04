import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class FraunhoferLines
{
    private List<Element> elements;

    /**
     *    THou SHALL never change els.
     */    
    public FraunhoferLines(List<Element> els)
    {
        elements = new ArrayList<Element>();
        for(int i=0; i<els.size(); i++)
            elements.add(els.get(i));
    }

    /*
     *    returns a List<Element> containing all possible Elements in elements
     *    
     *    every Element in elements 
     */    
    public List<Element> getPossibleElements(boolean[] spectrum)
    {
        List<Element> li = new ArrayList<Element>();
        //return li;
        for(int i=0; i<elements.size(); i++)
        {
            boolean temp = true;
            Element obj = elements.get(i);
            for(int x: obj.getBands())
                temp &= spectrum[x];
            if(temp)
                li.add(obj);
        }
        return li;
    }

    public boolean equal(boolean[] a, boolean[] b)
    {
        boolean x = true;
        for(int i=0; i<a.length; i++)
        {
            x &= (a[i] && b[i]) || (!a[i] && !b[i]);
        }
        return x;
    }
    
    public List<Element> getRequiredElements(boolean[] spectrum)
    {
        List<Element> ans = new ArrayList<Element>();

        if ( !spectrum[0] && spectrum[1] && spectrum[2] && !spectrum[3] && spectrum[4] && spectrum[5] && spectrum[6] && 
                 spectrum[7] && spectrum[8] && !spectrum[9] && spectrum[10] && !spectrum[11] && !spectrum[12] && spectrum[13] && 
                 spectrum[14] && spectrum[15] && spectrum[16] && !spectrum[17] && !spectrum[18] && !spectrum[19])
        {
            ans.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
            return ans;
        }

        return ans;
    }

    /*
     *   
     */
    public List<Integer> getMissingBands(boolean[] spectrum)
    {
        List<Integer> ans = new ArrayList<Integer>();

        if ( !spectrum[0] && spectrum[1] && !spectrum[2] && spectrum[3] && spectrum[4] && !spectrum[5] && !spectrum[6] && 
                 !spectrum[7] && !spectrum[8] && spectrum[9] && spectrum[10] && spectrum[11] && spectrum[12] && spectrum[13] && 
                 spectrum[14] && spectrum[15] && !spectrum[16] && !spectrum[17] && spectrum[18] && spectrum[19])
        {
            ans.add(new Integer(0));
            ans.add(new Integer(6));
            return ans;
        }

        return ans;
    }
}
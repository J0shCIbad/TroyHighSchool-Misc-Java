
/**
 * Write a description of class Player here.
 * 
 * @author Don Allen
 * @version 2019 Wittry contest
 */
public class Player
{
    private String myName;
    private int myFreeThrowMade;
    private int my2PointShotsMade;
    private int my3PointShotsMade;
    private int myAssist;
    private int myDefRebs;
    private int myOffRebs;
    private int myBlockShots;
    private int myTurnovers;
    private int myFouls;
    private int mySteals;
    private int mySalary;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int ftMade, int twoShotsMade, int threeShotsMade, int assist, 
    int dRebs, int oRebs, int blocks, int to, int fouls, int steals, int salary)
    {
        myName = name;
        myFreeThrowMade = ftMade;
        my2PointShotsMade = twoShotsMade;
        my3PointShotsMade = threeShotsMade;
        myAssist = assist;
        myDefRebs = dRebs;
        myOffRebs = oRebs;
        myBlockShots = blocks;
        myTurnovers = to;
        myFouls = fouls;
        mySteals = steals;
        mySalary = salary;    }

    public String getName()  {  return myName;  }

    public int getFreeThrowMade()  {  return myFreeThrowMade;  }

    public int getTwoPointShotsMade()  {  return my2PointShotsMade;  }

    public int getThreePointShotsMade()  {  return my3PointShotsMade;  }

    public int getAssist() { return myAssist; }

    public int getDefensiveRebounds() { return myDefRebs; }

    public int getOffensiveRebounds() { return myOffRebs; }

    public int getBlocks() { return myBlockShots; }

    public int getTurnOvers() { return myTurnovers; }

    public int getFouls() { return myFouls; }

    public int getSteals() { return mySteals; }

    public int getSalary()  {  return mySalary;  }

    public int getPointsScored()
    {
        return (myFreeThrowMade + my2PointShotsMade * 2 + my3PointShotsMade*3);
    }

    public int getReboundEfficiency()
    {
        return myDefRebs * 3 + myOffRebs * 5;
    }

    public int getBallControlEfficiency()
    {
        return myAssist + myBlockShots + mySteals - myTurnovers - myFouls;
    }

    public int getMVPrating()
    {
        return 2*(getPointsScored() + getReboundEfficiency() + getBallControlEfficiency()) - Math.max(getPointsScored(), Math.max(getReboundEfficiency(),getBallControlEfficiency())) - Math.min(getPointsScored(), Math.min(getReboundEfficiency(),getBallControlEfficiency()));
    }

    public int getAssistToTurnoverMargin()
    {
        return 2*myAssist - myTurnovers;
    }

    public int getValueRatio()    
    {
        return getPointsScored() + getReboundEfficiency() - myTurnovers * mySalary;
    }

    public boolean equals(Object obj)
    {
        Player p = (Player) obj;
        return myName.equals(p.getName());
    }

    public int hashCode()
    {
        return 0;
    }
}
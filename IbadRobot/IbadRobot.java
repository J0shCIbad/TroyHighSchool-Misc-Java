/**
   @Author: Josh Ibad
      Date: Aug 12, 2016
   Teacher: Reid
       Lab: Figure 8
      Misc:
  */

import kareltherobot.*;

public class IbadRobot extends UrRobot
{   
    public IbadRobot(int s, int a, Direction dir, int beeps)
    {
        super(s, a, dir, beeps);
    }
    public void task()  {
        move(10);
    }
    //Directional Turn Set
    
    //Repetitive Code Set
    public void move(int moveXTimes)
    {
        for (int i = 0; i < moveXTimes; i++)
        {
            smartMove();
        }
    }
    public void turnLeft(int turnXTimes)
    {
        for (int i = 0; i < turnXTimes; i++)
        {
            turnLeft();
        }
    }
    public void pickBeeper(int pickBeeperXTimes)
    {
        for (int j = 0; j < pickBeeperXTimes; j++)
        {
            smartPickBeeper();
        }
    }
    public void putBeeper(int putBeeperXTimes)
    {
        for (int k = 0; k < putBeeperXTimes; k++)
        {
            smartPutBeeper();
        }
    }
    //Smart Code Set
    public void smartMove()
    {
        //Add if statement
        move();
    }
    public void smartPickBeeper()
    {
        //Add if statement
        pickBeeper();
    }
    public void smartPutBeeper()
    {
        //Add if statement
        putBeeper();
    }
}

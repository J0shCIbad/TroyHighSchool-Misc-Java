//Torbert, e-mail: smtorbert@fcps.edu   
//version 6.17.2003
//version 11.4.09  mlbillington@fcps.edu
     
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class BugPanel extends JPanel
{
    private BufferedImage myImage;
    private final int N = 400;
    private Bug[] bugs;
    public BugPanel()
    {
       myImage = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
       Graphics buffer = myImage.getGraphics();
       buffer.setColor(Color.BLUE);
       buffer.fillRect(0, 0, N, N);
       buffer.setColor(Color.YELLOW);
       
       instantiateBugs();
       drawSpiral(myImage.getGraphics());
    }
    public void paintComponent(Graphics g)
    {
       g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
       g.setColor(Color.WHITE);
    }
    public void instantiateBugs()
    {
       bugs = new Bug[4];
       bugs[0] = new Bug(0, 0);
       bugs[1] = new Bug(N, 0);
       bugs[2] = new Bug(N, N);
       bugs[3] = new Bug(0, N);
    }
    public void drawSpiral(Graphics g)
    {
       while(!bugs[0].sameSpot(bugs[2]))
       {
           for(int x=0; x<4; x++)
           {
              bugs[x].walkTowards(bugs[(x+1) % 4], 0.10);
              //System.out.println("" + y + x + ": "  + bugs[x].getX() + ","  + bugs[x].getY() + "," + bugs[(x+1) % 4].getX() + "," + bugs[(x+1) % 4].getY());
              g.drawLine(bugs[x].getX(), bugs[x].getY(), bugs[(x+1) % 4].getX(), bugs[(x+1) % 4].getY());
           }
       }
    }
}
    
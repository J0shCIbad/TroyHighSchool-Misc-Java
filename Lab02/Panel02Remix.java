import javax.swing.*;
import java.awt.*;
import java.lang.Integer;
/**
 * Write a description of class Panel02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panel02Remix extends JPanel
{
    private ImageIcon pictureFile;
    private int pictureWidth, pictureHeight;
    private Color frameColor;
    private int frameCircleDiameter;
    public Panel02Remix()
    {
        pictureFile = new ImageIcon(JOptionPane.showInputDialog("#1 - Picture File Address:"));
        pictureWidth = Integer.parseInt(JOptionPane.showInputDialog("#2a - Picture Width:"));
        pictureHeight = Integer.parseInt(JOptionPane.showInputDialog("#2b - Picture Height:"));
        frameColor = new Color(Integer.parseInt(JOptionPane.showInputDialog("#3a - Frame Color (Red Component):")), Integer.parseInt(JOptionPane.showInputDialog("#3b - Frame Color (Blue Component):")), Integer.parseInt(JOptionPane.showInputDialog("#3c - Frame Color (Green Component):")));
        frameCircleDiameter = Integer.parseInt(JOptionPane.showInputDialog("#4 - Picture Frame's Circle Diameter:"));
    }
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(frameColor);
        paintFrame(g);
        g.drawImage(pictureFile.getImage(), frameCircleDiameter, frameCircleDiameter, pictureWidth, pictureHeight, null);
    }
    public void paintFrame(Graphics g)
    {
        g.fillOval(0, 0, frameCircleDiameter, frameCircleDiameter);
        g.fillOval(pictureWidth + frameCircleDiameter, 0, frameCircleDiameter, frameCircleDiameter);
        g.fillOval(pictureWidth + frameCircleDiameter, pictureHeight + frameCircleDiameter, frameCircleDiameter, frameCircleDiameter);
        g.fillOval(0, pictureHeight + frameCircleDiameter, frameCircleDiameter, frameCircleDiameter);
        
        g.fillOval(frameCircleDiameter, 0, pictureWidth, frameCircleDiameter);
        g.fillOval(frameCircleDiameter, pictureHeight + frameCircleDiameter, pictureWidth, frameCircleDiameter);
        g.fillOval(0, frameCircleDiameter, frameCircleDiameter, pictureHeight);
        g.fillOval(pictureWidth + frameCircleDiameter, frameCircleDiameter, frameCircleDiameter, pictureHeight);
    }
}

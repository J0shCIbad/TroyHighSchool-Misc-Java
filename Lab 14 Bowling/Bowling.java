import javax.swing.*;
/**
 * Bowling class for Unit 03 Lab 14: Bowling. The Bowling class allows a
 * single user to keep track of their scores in ten-pin bowling. The user
 * is welcomed to the Bowling with a dialog box, and is prompted to enter
 * their bowling scores to a dialog box displaying a bowling frame, which
 * ball is being thrown, and the total score. The numbers being entered
 * must be in the interval [0,10] or the user will be prompted again and
 * informed that the value inputed is invalid. Ten-pin bowling scoring
 * rules are applied. After entering all scores, the user is given the 
 * total score.
 * 
 * @author Josh Ibad
 * @author James Park
 * @version 13 December 2017
 * @teacher Coglianese
 * @period 2
 */
public class Bowling extends JPanel
{
    private int frame, ball, pins1, pins2, score;
    private boolean spare, strike, strikeAgain;
    /**
     * Constructor for the Bowling class. All private variables are
     * instantiated. The user is prompted with a message dialog box to
     * enter their scores. Ten-pin bowling scoring rules are used. After
     * all scores are entered, the user is shown their final score.
     */
    public Bowling()
    {
        score = 0;
        pins1 = 0;
        pins2 = 0;
        frame = 1;
        ball = 1;
        spare = false;
        strike = false;
        strikeAgain = false;
        JOptionPane.showMessageDialog(this, "Welcome to \"Computer Science Bowling\"");
        while(frame <= 10)
        {
            pins1 = Integer.parseInt(
                JOptionPane.showInputDialog(message(false)));
            while(pins1<0 || pins1>10)
            {
                pins1 = Integer.parseInt(
                    JOptionPane.showInputDialog(message(true)));
            }
            score += pins1;
            if(spare)
            {
                score += pins1;
                spare = false;
            }
            if(strike)
                score += pins1;
            if(strikeAgain)
            {
                score += pins1;
                strikeAgain = false;
            }

            if(pins1<10)
            {
                ball++;
                pins2 = Integer.parseInt(
                    JOptionPane.showInputDialog(message(false)));
                while(pins2<0 || pins2>10)
                {
                    pins2 = Integer.parseInt(
                        JOptionPane.showInputDialog(message(true)));
                }
                score += pins2;
                if(strike)
                {
                    score += pins2;
                    strike = false;
                }
                ball = 1;
                if(pins1+pins2 == 10)
                    spare = true;
            }
            else
            {
                if(strike)
                    strikeAgain = true;
                strike = true;
            }
            frame++;
        }
        if(spare || strike)
        {
            pins1 = Integer.parseInt(
                JOptionPane.showInputDialog(message(false)));
            while(pins1<0 || pins1>10)
            {
                pins1 = Integer.parseInt(
                    JOptionPane.showInputDialog(message(true)));
            }
            score += pins1;
        }
        if(strike)
        {
            pins2 = Integer.parseInt(
                JOptionPane.showInputDialog(message(false)));
            while(pins2<0 || pins2>10)
            {
                pins2 = Integer.parseInt(
                    JOptionPane.showInputDialog(message(true)));
            }
            score += pins2;
        }
        JOptionPane.showMessageDialog(this, "Finished!\nScore " + score);
    }

    /**
     * Creates the appropriate message to be displayed by the input
     * dialog box composing of the total scores, the frame number, and 
     * ball number. Also, if the previous entry was invalid, the user
     * will be informed that the previous entry was "Invalid!"
     * 
     * @param invalid   Boolean value of whether or not the previous 
     *                  user entry was valid, in order to inform the
     *                  user that the previous entry was invalid.
     */
    public String message(boolean invalid)
    {
        String message = "";
        if(invalid)
            message += "Invalid!\n";
        message += "Score " + score+ "\nFrame " + frame + ", Ball " + ball;
        return message;
    }

    /**
     * Creates an instance of the bowling class. The user may engage in a
     * series of input and output interactions in order to keep track
     * of their ten-pin bowling scores.
     * 
     * @param args  An array of string values which is ran by the program.
     */
    public static void main(String[] args)
    {
        Bowling bowling = new Bowling();
    }
}

package animations;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * An animation that take care of the YouWin screen.
 */
public class YouWin implements Animation  {
    private  String print;
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int TEXT_SIZE = 40;
    private static final int HUNDRED = 100;
    /**
     * The function get message and build YouWin with it.
     * @param print The message that the animator print.
     */
    public YouWin(String print) {
        this.print = print;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        // The white screen.
        d.setColor(Color.white);
        d.fillRectangle(ZERO, ZERO, d.getWidth(), d.getHeight());
        //Printing of "You Win! Your score is X".
        d.setColor(Color.green);
        d.drawText(HUNDRED, d.getHeight() / TWO, print, TEXT_SIZE);
    }
    @Override
    public String getPrint() {
        return this.print;
    }
    @Override
    public boolean shouldStop() {
        if (this.print.equals("space")) {
            return true;
        }
            return false;
    }
    /**
     * The function get new print and change the value of print to it.
     * @param print the new value of the print.
     */
    public void setPrint(String print) {
        this.print = print;
    }
}

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
 * An animation that will display a screen with the message paused -- press
 * space to continue until a key is pressed.
 */
public class PauseScreen implements Animation {
    //Fields.
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final int TWO = 2;
    private static final int TEXT_SIZE = 32;
    /**
     * The function get a KeyboardSensor and build a PauseScreen with it.
     * @param k
     */
    public PauseScreen(biuoop.KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        // The white screen.
        d.setColor(Color.white);
        d.fillRectangle(ZERO, ZERO, d.getWidth(), d.getHeight());
        //Printing the text.
        d.setColor(Color.black);
        d.drawText(TEN, d.getHeight() / TWO, "paused -- press space to "
                + "continue", TEXT_SIZE);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
    @Override
    public String getPrint() {
        return "a";
    }
}
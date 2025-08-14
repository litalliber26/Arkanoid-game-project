package animations;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import biuoop.DrawSurface;
/**
 * The clas represent the animations in the game.
 */
public  interface Animation {
    /**
     * The function run one frame of the game.
     * @param d the DrawSurface of the game.
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return true if the game should stop, Otherwise it return false.
     */
    boolean shouldStop();
    /**
     * @return the message that part of the animations get.
     */
    String getPrint();
}

package animations;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import biuoop.DrawSurface;
import biuoop.GUI;
/**
 *The AnimationRunner takes an Animation object and runs it.
 */
public class AnimationRunner {
    //Fields
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    private static final int FRAMES_PER_SECOND = 60;
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    /**
     * The function get gui and build AnimationRunner with it.
     * @param gui the gui of thr game.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = FRAMES_PER_SECOND;
    }
    /**
     * The function takes an Animation object and runs it.
     * @param animation one of the animators of the game.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = THOUSAND / FRAMES_PER_SECOND;
        while (!animation.shouldStop()) {
            if (animation.getPrint().equals("s")) {
                gui.close();
            }
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > ZERO) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

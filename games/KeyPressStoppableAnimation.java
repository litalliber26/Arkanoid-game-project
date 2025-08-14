package games;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import biuoop.DrawSurface;
import animations.Animation;
/**
 * The class that will wrap an existing animation and add a "waiting-for-key"
 * behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    // Fields.
    private  biuoop.KeyboardSensor keyboardSensor;
    private  String key;
    private  Animation animation;
    private boolean running = true;
    private boolean isAlreadyPressed = true;
    /**
     * The function get keyboardSensor, key and animation and build a
     * KeyPressStoppableAnimation with them.
     * @param keyboardSensor the keyboardSensor that the player tapping on it.
     * @param key the key that the animation wait for it.
     * @param animation The animation that the KeyPressStoppableAnimation add a
     * "waiting-for-key" behavior to it.
     */
    public KeyPressStoppableAnimation(biuoop.KeyboardSensor keyboardSensor,
                                      String key, Animation animation) {
        this.keyboardSensor = keyboardSensor;
        this.key = key;
        this.animation = animation;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

        if (keyboardSensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.running = false;
            }
        } else {
            isAlreadyPressed = false;
        }
    }
    @Override
    public String getPrint() {
        return "a";
    }
    @Override
    public boolean shouldStop() {
        return !running;
    }
}

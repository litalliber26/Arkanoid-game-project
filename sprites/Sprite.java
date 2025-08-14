package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import biuoop.DrawSurface;
/**
 *  A Sprite is a game object that can be drawn to the screen. The Sprite
 *  interface will be used by all the game objects.
 */
public interface Sprite {
    // draw the sprite to the screen
    /**
     * The function draw the sprite on the screen.
     * @param d The screen on which the action will draw the sprite.
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed
    /**
     * The function notify the sprite that time has passed and activates all
     * the functions that follow this.
     */
    void timePassed();
}
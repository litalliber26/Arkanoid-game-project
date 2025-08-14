package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import biuoop.DrawSurface;
import java.util.ArrayList;
/**
 * The class will hold a collection of sprites.
 */
public class SpriteCollection {
    // The collection of sprites.
    private ArrayList<Sprite> sprites;
    private static final int ZERO = 0;
    /**
     * The function builds the sprites object from the ArrayList of Sprite.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }
    /**
     * The function adds a sprite to the sprites arrayList.
     * @param s The sprite that the function adds.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    // call timePassed() on all sprites.
    /**
     * The function activates the timePassed() function on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = ZERO; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }
    // call drawOn(d) on all sprites.
    /**
     * The function activates the drawOn(d) function on all sprites.
     * @param d The screen on which the action will draw the sprites.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = ZERO; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }
    /**
     * The function remove sprite from the SpriteCollection.
     * @param s The deleted sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}
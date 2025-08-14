package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import java.awt.Color;
import biuoop.DrawSurface;
import games.GameLevel;
/**
 * The class is take care of present the level name.
 */
public class LevelName implements Sprite {
    private static final int TEXT_SIZE = 14;
    private static final int X_VALUE = 530;
    private static final int Y_VALUE = 12;

    // Fields.
    // The name of this level.
    private String name = "level";
    /**
     * The function get name and build a LevelName with it.
     * @param name the name of the level.
     */
    public LevelName(String name) {
        this.name = name;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        // drawing the level name on the DrawSurface.
        d.drawText(X_VALUE, Y_VALUE, "Level Name: " + this.name, TEXT_SIZE);
    }
    @Override
    public void timePassed() {

    }
    /**
     * the function add the LevelName to the game.
     * @param gameLevel the relevant game.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

}

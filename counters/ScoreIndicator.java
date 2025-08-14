package counters;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */
import games.GameLevel;
import sprites.Sprite;
import biuoop.DrawSurface;
import geometry.Rectangle;
import java.awt.Color;
/**
 * The ScoreIndicator which will be in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private static final int TWO = 2;
    private static final int SIX = 6;
    private static final int TEN = 10;
    private static final int FOURTEEN = 14;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final Double TWO_AND_HALF = 2.5;
    // Fields.
    // The rectangle inside it will be the ScoreIndicator.
    private  Rectangle rectangle;
    // The current score.
    private Counter score;
    /**
     * A function that receives rectangle and score and builds a
     * ScoreIndicator with them.
     * @param rectangle The rectangle inside it will be the ScoreIndicator.
     * @param score The current score.
     */
    public ScoreIndicator(Rectangle rectangle, Counter score) {
        this.rectangle = rectangle;
        this.score = score;
    }
    @Override
    public void drawOn(DrawSurface surface) {
     // The rectangular background drawing of the ScoreIndicator.
    surface.setColor(Color.gray);
    surface.drawRectangle(((int) this.rectangle.getUpperLeft().getX()),
            ((int) this.rectangle.getUpperLeft().getY()),
            ((int) this.rectangle.getWidth()),
            ((int) this.rectangle.getHeight()));
    //Listing the words: "Score:(number of scores)" on the game board.
    surface.setColor(Color.black);
    Counter counter = new Counter();
    counter.increase(this.score.getValue());
   if (counter.getValue() % TEN == TWO_AND_HALF) {
       counter.increase(THREE);
   }
        if (counter.getValue() % FIVE == TWO_AND_HALF) {
            counter.increase(THREE);
        }
    surface.drawText((int) (this.rectangle.getUpperLeft().getX()
                    + this.rectangle.getWidth() / TWO),
            (int) (this.rectangle.getUpperLeft().getY()
                    + this.rectangle.getHeight() * SIX / TEN),
            String.format("Score: %d", (int) counter.getValue()), FOURTEEN);
    }

    @Override
    public void timePassed() {
    }
    /**
     * The function add the ScoreIndicator to the game.
     * @param game The convenient game that the ScoreIndicator is added to.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}

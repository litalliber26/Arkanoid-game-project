package games;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import animations.AnimationRunner;
import animations.YouWin;
import biuoop.KeyboardSensor;
import levels.LevelInformation;
import java.util.List;
import counters.Counter;
import animations.GameOver;
/**
 * This class will be in charge of creating the different levels, and moving
 * from one level to the next.
 */
public class GameFlow {
    private  AnimationRunner runner;
    private  biuoop.KeyboardSensor keyboard;
    private  Counter score = new Counter();
    /**
     * The function get AnimationRunner and KeyboardSensor and build a
     * GameFlow with them.
     * @param ar the AnimationRunner of the game.
     * @param ks the current KeyboardSensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        runner = ar;
        keyboard = ks;
    }
    /**
     * The function initialize and run the game levels. Add GameOver/YouWin
     * screens.
     * @param levels the levels of the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, keyboard, runner, score);
            level.initialize();
            level.run();
            //if the player lost.
            if (level.status().equals("lost")) {
                GameOver gameOver =
                        new GameOver("Game Over. Your score is "
                                + (int) score.getValue());
                runner.run(
                        new KeyPressStoppableAnimation(keyboard,
                                biuoop.KeyboardSensor.SPACE_KEY,
                                gameOver));
                if (keyboard.isPressed(biuoop.KeyboardSensor.SPACE_KEY)) {
                     gameOver.setPrint("s");
                    runner.run(gameOver);
                }
                return;
            }
        }
        //if the player win.
        YouWin youWin =
                new YouWin("You Win! Your score is "
                        + (int) score.getValue());
        runner.run(
                new KeyPressStoppableAnimation(keyboard,
                        biuoop.KeyboardSensor.SPACE_KEY,
                        youWin));
        if (keyboard.isPressed(biuoop.KeyboardSensor.SPACE_KEY)) {
            youWin.setPrint("s");
            runner.run(youWin);
        }
        }
    }



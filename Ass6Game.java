// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import animations.AnimationRunner;
import games.GameFlow;
import levels.DirectHit;
import levels.Green3;
import levels.LevelInformation;
import levels.WideEasy;
import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;
/**
 *Class Name: AssGame
 * A class implements the game of assistant 6.
 */
public class Ass6Game {
    //constants.
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int GUI_WIDTH = 800;
    private static final int GIU_HEIGHT = 600;
    /**
     * The main define,initialize and restart the game flow.
     * @param args  An array of game levels that the user choose to run.
     */
    public static void main(String[] args) {
        // A list of the game levels.
        List<LevelInformation> gameOrder = new ArrayList<>();
        //Get the user choices.
        for (String i : args) {
            int userChoice = ZERO;
            try {
                userChoice = Integer.parseInt(i);
            } catch (NumberFormatException e) {
                continue;
            }
            //Creating the game order according to the user choice.
            if (userChoice < ONE || userChoice > THREE) {
                continue;
            }
            switch (userChoice) {
                case ONE:
                    gameOrder.add(new DirectHit());
                    break;
                case TWO:
                    gameOrder.add(new WideEasy());
                    break;
                case THREE:
                    gameOrder.add(new Green3());
                    break;
                default:
            }
        }
        //Create the default game order.
        if (gameOrder.size() == ZERO) {
            gameOrder.add(new DirectHit());
            gameOrder.add(new WideEasy());
            gameOrder.add(new Green3());
        }
        // Creating the GUI of the game.
        GUI gui = new GUI("Arkanoid", GUI_WIDTH, GIU_HEIGHT);
        //Creating the game flow.
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui),
                gui.getKeyboardSensor());
        // Run the game.
        gameFlow.runLevels(gameOrder);
    }
}


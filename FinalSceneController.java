import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * This is the controller for the final scene
 */
public class FinalSceneController {
    @FXML
    Label highScore;
    @FXML
    Label currentScore;
    @FXML
    Button playAgainButton;

    /**
     * Sets up the information for this scene
     */
    @FXML
    public void initialize(){
        highScore.setText("High Score: " + TitleController.highScore);
        currentScore.setText("Current Score: " + QuestionController.score);
    }

    /**
     * This will reset some data and switch the scene to the title page
     * @throws IOException
     */
    @FXML
    public void playAgainClicked() throws IOException {
        StageManager sm = new StageManager();
        QuestionController temp = new QuestionController();
        temp.resetScore();

        QuestionController.questionNumber = 0;

        sm.switchScene("TitleScene.fxml");

    }
}

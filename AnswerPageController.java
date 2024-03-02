import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

/**
 * This is the controller class for the answer page.
 */
public class AnswerPageController {
    @FXML
    Label rightOrWrong;
    @FXML
    Button nextQuestionButton;

    /**
     * This will switch the scene to the next question or the final scene
     * @throws IOException
     */
    @FXML
    public void nextQuestionClicked() throws IOException {
        StageManager sm = new StageManager();
        if(QuestionController.moreQuestions) {
            sm.switchScene("QuestionScene.fxml");
        } else {
            TitleController tc = new TitleController();
            tc.setHighScore(QuestionController.score);
            sm.switchScene("FinalScene.fxml");
        }
    }

    /**
     * This method gets information and displays it
     */
    @FXML
    public void initialize(){
        QuestionController temp = new QuestionController();
        rightOrWrong.setText(temp.getLastResponse());
    }

}

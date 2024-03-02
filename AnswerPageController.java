import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

public class AnswerPageController {
    @FXML
    Label rightOrWrong;
    @FXML
    Button nextQuestionButton;
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

    @FXML
    public void initialize(){
        QuestionController temp = new QuestionController();
        rightOrWrong.setText(temp.getLastResponse());
    }

}

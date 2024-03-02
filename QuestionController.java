import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is the controller for the QuestionScene page.
 */
public class QuestionController {

    @FXML
    Button a;
    @FXML
    Button b;
    @FXML
    Button c;
    @FXML
    Button d;
    @FXML
    Label questionText;
    @FXML
    Label scoreLabel;
    static int questionNumber = 0;
    static int score = 0;
    private static String lastResponse = "";
    static boolean moreQuestions = true;

    /**
     * This will switch the scene and update some data
     * @param event click
     * @throws IOException
     */
    @FXML
    public void answerClicked(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        StageManager sm = new StageManager();
        if(button.getText().equals(TitleController.triviaQuestions.getResults().get(questionNumber).getCorrect_answer())) {
            lastResponse = "Correct!";
            score++;
        } else{
            lastResponse = "Incorrect... the correct answer was: " + TitleController.triviaQuestions.getResults().get(questionNumber).getCorrect_answer();
        }

        questionNumber++;

        sm.switchScene("AnswerPage.fxml");

    }

    /**
     * This initializes the scene by getting information from the triviaQuestions
     * (TriviaQuestions object) from TitleController.
     * @throws IOException
     */
    @FXML
    public void initialize() throws IOException {

        if(questionNumber < TitleController.triviaQuestions.getResults().size()) {
            questionText.setWrapText(true);
            a.setWrapText(true);
            b.setWrapText(true);
            c.setWrapText(true);
            d.setWrapText(true);
            moreQuestions = true; //unsure if this is needed, probably
            String question = TitleController.triviaQuestions.getResults().get(questionNumber).getQuestion().replaceAll("&quot","\"").replaceAll("&#039;","'");
            questionText.setText(question);
            ArrayList<String> answers = new ArrayList<>();
            answers.addAll(TitleController.triviaQuestions.getResults().get(questionNumber).getIncorrect_answers());
            answers.add(TitleController.triviaQuestions.getResults().get(questionNumber).getCorrect_answer());
            Collections.shuffle(answers);
            a.setText(answers.get(0).replaceAll("&quot","\"").replaceAll("&#039;","'"));
            b.setText(answers.get(1).replaceAll("&quot","\"").replaceAll("&#039;","'"));
            c.setText(answers.get(2).replaceAll("&quot","\"").replaceAll("&#039;","'"));
            d.setText(answers.get(3).replaceAll("&quot","\"").replaceAll("&#039;","'"));
            scoreLabel.setText("Score: " + score);
        }
        if(questionNumber == TitleController.triviaQuestions.getResults().size() -1) {
            moreQuestions = false;
        }
    }

    /**
     * gets last response information
     * @return lastResponse
     */
    public String getLastResponse() {
        return lastResponse;
    }

    /**
     * resets the score
     */
    public void resetScore(){
        score = 0;
    }


}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TitleController implements Initializable {
    private StageManager sm = new StageManager();
    static TriviaQuestions triviaQuestions = new TriviaQuestions();

    static int highScore = 0;

    @FXML
    ChoiceBox<String> categoryBox;
    @FXML
    ChoiceBox<String> questionBox;
    @FXML
    ChoiceBox<String> difficultyBox;
    @FXML
    Label emptyFieldLabel;
    @FXML
    Label highScoreDisplay;

    private static String category = "9";
    private static String numberOfQuestion = "10";
    private static String difficulty = "easy";
    Trivia needToWorkOnNamingConventions = new Trivia();

    private ArrayList<String> categories = new ArrayList<>();

    @FXML
    Button startButton;
    @FXML
    public void startClicked() throws IOException {
        APIHandler temp = new APIHandler();
        try {
            triviaQuestions = temp.getQuestions(category, numberOfQuestion, difficulty);
            if (triviaQuestions.getResponse_code() == 0) {
                sm.switchScene("QuestionScene.fxml");
            } else {
                emptyFieldLabel.setText("Too many questions for this category");
            }
        } catch(RuntimeException e){
            emptyFieldLabel.setText("You have to wait 5 seconds for the API");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        highScoreDisplay.setText("High Score: " + highScore);
        APIHandler temp = new APIHandler();
        needToWorkOnNamingConventions = temp.getCategories();
        for(int i = 0; i < needToWorkOnNamingConventions.getTrivia_categories().size(); i++){
            categories.add(needToWorkOnNamingConventions.getTrivia_categories().get(i).getName());
        }
        categoryBox.getItems().addAll(categories);
        difficultyBox.getItems().addAll("easy", "medium", "hard");
        questionBox.getItems().addAll("1", "5", "10", "20", "30", "40", "50");
        difficultyBox.setOnAction(this::getDifficulty);
        categoryBox.setOnAction(this::getCategory);
        questionBox.setOnAction(this::getQuestions);
    }
    public void getCategory(ActionEvent event) {
        String temp = categoryBox.getValue();
        for(int i = 0; i < needToWorkOnNamingConventions.getTrivia_categories().size(); i++){
            if(temp.equals(needToWorkOnNamingConventions.getTrivia_categories().get(i).getName())){
                int id = needToWorkOnNamingConventions.getTrivia_categories().get(i).getId();
                category = Integer.toString(id);
            }
        }

    }
    public void getDifficulty(ActionEvent event){
        difficulty = difficultyBox.getValue();
    }
    public void getQuestions(ActionEvent event){
        numberOfQuestion = questionBox.getValue();
    }
    public void setHighScore(int score) {
        if(score > highScore){
            highScore = score;
        }


    }
}

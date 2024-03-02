import java.util.List;

/**
 * This class holds the list of questions
 */
public class TriviaQuestions {
    private int response_code;
    private List<Question> results;

    public int getResponse_code() {
        return response_code;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}

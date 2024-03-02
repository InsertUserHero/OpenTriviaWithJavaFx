import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class handles the switching of scenes and
 * setting up the initial scene.
 */
public class StageManager {
    private static final APIHandler apiHandler = new APIHandler();
    private static final Stage stage = new Stage();
    public void showInitialScene() throws IOException {
        Parent title = FXMLLoader.load(getClass().getResource("TitleScene.fxml"));
        Scene scene = new Scene(title);
        stage.setScene(scene);
        stage.show();
    }

    public void switchScene(String fxmlFile) throws IOException {
        Parent temp = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.setScene(new Scene(temp));
    }


}

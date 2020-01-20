import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test Application with JavaFX");
        primaryStage.setScene(new Scene(new FrameMainWindow().build(), 800, 600));
        primaryStage.show();
    }
}
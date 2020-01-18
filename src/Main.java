import gengui.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reference Application with JavaFX");

        ElementRecipe<VBox> pane = new Vertical(Arrays.asList(
                // horizontal orientation
                new Horizontal(Arrays.asList(
                    // vertical orientation
                    new Vertical(Arrays.asList(
                            // labels
                            new Label("Label A"),
                            new Label("Label B")
                    )),

                    // vertical orientation
                    new Vertical(Arrays.asList(
                            // textfields
                            new TextField("Textfielsd A"),
                            new TextField("Textfield B")
                    ))
                )),

                // buttons
                new Button("Button A"),
                new Button("Button B"),

                // radio buttons
                new RadioButtons(0, Arrays.asList(
                        "Choice A", "Choice B", "Choice C", "Choice D"
                )),

                // check boxes
                new CheckBox(true, "Checkbox A"),
                new CheckBox(false, "Checkbox B")
        ));

        primaryStage.setScene(new Scene(pane.build(), 400, 250));
        primaryStage.show();
    }
}
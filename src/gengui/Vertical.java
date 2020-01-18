package gengui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class Vertical extends Pane<VBox>
{
    public Vertical(List<GuiRecipe> recipes)
    {
        super(VBox.class, recipes);
    }
}

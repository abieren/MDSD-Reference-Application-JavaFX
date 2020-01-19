package guigen;

import javafx.scene.layout.VBox;

import java.util.List;

public class Vertical extends JavaFXPane<VBox>
{
    public Vertical(List<GuiRecipe> recipes)
    {
        super(VBox.class, recipes);
    }
}

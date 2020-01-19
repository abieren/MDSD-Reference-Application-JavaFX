package guigen;

import javafx.scene.layout.HBox;

import java.util.List;

public class Horizontal extends JavaFXPane<HBox>
{
    public Horizontal(List<GuiRecipe> recipes)
    {
        super(HBox.class, recipes);
    }
}

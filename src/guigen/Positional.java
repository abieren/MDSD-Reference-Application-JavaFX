package guigen;

import javafx.scene.layout.Pane;
import java.util.List;

public class Positional extends JavaFXPane<Pane>
{
    public Positional(List<GuiRecipe> recipes)
    {
        super(Pane.class, recipes);
    }
}

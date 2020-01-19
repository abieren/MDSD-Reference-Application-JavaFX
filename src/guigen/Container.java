package guigen;

import javafx.scene.layout.Pane;

import java.util.List;

public class Container extends JavaFXPane<Pane>
{
    public Container(List<GuiRecipe> recipes)
    {
        super(Pane.class, recipes);
    }
}

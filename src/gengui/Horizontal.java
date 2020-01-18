package gengui;

import javafx.scene.layout.HBox;

import java.util.List;

public class Horizontal extends Pane<HBox>
{
    public Horizontal(List<GuiRecipe> recipes)
    {
        super(HBox.class, recipes);
    }
}

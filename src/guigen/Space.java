package guigen;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.List;

public class Space implements ElementRecipe<Pane>
{
    private final int width;
    private final int height;

    public Space(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public Pane build()
    {
        Pane pane = new Pane();
        pane.setPrefWidth(width);
        pane.setMaxWidth(width);
        pane.setMaxHeight(height);
        pane.setPrefHeight(height);
        return pane;
    }
}

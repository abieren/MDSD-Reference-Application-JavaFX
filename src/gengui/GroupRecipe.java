package gengui;

import javafx.scene.Node;

import java.util.List;

public interface GroupRecipe<T extends Node> extends GuiRecipe<T>
{
    @Override
    default ElementRecipe<T> castElementRecipe()
    {
        return null;
    }

    @Override
    default GroupRecipe<T> castGroupRecipe()
    {
        return this;
    }

    List<T> build();
}

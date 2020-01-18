package gengui;

import javafx.scene.Node;

public interface ElementRecipe<T extends Node> extends GuiRecipe<T>
{
    @Override
    default ElementRecipe<T> castElementRecipe()
    {
        return this;
    }

    @Override
    default GroupRecipe<T> castGroupRecipe()
    {
        return null;
    }

    T build();
}

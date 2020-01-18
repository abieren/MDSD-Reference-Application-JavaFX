package gengui;

import gengui.ElementRecipe;
import javafx.scene.Node;

public interface GuiRecipe<T extends Node>
{
    ElementRecipe<T> castElementRecipe();
    GroupRecipe<T> castGroupRecipe();
}

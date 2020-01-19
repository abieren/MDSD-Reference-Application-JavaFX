package guigen;

import javafx.scene.Node;

import java.util.function.Function;

public class Position<T extends Node> extends AlterElement<T>
{
    public Position(int positionX, int positionY, ElementRecipe<T> element)
    {
        super(element, e -> {
            e.setLayoutX(positionX);
            e.setLayoutY(positionY);
            return e;
        });
    }
}

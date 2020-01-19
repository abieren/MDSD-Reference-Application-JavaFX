package guigen;

import javafx.scene.Node;
import java.util.function.Function;

public class AlterElement<T extends Node> implements ElementRecipe<T>
{
    private Function<T, T> alterFunction;
    private ElementRecipe<T> alterElement;

    public AlterElement(ElementRecipe<T> alterElement, Function<T, T> alterFunction)
    {
        this.alterFunction = alterFunction;
        this.alterElement = alterElement;
    }

    @Override
    public T build()
    {
        return alterFunction.apply(alterElement.build());
    }
}

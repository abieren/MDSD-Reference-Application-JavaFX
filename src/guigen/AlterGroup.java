package guigen;

import javafx.scene.Node;

import java.util.List;
import java.util.function.Function;

public class AlterGroup<T extends Node> implements GroupRecipe<T>
{
    private Function<List<T>, List<T>> alterFunction;
    private GroupRecipe<T> alterGroup;

    public AlterGroup(Function<List<T>, List<T>> alterFunction, GroupRecipe<T> alterGroup)
    {
        this.alterFunction = alterFunction;
        this.alterGroup = alterGroup;
    }

    @Override
    public List<T> build()
    {
        return alterFunction.apply(alterGroup.build());
    }
}

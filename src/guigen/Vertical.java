package guigen;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.List;
import java.util.stream.IntStream;

public class Vertical implements ElementRecipe<GridPane>
{
    private Integer fixed;
    private List<GuiRecipe> recipes;

    public Vertical(Integer fixed, List<GuiRecipe> recipes)
    {
        this.fixed = fixed;
        this.recipes = recipes;
    }

    @Override
    public GridPane build()
    {
        GridPane grid = new GridPane();
        int counter = 0;

        for (GuiRecipe recipe : recipes)
        {
            if (recipe == null) continue;
            ElementRecipe elementRecipe = recipe.castElementRecipe();
            GroupRecipe groupRecipe = recipe.castGroupRecipe();

            if (elementRecipe != null)
            {
                grid.add(elementRecipe.build(), 0, counter);
                counter++;
            }
            else if (groupRecipe != null)
            {
                List<Node> groupElements = (List<Node>)groupRecipe.build();
                for (Node element : groupElements)
                {
                    grid.add(element, 0, counter);
                    counter++;
                }
            }
        }

        if (counter != 0 && fixed == null)
        {
            RowConstraints cc = new RowConstraints();
            cc.setPercentHeight(100.0 / (double)counter);
            IntStream.range(0, counter).forEach(x ->grid.getRowConstraints().add(cc));
        }
        else if (fixed != null && fixed != 0)
        {
            RowConstraints cc = new RowConstraints();
            cc.setPrefHeight(fixed);
            cc.setMaxHeight(fixed);
            IntStream.range(0, counter).forEach(x ->grid.getRowConstraints().add(cc));
        }

        return grid;
    }
}

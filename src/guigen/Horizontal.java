package guigen;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;
import java.util.stream.IntStream;

public class Horizontal implements ElementRecipe<GridPane>
{
    private Integer fixed;
    private List<GuiRecipe> recipes;

    public Horizontal(Integer fixed, List<GuiRecipe> recipes)
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
                grid.add(elementRecipe.build(), counter, 0);
                counter++;
            }
            else if (groupRecipe != null)
            {
                List<Node> groupElements = (List<Node>)groupRecipe.build();
                for (Node element : groupElements)
                {
                    grid.add(element, counter, 0);
                    counter++;
                }
            }
        }

        if (counter != 0 && fixed == null)
        {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0 / (double)counter);
            IntStream.range(0, counter).forEach(x ->grid.getColumnConstraints().add(cc));
        }
        else if (fixed != null && fixed != 0)
        {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPrefWidth(fixed);
            cc.setMaxWidth(fixed);
            IntStream.range(0, counter).forEach(x ->grid.getColumnConstraints().add(cc));
        }

        return grid;
    }
}

package guigen;

import javafx.scene.Node;

import java.util.List;

public class JavaFXPane<P extends javafx.scene.layout.Pane> implements ElementRecipe<P>
{
    private Class<P> clazz;
    private List<GuiRecipe> recipes;

    public JavaFXPane(Class<P> clazz, List<GuiRecipe> recipes)
    {
        this.clazz = clazz;
        this.recipes = recipes;
    }

    @Override
    public P build()
    {
        P p = null;
        try {p = clazz.newInstance();}
        catch (Exception e) {throw new RuntimeException(e);}
        P pane = p;

        recipes.forEach(recipe -> {
            ElementRecipe elementRecipe = recipe.castElementRecipe();
            GroupRecipe groupRecipe = recipe.castGroupRecipe();

            if (elementRecipe != null)
            {
                pane.getChildren().add(elementRecipe.build());
            }
            else if (groupRecipe != null)
            {
                List<Node> groupElements = (List<Node>)groupRecipe.build();
                groupElements.forEach(groupElement -> {
                    pane.getChildren().add(groupElement);
                });
            }
        });

        return pane;
    }
}

package gengui;

public class Button implements ElementRecipe<javafx.scene.control.Button>
{
    private String label;

    public Button(String label)
    {
        this.label = label;
    }

    @Override
    public javafx.scene.control.Button build()
    {
        return new javafx.scene.control.Button(label);
    }
}

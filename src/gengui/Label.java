package gengui;

public class Label implements ElementRecipe<javafx.scene.control.Label>
{
    private String label;

    public Label(String label)
    {
        this.label = label;
    }

    @Override
    public javafx.scene.control.Label build()
    {
        return new javafx.scene.control.Label(label);
    }
}

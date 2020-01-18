package gengui;

public class CheckBox implements ElementRecipe<javafx.scene.control.CheckBox>
{
    private boolean toggled;
    private String label;

    public CheckBox(boolean toggled, String label)
    {
        this.toggled = toggled;
        this.label = label;
    }

    @Override
    public javafx.scene.control.CheckBox build()
    {
        final javafx.scene.control.CheckBox checkBox = new javafx.scene.control.CheckBox(label);
        checkBox.setSelected(toggled);
        return checkBox;
    }
}

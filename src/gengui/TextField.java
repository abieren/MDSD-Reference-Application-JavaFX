package gengui;

public class TextField implements ElementRecipe<javafx.scene.control.TextField>
{
    private String text;

    public TextField(String text)
    {
        this.text = text;
    }

    @Override
    public javafx.scene.control.TextField build()
    {
        javafx.scene.control.TextField textField = new javafx.scene.control.TextField();
        textField.setPromptText(text);
        return textField;
    }
}

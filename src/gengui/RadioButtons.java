package gengui;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class RadioButtons implements GroupRecipe<RadioButton>
{
    private int toggledIndex;
    private List<String> labels;

    public RadioButtons(int toggledIndex, List<String> labels)
    {
        this.toggledIndex = toggledIndex;
        this.labels = labels;
    }

    @Override
    public List<RadioButton> build()
    {
        final ArrayList<RadioButton> radioButtons = new ArrayList<>();
        final ToggleGroup toggleGroup = new ToggleGroup();

        labels.forEach(label -> {
            RadioButton radioButton = new RadioButton(label);
            radioButton.setToggleGroup(toggleGroup);
            radioButtons.add(radioButton);
        });

        radioButtons.get(toggledIndex).setSelected(true);
        return radioButtons;
    }
}

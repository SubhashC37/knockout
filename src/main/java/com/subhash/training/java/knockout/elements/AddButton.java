package com.subhash.training.java.knockout.elements;

import com.subhash.training.java.knockout.event.AddEvent;
import javafx.scene.control.TextField;

public class AddButton extends ButtonElement {
    private TextField addMemberText;

    public AddButton(final String buttonName, final TextField addMemberText) {
        super(buttonName);
        this.addMemberText = addMemberText;
        setButtonProperties();
    }

    @Override
    void setButtonProperties() {
        button.setOnAction(new AddEvent(addMemberText));
        button.setLayoutX(150);
        button.setLayoutY(1);
    }
}

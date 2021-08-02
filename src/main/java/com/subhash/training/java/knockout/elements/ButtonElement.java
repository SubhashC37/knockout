package com.subhash.training.java.knockout.elements;

import javafx.scene.control.Button;

public abstract class ButtonElement {
    Button button;

    ButtonElement(final String buttonName) {
        button = new Button(buttonName);
        setButtonProperties();
    }

    public Button getButton() {
        return button;
    }

    abstract void setButtonProperties();
}

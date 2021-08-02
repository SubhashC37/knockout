package com.subhash.training.java.knockout.elements;

import com.subhash.training.java.knockout.event.CopyTableEvent;

public class CopyButton extends ButtonElement {

    public CopyButton(final String buttonName) {
        super(buttonName);
    }

    @Override
    void setButtonProperties() {
        button.setOnAction(new CopyTableEvent());
        button.setLayoutX(200);
        button.setLayoutY(1);
    }
}

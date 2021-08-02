package com.subhash.training.java.knockout.event.extentions;

import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class TableEventExt extends StageEventExt {
    protected TextField time;
    protected Timeline timeline;
    protected Button action;
    protected Button edit;
    protected String name;

    protected TableEventExt(String name, TextField time, Timeline timeline, Button action, Button editButton) {
        this.time = time;
        this.timeline = timeline;
        this.action = action;
        this.edit = editButton;
        this.name = name;
    }
}

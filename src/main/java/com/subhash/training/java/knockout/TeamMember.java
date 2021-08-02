package com.subhash.training.java.knockout;

import com.subhash.training.java.knockout.event.ActionTableEvent;
import com.subhash.training.java.knockout.event.DeleteTableEvent;
import com.subhash.training.java.knockout.event.EditTableEvent;
import com.subhash.training.java.knockout.event.ResetTableEvent;
import com.subhash.training.java.knockout.event.TimelineTableEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.Objects;

import static com.subhash.training.java.knockout.util.Constants.DEFAULT_TIME;
import static com.subhash.training.java.knockout.util.Constants.DELETE;
import static com.subhash.training.java.knockout.util.Constants.EDIT;
import static com.subhash.training.java.knockout.util.Constants.RESET;
import static com.subhash.training.java.knockout.util.Constants.START;

public class TeamMember {
    private String name;
    private TextField time = new TextField(DEFAULT_TIME);
    private Button action = new Button(START);
    private Button reset = new Button(RESET);
    private Button edit = new Button(EDIT);
    private Button delete = new Button(DELETE);
    private TimelineTableEvent tae;
    private Timeline timeline;

    public TeamMember(String name) {
        tae = new TimelineTableEvent(name, time, action, edit);
        timeline = new Timeline(new KeyFrame(Duration.millis(1), tae));
        this.name = name;
        init();
    }

    private void init() {
        initTimeFiled(false);
        initTimeline();
        initActionButton();
        initEditButton();
        initResetButton();
        initDeleteButton();
    }

    private void initTimeFiled(final boolean editable) {
        time.setEditable(editable);
    }

    private void initTimeline() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
    }

    private void initActionButton() {
        action.setOnAction(new ActionTableEvent(name, time, timeline, action, edit));
    }

    private void initResetButton() {
        reset.setOnAction(new ResetTableEvent(name, time, timeline, action, edit, tae));
    }

    private void initEditButton() {
        edit.setDisable(true);
        edit.setOnAction(new EditTableEvent(name, time, timeline, action, edit, tae));
    }

    private void initDeleteButton() {
        //delete.setPrefSize(25,25);
        delete.setOnAction(new DeleteTableEvent(name, time, timeline, action, edit));
    }

    public Button getReset() {
        return reset;
    }

    public void setReset(Button reset) {
        this.reset = reset;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public TextField getTime() {
        return time;
    }

    public void setTime(TextField time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember that = (TeamMember) o;
        return name.equals(that.name);
    }

    @Override
    public String toString() {
        return name + "=" + time.getText();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

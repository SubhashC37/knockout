package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.event.extentions.TableEventExt;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.EDIT;
import static com.subhash.training.java.knockout.util.Constants.RESUME;
import static com.subhash.training.java.knockout.util.Constants.STOP;

public class ActionTableEvent extends TableEventExt {
    private static Logger logger = LoggerFactory.getLogger(EditTableEvent.class);

    public ActionTableEvent(String name, TextField time, Timeline timeline, Button action, Button edit) {
        super(name, time, timeline, action, edit);
    }

    @Override
    public void handle(Event event) {
        time.setEditable(false);
        if (action.getText().equals(STOP)) {
            edit.setDisable(false);
            action.setText(RESUME);
            timeline.pause();
            logger.info("Team member: {} time has been stopped", name);
            return;
        }
        timeline.play();
        edit.setDisable(true);
        if (action.getText().equals(RESUME)) {
            edit.setText(EDIT);
        }
        action.setText(STOP);
        logger.info("Team member: {} time has been started/resumed", name);
    }
}

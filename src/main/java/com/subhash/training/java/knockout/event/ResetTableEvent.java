package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.event.extentions.TableEventExt;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.DEFAULT_TIME;
import static com.subhash.training.java.knockout.util.Constants.EDIT;
import static com.subhash.training.java.knockout.util.Constants.START;

public class ResetTableEvent extends TableEventExt {
    private static Logger logger = LoggerFactory.getLogger(ResetTableEvent.class);
    private TimelineTableEvent tae;

    public ResetTableEvent(String name, TextField time, Timeline timeline, Button action, Button edit, TimelineTableEvent tae) {
        super(name, time, timeline, action, edit);
        this.tae = tae;
    }

    @Override
    public void handle(Event event) {
        tae.setMins(0);
        tae.setSecs(0);
        tae.setMillis(0);
        timeline.pause();
        time.setText(DEFAULT_TIME);
        action.setText(START);
        edit.setText(EDIT);
        edit.setDisable(true);
        time.setEditable(false);
        logger.info("Team member: {} time has been reset", name);
    }
}

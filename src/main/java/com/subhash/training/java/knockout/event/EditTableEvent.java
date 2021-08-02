package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.event.extentions.TableEventExt;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.EDIT;
import static com.subhash.training.java.knockout.util.Constants.SAVE;
import static com.subhash.training.java.knockout.util.Constants.STOP;

public class EditTableEvent extends TableEventExt {
    private static Logger logger = LoggerFactory.getLogger(EditTableEvent.class);
    private TimelineTableEvent tae;
    private String oldValue;

    public EditTableEvent(String name, TextField time, Timeline timeline, Button action, Button edit, TimelineTableEvent tae) {
        super(name, time, timeline, action, edit);
        this.tae = tae;
    }

    @Override
    public void handle(Event event) {
        if (action.getText().equals(STOP)) {
            return;
        }
        if (edit.getText().equals(EDIT)) {
            time.setEditable(true);
            edit.setText(SAVE);
            oldValue = time.getText();
        } else {
            String timeValue = time.getCharacters().toString();
            String[] timeRep = timeValue.split(":");
            tae.setMins(Integer.valueOf(timeRep[0]));
            tae.setSecs(Integer.valueOf(timeRep[1]));
            tae.setMillis(Integer.valueOf(timeRep[2]));
            timeline.pause();
            time.setText(timeValue);
            edit.setText(EDIT);
            time.setEditable(false);
            logger.info("Team member: {} time has been updated from: [{}] to [{}]", name, oldValue, timeValue);
        }
    }
}

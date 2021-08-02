package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.event.extentions.TableEventExt;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static com.subhash.training.java.knockout.util.Constants.COLON;
import static com.subhash.training.java.knockout.util.Constants.EMPTY_STRING;
import static com.subhash.training.java.knockout.util.Constants.ZERO;

public class TimelineTableEvent extends TableEventExt {
    private int mins = 0, secs = 0, millis = 0;

    public TimelineTableEvent(String name, TextField time, Button startButton, Button editButton) {
        super(name, time, null, startButton, editButton);
    }

    @Override
    public void handle(Event event) {
        if (millis == 1000) {
            secs++;
            millis = 0;
        }
        if (secs == 60) {
            mins++;
            secs = 0;
        }
        time.setText((((mins / 10) == 0) ? ZERO : EMPTY_STRING) + mins + COLON
                + (((secs / 10) == 0) ? ZERO : EMPTY_STRING) + secs + COLON
                + (((millis / 10) == 0) ? ZERO + ZERO : (((millis / 100) == 0) ? ZERO : EMPTY_STRING)) + millis++);
    }

    void setMins(Integer mins) {
        this.mins = mins;
    }

    void setSecs(Integer secs) {
        this.secs = secs;
    }

    void setMillis(Integer millis) {
        this.millis = millis;
    }

}

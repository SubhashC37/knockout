package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.event.extentions.StageEventExt;
import com.subhash.training.java.knockout.util.CopyUtil;
import javafx.event.Event;

public class CopyTableEvent extends StageEventExt {
    @Override
    public void handle(Event event) {
        CopyUtil.copyAndGetContent();
    }
}

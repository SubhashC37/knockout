package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.TeamMember;
import com.subhash.training.java.knockout.elements.TableViewExt;
import com.subhash.training.java.knockout.event.extentions.TableEventExt;
import com.subhash.training.java.knockout.util.ConfigurationUtil;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.TEAM_MEMBER;

public class DeleteTableEvent extends TableEventExt {
    private static Logger logger = LoggerFactory.getLogger(DeleteTableEvent.class);

    public DeleteTableEvent(String name, TextField time, Timeline timeline, Button action, Button edit) {
        super(name, time, timeline, action, edit);
    }

    @Override
    public void handle(Event event) {
        TableViewExt.getTableViewExt().getTableView().getItems().removeIf(i -> ((TeamMember) i).getName().equals(name));
        ConfigurationUtil.getConfigurationUtil().removeConfigData(TEAM_MEMBER, name);
        logger.info("Team member: {} has been deleted from the list", name);
    }
}

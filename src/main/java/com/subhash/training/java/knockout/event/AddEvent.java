package com.subhash.training.java.knockout.event;

import com.subhash.training.java.knockout.TeamMember;
import com.subhash.training.java.knockout.elements.TableViewExt;
import com.subhash.training.java.knockout.event.extentions.StageEventExt;
import com.subhash.training.java.knockout.util.ConfigurationUtil;
import javafx.event.Event;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.TEAM_MEMBER;

public class AddEvent extends StageEventExt {
    private static Logger logger = LoggerFactory.getLogger(AddEvent.class);
    private javafx.scene.control.TextField addMemberText;

    public AddEvent(final TextField addMemberText) {
        this.addMemberText = addMemberText;
    }

    @Override
    public void handle(Event event) {
        String newMemberName = addMemberText.getText();
        if (newMemberName != null && !newMemberName.isEmpty()) {
            ConfigurationUtil configUtil = ConfigurationUtil.getConfigurationUtil();
            configUtil.addConfigData(TEAM_MEMBER, newMemberName);
            TableViewExt.getTableViewExt().getTableView().getItems().add(new TeamMember(addMemberText.getText()));
        }
        addMemberText.clear();
        logger.info("New team member: {} has been added", newMemberName);

    }
}

package com.subhash.training.java.knockout.elements;

import com.subhash.training.java.knockout.TeamMember;
import com.subhash.training.java.knockout.util.ConfigurationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.subhash.training.java.knockout.util.Constants.ACTION;
import static com.subhash.training.java.knockout.util.Constants.DELETE;
import static com.subhash.training.java.knockout.util.Constants.EDIT;
import static com.subhash.training.java.knockout.util.Constants.NAME;
import static com.subhash.training.java.knockout.util.Constants.RESET;
import static com.subhash.training.java.knockout.util.Constants.TEAM_MEMBER;
import static com.subhash.training.java.knockout.util.Constants.TIME;

public class TableViewExt {
    private static TableViewExt INSTANCE;
    private TableView tableView;

    private TableViewExt() {
        intTableView();
    }

    private List<TeamMember> teamMembers = new ArrayList<>();

    public TableView getTableView() {
        return tableView;
    }

    public int getTableSize() {
        return teamMembers.size();
    }

    public static TableViewExt getTableViewExt() {
        if (INSTANCE == null) {
            INSTANCE = new TableViewExt();
        }
        return INSTANCE;
    }

    private void intTableView() {
        ConfigurationUtil configUtil = ConfigurationUtil.getConfigurationUtil();
        configUtil.getList(TEAM_MEMBER).forEach((c) -> teamMembers.add(new TeamMember((String) c)));
        Collections.shuffle(teamMembers);
        ObservableList<TeamMember> data = FXCollections.observableArrayList(teamMembers);

        tableView = new TableView<>(data);
        //tableView.setEditable(true);
        //tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().addAll(
                getColumn(NAME, 75),
                getColumn(TIME, 70),
                getColumn(ACTION, 70),
                getColumn(RESET, 50),
                getColumn(EDIT, 50),
                getColumn(DELETE, 50)
        );
        tableView.setItems(data);
    }

    private TableColumn<TeamMember, Button> getColumn(final String columnName, final int maxWidth) {
        TableColumn<TeamMember, Button> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(columnName));
        column.setMaxWidth(maxWidth);
        return column;
    }
}

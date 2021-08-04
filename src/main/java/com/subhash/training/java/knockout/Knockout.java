package com.subhash.training.java.knockout;

import com.subhash.training.java.knockout.elements.AddButton;
import com.subhash.training.java.knockout.elements.CopyButton;
import com.subhash.training.java.knockout.elements.TableViewExt;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.ADD_MEMBER;
import static com.subhash.training.java.knockout.util.Constants.COPY;
import static com.subhash.training.java.knockout.util.Constants.SCENE_BASE_HEIGHT;
import static com.subhash.training.java.knockout.util.Constants.SCENE_BASE_WIDTH;
import static com.subhash.training.java.knockout.util.Constants.STOP_WATCH;
import static com.subhash.training.java.knockout.util.Constants.TABLE_COLUMN_SIZE;
import static com.subhash.training.java.knockout.util.Constants.TABLE_CSS_FILE_NAME;
import static com.subhash.training.java.knockout.util.Constants.VBOX_SIZE;

public class Knockout {
    private static Logger logger = LoggerFactory.getLogger(Knockout.class);
    private Stage stage;

    Knockout(Stage stage) {
        this.stage = stage;
    }

    public void knockout() {
        try {
            Pane root = new Pane();

            TableViewExt tableViewExt = TableViewExt.getTableViewExt();
            TableView tableView = tableViewExt.getTableView();

            TextField addMemberText = new TextField();
            addMemberText.setLayoutX(1);
            addMemberText.setLayoutY(1);

            HBox hBox = new HBox(VBOX_SIZE);
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(tableView);
            VBox vBox = new VBox(VBOX_SIZE);
            vBox.setAlignment(Pos.CENTER);
            vBox.setLayoutX(1);
            vBox.setLayoutY(30);
            vBox.getChildren().addAll(hBox);

            root.getChildren().addAll(vBox, addMemberText, new AddButton(ADD_MEMBER, addMemberText).getButton(), new CopyButton(COPY).getButton());

            Scene scene = new Scene(root, SCENE_BASE_WIDTH, SCENE_BASE_HEIGHT + TABLE_COLUMN_SIZE * tableViewExt.getTableSize());
            scene.getStylesheets().add(getClass().getResource(TABLE_CSS_FILE_NAME).toString());
            stage.setScene(scene);
            stage.setTitle(STOP_WATCH);
            stage.show();
        } catch (Exception e) {
            logger.error("Failed to knockout", e);
        }
    }
}

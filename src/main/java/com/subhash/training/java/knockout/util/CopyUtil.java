package com.subhash.training.java.knockout.util;

import com.subhash.training.java.knockout.elements.TableViewExt;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import org.apache.commons.lang3.StringUtils;

public class CopyUtil {
    public static String copyAndGetContent() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        String data = StringUtils.join(TableViewExt.getTableViewExt().getTableView().getItems(), "\n");
        content.putString(data);
        clipboard.setContent(content);
        return data;
    }
}

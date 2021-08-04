package com.subhash.training.java.knockout;

import com.subhash.training.java.knockout.util.ConfigurationUtil;
import com.subhash.training.java.knockout.util.CopyUtil;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.subhash.training.java.knockout.util.Constants.LOG_FILE;

public class App extends Application {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PropertyConfigurator.configure(getClass().getResource(LOG_FILE));
        logger.info("Knockout STARTED");
        Knockout knockout = new Knockout(stage);
        knockout.knockout();
    }

    @Override
    public void stop() {
        ConfigurationUtil.getConfigurationUtil().removeEmptyLIne();
        String data = CopyUtil.copyAndGetContent();
        logger.info("The final result is \n[\n{} \n]", data);
        logger.info("Knockout STOPPED");
    }
}

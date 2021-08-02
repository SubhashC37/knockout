package com.subhash.training.java.knockout.util;

import com.subhash.training.java.knockout.Knockout;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.subhash.training.java.knockout.util.Constants.CONFIG_FILE_NAME;
import static com.subhash.training.java.knockout.util.Constants.EQUAL_TO;
import static com.subhash.training.java.knockout.util.Constants.NEW_LINE;

public class ConfigurationUtil {
    private static Logger logger = LoggerFactory.getLogger(Knockout.class);
    private Configuration config;
    private static ConfigurationUtil INSTANCE;
    private File file;

    private ConfigurationUtil(final String fileName) {
        Configurations configs = new Configurations();
        try {
            file = new File(fileName);
            config = configs.properties(file);
        } catch (ConfigurationException e) {
            logger.error("Failed to initialize config util", e);
        }
    }

    public List<Object> getList(final String name) {
        return config.getList(name);
    }

    public void addConfigData(final String key, final String value) {
        config.addProperty(key, value);
        addToConfigFile(key + EQUAL_TO + value);
    }

    public void removeConfigData(final String key, final String value) {
        String line = key + EQUAL_TO + value;
        config.clearProperty(line);
        removeFromConfigFile(line);
    }

    public static ConfigurationUtil getConfigurationUtil() {
        if (INSTANCE == null) INSTANCE = new ConfigurationUtil(CONFIG_FILE_NAME);
        return INSTANCE;
    }

    public void removeEmptyLIne() {
        try {
            List<String> lines = FileUtils.readLines(file);
            Iterator<String> i = lines.iterator();
            while (i.hasNext()) {
                String line = i.next();
                if (line.trim().isEmpty())
                    i.remove();
            }

            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToConfigFile(final String line) {
        try {
            FileUtils.writeStringToFile(file, NEW_LINE + line, true);
        } catch (IOException e) {
            logger.error("Failed to add the configuration with line: {} ", line, e);
        }
    }

    private void removeFromConfigFile(final String line) {
        try {
            List<String> lines = FileUtils.readLines(file);
            List<String> updatedLines = lines.stream().filter(s -> !s.contains(line)).collect(Collectors.toList());
            FileUtils.writeLines(file, updatedLines, false);
        } catch (IOException e) {
            logger.error("Failed to remove the configuration with line: {}", line, e);
        }
    }
}

package com.epam.lab.utils;

import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {
    private final static Logger LOG = Logger.getLogger(EnvProperties.class);
    private Properties properties;

    public EnvProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/main/resources/data.properties")));
        } catch (IOException e) {
            LOG.error("No property file");
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        LOG.info("Get url from property file");
        return properties.getProperty("url");
    }
}





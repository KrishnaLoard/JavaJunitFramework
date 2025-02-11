package com.krishnasJUnit.ConfigHelper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnasJUnit.ConfigDAO.EnvironmentMapping;
import com.krishnasJUnit.ConfigDAO.RequestPathClass;
import com.krishnasJUnit.LoggerHelper.LoggerClass;
import java.io.File;

public class ConfigurationHelper {

    public static EnvironmentMapping getConfiguration() {
        EnvironmentMapping environmentMapping = new EnvironmentMapping();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoggerClass.logger.info("PRE STEP --> Starting to Load Environment Config File");
            JsonNode rootNode = objectMapper.readTree(new File(System.getProperty("user.dir") + "/TestSettings.json"));
            LoggerClass.logger.info("PRE STEP --> Starting to Load Environment Config File --> PASS");

            LoggerClass.logger.info(LoggerClass.IMPMarker, "Loading Configuration Environment");
            environmentMapping = objectMapper.readValue(rootNode.path("selenium").toPrettyString(), EnvironmentMapping.class);
            environmentMapping.setRequestPathClass(objectMapper.readValue(rootNode.path("selenium").path("RequestPath").toPrettyString(), RequestPathClass.class));
            LoggerClass.logger.info(LoggerClass.IMPMarker, "Loading Configuration Environment --> PASS");

            return environmentMapping;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

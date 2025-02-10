package com.krishnasJUnit.basePackage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnasJUnit.ConfigDAO.EnvironmentMapping;
import com.krishnasJUnit.LoggerHelper.LoggerClass;
import com.krishnasJUnit.VariableHelper.ConfigurationEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BaseTestClass {
    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    @BeforeEach
    public void PreRunMethod() {
        System.out.print("Pre-Test Case Starting Method");
    }

    public BaseTestClass() {
        try {
            //loggingClass = new LoggingClass();
            ObjectMapper objectMapper = new ObjectMapper();
            LoggerClass.logger.info("PRE STEP --> Starting to Load Environment Config File");
            JsonNode rootNode = objectMapper.readTree(new File(System.getProperty("user.dir") + "/TestSettings.json"));
            LoggerClass.logger.info("PRE STEP --> Starting to Load Environment Config File --> PASS");

            LoggerClass.logger.info(LoggerClass.IMPMarker, "Loading Configuration Environment");
            ConfigurationEnv.environmentMapping = objectMapper.readValue(rootNode.path("selenium").toPrettyString(), EnvironmentMapping.class);
            //System.out.print("Settings Json File --> " + ConfigurationEnv.environmentMapping.toString());
            LoggerClass.logger.info(LoggerClass.IMPMarker, "Loading Configuration Environment --> PASS");

            LoggerClass.logger.warn("Need to Check here Browser Type Please make sure Set correctly");
            if (ConfigurationEnv.environmentMapping.getBrowser().equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                LoggerClass.logger.warn("Need to Check here {} Created correctly --> PASS", ConfigurationEnv.environmentMapping.getBrowser());
            }
            webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigurationEnv.environmentMapping.getImplicitWait()));
            webDriver.get(ConfigurationEnv.environmentMapping.getBaseUrl());
            webDriver.manage().window().maximize();
            Thread.sleep(5000);

        } catch (Exception e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
    }

    @Test
    public void SampleTest() {
        System.out.println("Testing Test Case Sample--> Should Start WebDriver and Kill it");
    }

    @AfterEach
    public void AfterTestMethod() {
        System.out.print("After Each Test Method");
        System.out.println("Killing Driver After Test --> ");
        webDriver.quit();
    }
}

package com.krishnasJUnit.basePackage;

import com.krishnasJUnit.ConfigHelper.ConfigurationHelper;
import com.krishnasJUnit.LoggerHelper.LoggerClass;
import com.krishnasJUnit.VariableHelper.ConfigurationEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTestCase {
    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    public BaseTestCase() {
        try {
            ConfigurationEnv.environmentMapping = ConfigurationHelper.getConfiguration();
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

    @BeforeEach
    public void PreRunMethod() {
        System.out.print("Pre-Test Case Starting Method");
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

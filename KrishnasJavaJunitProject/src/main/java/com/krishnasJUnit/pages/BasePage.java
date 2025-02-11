package com.krishnasJUnit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By txtBoxWithId(String txtId) {
        return By.xpath(String.format("//input[@id='%s']", txtId));
    }
    public By txtBoxWithName(String txtName){
        return By.xpath(String.format("//input[@name='%s']", txtName));
    }
}

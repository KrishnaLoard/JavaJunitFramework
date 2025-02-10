package com.krishnasJUnit.ConfigDAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.krishnasJUnit.VariableHelper.ChromeOptions;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentMapping {
    private String browser;
    private String baseUrl;
    private int implicitWait;
    private int pageLoad;
    private int explicitWait;
    private ChromeOptions chromeOptions;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(int implicitWait) {
        this.implicitWait = implicitWait;
    }

    public int getPageLoad() {
        return pageLoad;
    }

    public void setPageLoad(int pageLoad) {
        this.pageLoad = pageLoad;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public void setExplicitWait(int explicitWait) {
        this.explicitWait = explicitWait;
    }

    public ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public void setChromeOptions(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }
}

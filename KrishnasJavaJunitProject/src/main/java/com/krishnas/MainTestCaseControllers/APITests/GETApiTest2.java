package com.krishnas.MainTestCaseControllers.APITests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnasJUnit.ConfigDAO.TickersResponse;
import com.krishnasJUnit.LoggerHelper.LoggerClass;
import com.krishnasJUnit.VariableHelper.ConfigurationEnv;
import com.krishnasJUnit.basePackage.RestAPIClient;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GETApiTest2 extends RestAPIClient {

    public GETApiTest2() {
        super();
    }

    @Test
    public void GETApiTest2MethodTEST() throws Exception {
        LoggerClass.logger.info("STEP: 1 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getAPIServerUrl());
        Assert.assertNotNull(ConfigurationEnv.environmentMapping.getAPIServerUrl());

        LoggerClass.logger.info("STEP: 2 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase1());
        Assert.assertNotNull(ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase1());

        LoggerClass.logger.info("STEP: 3 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getAPIServerUrl2());
        Assert.assertNotNull(ConfigurationEnv.environmentMapping.getAPIServerUrl2());

        LoggerClass.logger.info("STEP: 4 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase3());
        Assert.assertNotNull(ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase3());

        LoggerClass.logger.info("STEP: 5 --> Starting Building Client for API Test");
        String BaseUrl = String.format
                (ConfigurationEnv.environmentMapping.getAPIServerUrl2() + ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase3() + "?access_key=%s", ConfigurationEnv.environmentMapping.getAccessKeys());
        HttpRequest getRequest = getHTTPGETRequest(ConfigurationEnv.environmentMapping.getAPIServerUrl2() + ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase3()
                + "?access_key=" + ConfigurationEnv.environmentMapping.getAccessKeys());
        HttpResponse<String> responseString = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        LoggerClass.logger.info("Print The Response String Body --> {}", responseString.body());

        LoggerClass.logger.info("STEP: 6 --> Convert String Response into the Class Object");
        TickersResponse tickersResponse = new ObjectMapper().readValue(responseString.body(), TickersResponse.class);

        LoggerClass.logger.info("Check Response Status Code is 200");
        Assert.assertEquals("Response Code does not indicate 200 OK", 200, responseString.statusCode());

        LoggerClass.logger.info("STEP: 7 --> Checking Stock Exchange is not Zero Count");
        Assert.assertTrue("Count is 0",tickersResponse.companies.length > 0);


    }
}

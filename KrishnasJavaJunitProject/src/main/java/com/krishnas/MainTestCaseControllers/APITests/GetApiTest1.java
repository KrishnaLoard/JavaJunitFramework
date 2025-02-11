package com.krishnas.MainTestCaseControllers.APITests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnasJUnit.LoggerHelper.LoggerClass;
import com.krishnasJUnit.ResponseDAO.PostResponse;
import com.krishnasJUnit.VariableHelper.ConfigurationEnv;
import com.krishnasJUnit.basePackage.RestAPIClient;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetApiTest1 extends RestAPIClient {
    public GetApiTest1() {
        super();
    }

    @Test
    public void APITestCaseGET1() {
        try {
            LoggerClass.logger.info("STEP: 1 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getAPIServerUrl());
            LoggerClass.logger.info("STEP: 2 --> Getting the Server EndPoint --> {}", ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase1());

            LoggerClass.logger.info("STEP: 3 --> Preparing Client for Rest Test --> {}", ConfigurationEnv.environmentMapping.getAPIServerUrl());
            HttpRequest getRequest = getHTTPGETRequest(ConfigurationEnv.environmentMapping.getAPIServerUrl() + ConfigurationEnv.environmentMapping.getRequestPathClass().getAPIGetURLCase1());
            HttpResponse<String> responseString = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            LoggerClass.logger.fatal("Response String --> {}", responseString);
            LoggerClass.logger.warn("Get Response Body --> {}", responseString.body());

            //Convert The Object
            PostResponse postResponse = new ObjectMapper().readValue(responseString.body(), PostResponse.class);

            LoggerClass.logger.info("STEP: 4 --> Validating UserId--> {}", postResponse.getUserId());
            Assert.assertFalse("User Id Should not be Zero", postResponse.getUserId() == 0);

            LoggerClass.logger.info("STEP: 5 --> Validating Id--> {}", postResponse.getId());
            Assert.assertFalse("Id Should not be Zero", postResponse.getId() == 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

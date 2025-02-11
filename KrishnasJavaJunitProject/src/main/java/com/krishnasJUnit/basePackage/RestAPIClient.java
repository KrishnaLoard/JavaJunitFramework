package com.krishnasJUnit.basePackage;

import com.krishnasJUnit.ConfigHelper.ConfigurationHelper;
import com.krishnasJUnit.VariableHelper.ConfigurationEnv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class RestAPIClient {

    public static HttpClient httpClient = HttpClient.newHttpClient();

    public RestAPIClient() {
        ConfigurationEnv.environmentMapping = ConfigurationHelper.getConfiguration();
    }

    public static HttpRequest getHTTPPOSTRequest(String baseURL, String jsonBody) {
        HttpRequest httpPOSTRequest = HttpRequest.newBuilder().uri(URI.create(baseURL)).
                header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();
        return httpPOSTRequest;
    }

    public static HttpRequest getHTTPGETRequest(String baseURL) {
        HttpRequest httpGETRequest = HttpRequest.newBuilder().uri(URI.create(baseURL)).
                header("Content-Type", "application/json").GET().build();
        return httpGETRequest;
    }
}

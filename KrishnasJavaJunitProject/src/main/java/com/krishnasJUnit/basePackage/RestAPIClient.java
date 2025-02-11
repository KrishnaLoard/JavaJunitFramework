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
        return HttpRequest.newBuilder().uri(URI.create(baseURL)).
                header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();
    }

    public static HttpRequest getHTTPGETRequest(String baseURL) {
        return HttpRequest.newBuilder().uri(URI.create(baseURL)).
                header("Content-Type", "application/json").GET().build();
    }
}

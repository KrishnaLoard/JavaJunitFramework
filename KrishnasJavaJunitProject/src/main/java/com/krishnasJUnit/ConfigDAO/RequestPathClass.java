package com.krishnasJUnit.ConfigDAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPathClass {

    @JsonProperty("APIGetURLCase1")
    private String APIGetURLCase1;

    @JsonProperty("APIGetURLCase2")
    private String APIGetURLCase2;

    @JsonProperty("APIGetURLCase3")
    private String APIGetURLCase3;

    public String getAPIGetURLCase3() {
        return APIGetURLCase3;
    }

    public void setAPIGetURLCase3(String APIGetURLCase3) {
        this.APIGetURLCase3 = APIGetURLCase3;
    }

    public String getAPIGetURLCase1() {
        return APIGetURLCase1;
    }

    public void setAPIGetURLCase1(String APIGetURLCase1) {
        this.APIGetURLCase1 = APIGetURLCase1;
    }

    public String getAPIGetURLCase2() {
        return APIGetURLCase2;
    }

    public void setAPIGetURLCase2(String APIGetURLCase2) {
        this.APIGetURLCase2 = APIGetURLCase2;
    }
}

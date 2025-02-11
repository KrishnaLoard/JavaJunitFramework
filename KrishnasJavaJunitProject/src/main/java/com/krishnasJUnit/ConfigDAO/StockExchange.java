package com.krishnasJUnit.ConfigDAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockExchange {
    private String name;
    private String acronym;
    private String mic;
    private String country;

    @JsonProperty("country_code")
    private String countryCode;
    private String city;
    private String website;

    public StockExchange() {

    }

    public StockExchange(String name, String acronym, String mic, String country, String countryCode, String city, String website) {
        this.name = name;
        this.acronym = acronym;
        this.mic = mic;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

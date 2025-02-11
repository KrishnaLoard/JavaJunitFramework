package com.krishnasJUnit.ConfigDAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TickersResponse {
    @JsonProperty("pagination")
    public Pagination pagination;

    @JsonProperty("data")
    public Company[] companies;

    public TickersResponse() {

    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }
}

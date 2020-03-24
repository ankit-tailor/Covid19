package com.example.covid19;

public class Covid {
    private String country;
    private String newConfirmed;
    private String totalConfirmed;
    private String newdDeaths;
    private String totalDeaths;
    private String newRecovered;
    private String totalRecovered;

    public Covid(Covid c) {

    }
    public Covid() {

    }
    public Covid(String country, String newConfirmed, String totalConfirmed, String newdDeaths, String totalDeaths, String newRecovered, String totalRecovered) {
        this.country = country;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newdDeaths = newdDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setNewConfirmed(String newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public void setNewdDeaths(String newdDeaths) {
        this.newdDeaths = newdDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getCountry() {
        return country;
    }

    public String getNewConfirmed() {
        return newConfirmed;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public String getNewdDeaths() {
        return newdDeaths;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }
}

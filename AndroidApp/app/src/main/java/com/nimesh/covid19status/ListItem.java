package com.nimesh.covid19status;

public class ListItem {
    private String lastUpdated;
    private String locTotalCases;
    private String locNewCases;
    private String locHospitalized;
    private String locDeaths;
    private String locRecovered;
   /* private String gloTotalCases;
    private String gloNewCases;
    private String gloDeaths;
    private String gloRecovered;*/

    /*public ListItem(String lastUpdated, String locTotalCases, String locNewCases, String locHospitalized, String locDeaths, String locRecovered, String gloTotalCases, String gloNewCases, String gloDeaths, String gloRecovered) {
        this.lastUpdated = lastUpdated;
        this.locTotalCases = locTotalCases;
        this.locNewCases = locNewCases;
        this.locHospitalized = locHospitalized;
        this.locDeaths = locDeaths;
        this.locRecovered = locRecovered;
        this.gloTotalCases = gloTotalCases;
        this.gloNewCases = gloNewCases;
        this.gloDeaths = gloDeaths;
        this.gloRecovered = gloRecovered;
    }*/

    public ListItem(String lastUpdated, String locTotalCases, String locNewCases, String locHospitalized, String locDeaths, String locRecovered) {
        this.lastUpdated = lastUpdated;
        this.locTotalCases = locTotalCases;
        this.locNewCases = locNewCases;
        this.locHospitalized = locHospitalized;
        this.locDeaths = locDeaths;
        this.locRecovered = locRecovered;
    }

    /*
    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getLocTotalCases() {
        return locTotalCases;
    }

    public String getLocNewCases() {
        return locNewCases;
    }

    public String getLocHospitalized() {
        return locHospitalized;
    }

    public String getLocDeaths() {
        return locDeaths;
    }

    public String getLocRecovered() {
        return locRecovered;
    }

    public String getGloTotalCases() {
        return gloTotalCases;
    }

    public String getGloNewCases() {
        return gloNewCases;
    }

    public String getGloDeaths() {
        return gloDeaths;
    }

    public String getGloRecovered() {
        return gloRecovered;
    }*/

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getLocTotalCases() {
        return locTotalCases;
    }

    public String getLocNewCases() {
        return locNewCases;
    }

    public String getLocHospitalized() {
        return locHospitalized;
    }

    public String getLocDeaths() {
        return locDeaths;
    }

    public String getLocRecovered() {
        return locRecovered;
    }
}

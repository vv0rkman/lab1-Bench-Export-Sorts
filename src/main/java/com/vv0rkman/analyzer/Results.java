package com.vv0rkman.analyzer;

import java.util.HashMap;

public class Results {
    private String fillerName;
    private HashMap<String, Long> results = new HashMap<>();

    public HashMap<String, Long> getResults() {
        return this.results;
    }

    public void setResults(HashMap<String, Long> results) {
        this.results = results;
    }

    public String getFillerName() {
        return fillerName;
    }

    public void setFillerName(String fillerName) {
        this.fillerName = fillerName;
    }
}

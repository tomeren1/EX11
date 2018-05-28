package com.example.magshimim.ex11;

public class Country {
    String name;
    String flag;
    String details;
    String anthem;
    String shorty;

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public String getDetails() {
        return details;
    }

    public String getAnthem() {
        return anthem;
    }

    public String getShorty() {
        return shorty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setAnthem(String anthem) {
        this.anthem = anthem;
    }

    public void setShorty(String shorty) {
        this.shorty = shorty;
    }

    @Override
    public String toString() {
        return this.name;
    }
}


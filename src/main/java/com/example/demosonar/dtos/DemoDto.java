package com.example.demosonar.dtos;

public class DemoDto {

    public int version;
    private String name;

    public DemoDto(){

    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.rubenlg94.publicservice.constants;

public enum Apis {

    SUBSCRIPTION_SERVICE("subscription-service");

    private String name;

    Apis(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

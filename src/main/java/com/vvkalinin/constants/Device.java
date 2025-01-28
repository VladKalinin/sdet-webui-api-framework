package com.vvkalinin.constants;


public enum Device {

    DESKTOP(),
    MOBILE();

    Device() {

    }

    public String getName() {
        return name().toLowerCase();
    }

}

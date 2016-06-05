package com.nokia.oss.primporter.utils;

/**
 * Created by ruizhao on 2016/5/20.
 */
public enum Status {

    CLOSED("CLOSED"), NEW("NEW"), FCRT("FCRT"), INVESTIGATE("INVESTIGATE");
    private final String value;
    Status( String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}

package com.nokia.oss.primporter.utils;

/**
 * Created by ruizhao on 2016/5/20.
 */
public enum Severity {
    A("A"), B("B"), C("C");
    private final String value;
    Severity(String value) {
        this.value=value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}

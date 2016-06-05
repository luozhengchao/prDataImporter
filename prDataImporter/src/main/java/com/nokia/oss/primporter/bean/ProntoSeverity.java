package com.nokia.oss.primporter.bean;

import com.nokia.oss.primporter.orm.annotation.Id;
import com.nokia.oss.primporter.orm.annotation.TableProperty;

import java.io.Serializable;

/**
 * Created by ruizhao on 2016/5/20.
 */
@TableProperty("ProntoSeverity")
public class ProntoSeverity implements Serializable {

    @Id
    @TableProperty("id")
    private Integer id;
    @TableProperty("severity")
    private String severity;
    @TableProperty("description")
    private String description;

    public ProntoSeverity() {
    }

    public ProntoSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", severity='" + severity + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

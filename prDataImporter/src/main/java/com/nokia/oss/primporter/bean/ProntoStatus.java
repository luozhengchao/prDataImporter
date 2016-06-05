package com.nokia.oss.primporter.bean;

import com.nokia.oss.primporter.orm.annotation.Id;
import com.nokia.oss.primporter.orm.annotation.TableProperty;

import java.io.Serializable;

/**
 * Created by ruizhao on 2016/5/20.
 */
@TableProperty("ProntoStatus")
public class ProntoStatus implements Serializable {
    @Id
    @TableProperty("id")
    private Integer id;
    @TableProperty("prontoStatus")
    private String prontoStatus;
    @TableProperty("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProntoStatus() {
        return prontoStatus;
    }

    public void setProntoStatus(String prontoStatus) {
        this.prontoStatus = prontoStatus;
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
                ", prontoStatus='" + prontoStatus + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

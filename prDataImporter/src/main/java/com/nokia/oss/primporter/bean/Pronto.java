package com.nokia.oss.primporter.bean;

import com.nokia.oss.primporter.orm.annotation.TableProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.crypto.SecretKey;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ruizhao on 2016/5/20.
 */
@TableProperty("Pronto")
public class Pronto implements Serializable {

    @TableProperty("id")
    private String id;
    @TableProperty("title")
    private String title;
    @TableProperty("author")
    private String author;
    @TableProperty("prontoGroup")
    private String prontoGroup;
    @TableProperty("openTime")
    private String openTime;
    @TableProperty("closeTime")
    private String closeTime;
    @TableProperty("description")
    private String description;
    @TableProperty("prontoSeverity_id")
    private int prontoSeverity_id;
    @TableProperty("prontoStatus_id")
    private int prontoStatus_id;


    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProntoSeverity_id() {
        return prontoSeverity_id;
    }

    public void setProntoSeverity_id(int prontoSeverity_id) {
        this.prontoSeverity_id = prontoSeverity_id;
    }

    public int getProntoStatus_id() {
        return prontoStatus_id;
    }

    public void setProntoStatus_id(int prontoStatus_id) {
        this.prontoStatus_id = prontoStatus_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProntoGroup() {
        return prontoGroup;
    }

    public void setProntoGroup(String prontoGroup) {
        this.prontoGroup = prontoGroup;
    }

}

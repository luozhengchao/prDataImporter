package com.nokia.oss.primporter.bean;

import com.nokia.oss.primporter.orm.annotation.TableProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ruizhao on 2016/5/20.
 */

@TableProperty("domain")
public class Domain implements Serializable{
    @TableProperty("id")
    private Integer id;
    @TableProperty("name")
    private String name;
    @TableProperty("description")
    private String description;
    @TableProperty("owner")
    private String owner;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

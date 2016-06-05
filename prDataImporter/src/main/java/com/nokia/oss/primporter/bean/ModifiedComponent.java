package com.nokia.oss.primporter.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruizhao on 2016/5/20.
 */
@Entity
public class ModifiedComponent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String version;
    private String testStatus;
    private String responsiblePerson;
    @ManyToOne(fetch = FetchType.LAZY, cascade={})
    private ProntoCorrection prontoCorrection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public ProntoCorrection getProntoCorrection() {
        return prontoCorrection;
    }

    public void setProntoCorrection(ProntoCorrection prontoCorrection) {
        this.prontoCorrection = prontoCorrection;
    }

}

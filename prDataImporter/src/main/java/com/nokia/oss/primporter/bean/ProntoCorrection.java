package com.nokia.oss.primporter.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ruizhao on 2016/5/20.
 */
@Entity
public class ProntoCorrection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String correctionRelease;
    private String correctionStatus;
    private String testGroup;
    private String implementGroup;
    private String responsiblePerson;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE})
    private List<ModifiedComponent> modifiedComponents;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {})
    private Pronto pronto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelease() {
        return this.correctionRelease;
    }

    public void setRelease(String release) {
        this.correctionRelease = release;
    }

    public String getCorrectionStatus() {
        return correctionStatus;
    }

    public void setCorrectionStatus(String correctionStatus) {
        this.correctionStatus = correctionStatus;
    }

    public String getTestGroup() {
        return testGroup;
    }

    public void setTestGroup(String testGroup) {
        this.testGroup = testGroup;
    }

    public String getImplementGroup() {
        return implementGroup;
    }

    public void setImplementGroup(String implementGroup) {
        this.implementGroup = implementGroup;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public List<ModifiedComponent> getModifiedComponents() {
        return modifiedComponents;
    }

    public void setModifiedComponents(List<ModifiedComponent> modifiedComponents) {
        this.modifiedComponents = modifiedComponents;
    }

    public Pronto getPronto() {
        return pronto;
    }

    public void setPronto(Pronto pronto) {
        this.pronto = pronto;
    }
}

package com.nokia.oss.primporter.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ruizhao on 2016/5/20.
 */
@Entity
public class HistoricalStatics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String weekName;
    private Integer prontoNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodEnd;
    private String unit;
    @ManyToOne(fetch = FetchType.LAZY,cascade={})
    @JoinColumn(name = "Id")
    private StaticsRule staticsRule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public StaticsRule getStaticsRule() {
        return staticsRule;
    }

    public void setStaticsRule(StaticsRule staticsRule) {
        this.staticsRule = staticsRule;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public Integer getProntoNumber() {
        return prontoNumber;
    }

    public void setProntoNumber(Integer prontoNumber) {
        this.prontoNumber = prontoNumber;
    }

}

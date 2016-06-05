package com.nokia.oss.primporter.utils;

import com.nokia.oss.primporter.bean.Pronto;
import com.nokia.oss.primporter.bean.ProntoSeverity;
import com.nokia.oss.primporter.bean.ProntoStatus;
import com.nokia.oss.primporter.exception.ImporterException;
import com.nokia.oss.primporter.orm.jdbc.implementation.MySQLBaseDaoImpl;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/**
 * Created by ruizhao on 2016/5/20.
 */

public class ProntoCSVDTO {
    private String ProblemID;               //Pronto id
    private String AuthorGroup;             //Pronto prontoGroup
    private String Title;                   //Pronto title
    private Severity Severity;              //ProntoSeverity  severity
    private Status State;                   //ProntoStatus  prontoStatus
    private String CorrectionDeadline;
    private String ReportedDate;            //Pronto openTime
    private String StateLastChanged;
    private String GroupInCharge;
    private String ImplementationGroup;
    private String ImplementationResponsiblePerson;  //Pronto author
    private String ProblemType;
    private String RootCause;
    private String ShouldHaveBeenFoundIn;
    private String FaultAnalysisRelease;
    private String TargetRelease;
    private String TargetBuild;
    private String StateChangedToNew;
    private String StateChangedtoInvestigating;
    private String StateChangedtoCorrectionnotneeded;
    private String StateChangedtoCorrectionPlanReady;
    private String StateChangedtoCorrectionPlanSent;
    private String StateChangedtoFinalResponseSent;
    private String StateChangedtoFirstCorrectionReadyForTesting;
    private String StateChangedtoClosed;                //Pronto closeTime
    private String StateChangedtoReopened;
    private String ChangeNotes;
    private String Description;                        //Pronto  description
    private String ModifiedComponents;
    private String Release;



    public ProntoCSVDTO()  {
    }
    public ProntoSeverity getSeverity(String Severity){
        ProntoSeverity s = new ProntoSeverity();
        //s.setSeverity(Severity);
        if("A - Critical".equals(Severity)){
            s.setDescription("A");
        }
        if("B - Major".equals(Severity)){
            s.setDescription("B");
        }
        if("C - Minor".equals(Severity)){
            s.setDescription("C");
        }
        return s;
    }

    public ProntoStatus getStatus(String status){
        ProntoStatus ps = new ProntoStatus();
        //ps.setProntoStatus(status);
        if("New".equals(status)){
            ps.setDescription("New");
        }
        if("Closed".equals(status)){
            ps.setDescription("ClOSED");
        }
        if("First Correction Ready For Testing".equals(status)){
            ps.setDescription("FCRT");
        }
        if("Investigate".equals(status)){
            ps.setDescription("INVESTIGATING");
        }
        if("Correction Not Needed".equals(status))
            ps.setDescription("CNN");
           return ps;
    }

    MySQLBaseDaoImpl mySQLBaseDaoImpl = new MySQLBaseDaoImpl(new File("src//main//resource//Properties.properties"));
    public Pronto transfer2Pronto(List<String> line,Map<String,Integer> map) throws ImporterException {

        Pronto pronto = new Pronto();
        pronto.setId(line.get(map.get("Problem ID")));
        String authorGroup = line.get(map.get("Author Group"));
        if(authorGroup.contains("NEVE")){
            authorGroup="NEVE";
        }else if(authorGroup.contains("PET")){
            authorGroup="PET";
        }else if(authorGroup.contains("IUM")){
            authorGroup="IUM";
        }else if(authorGroup.contains("SyVe")){
            authorGroup="SyVe";
        }else if(authorGroup.contains("NN6ADAP04")){
            authorGroup="NN6ADAP04";
        } else{
            authorGroup="Others";
        }
        pronto.setAuthor(authorGroup);
        String title = line.get(map.get("Title"));
        Pattern pat = Pattern.compile("\'");
        Matcher mat1 = pat.matcher(title);
        if (mat1.find()) {
            title=title.replace(mat1.group(), "\''");
        }
        pronto.setTitle(title);
        pronto.setProntoGroup(line.get(map.get("Group in Charge")));

        String description=line.get(map.get("Description"));
        Matcher mat2 = pat.matcher(description);
        if (mat2.find()) {
            description=title.replace(mat2.group(), "\''");
        }
        pronto.setDescription(description);
        String openTime = line.get(map.get("Reported Date"));
        if(!openTime.equals("< empty >")){
            String [] openTimeArr = openTime.split("\\.");
            StringBuffer openTimeBuffer = new StringBuffer();
            openTimeBuffer.append(openTimeArr[2]).append(".").append(openTimeArr[1]).append(".").append(openTimeArr[0]);
            openTime = openTimeBuffer.toString();
        }

        pronto.setOpenTime(openTime);
        String closeTime=line.get(map.get("State Changed to Closed"));
        if(!closeTime.equals("< empty >")) {
            String[] closeTimeArr = closeTime.split("\\.");
            StringBuffer closeTimeBuffer = new StringBuffer();
            closeTimeBuffer.append(closeTimeArr[2]).append(".").append(closeTimeArr[1]).append(".").append(closeTimeArr[0]);
            closeTime = closeTimeBuffer.toString();
        }
        pronto.setCloseTime(closeTime);
        ProntoSeverity prontoSeverity = getSeverity(line.get(map.get("Severity")));
        ProntoStatus prontoStatus = getStatus(line.get(map.get("State")));
        pronto.setProntoStatus_id(mySQLBaseDaoImpl.queryId(prontoStatus));
        pronto.setProntoSeverity_id(mySQLBaseDaoImpl.queryId(prontoSeverity));
        return pronto;
    }


}

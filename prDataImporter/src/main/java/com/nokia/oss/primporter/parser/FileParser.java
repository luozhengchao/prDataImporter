package com.nokia.oss.primporter.parser;

import com.nokia.oss.primporter.bean.Domain;
import com.nokia.oss.primporter.bean.Pronto;
import com.nokia.oss.primporter.bean.ProntoSeverity;
import com.nokia.oss.primporter.bean.ProntoStatus;
import com.nokia.oss.primporter.exception.ImporterException;
import com.nokia.oss.primporter.orm.jdbc.implementation.MySQLBaseDaoImpl;
import com.nokia.oss.primporter.utils.CsvFileParser;
import com.nokia.oss.primporter.utils.ProntoCSVDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * User: j59chen
 * Date: 2016/5/18
 * Time: 16:09
 * TO-DO: class Description, need to be modified
 */
public class FileParser {
    CsvFileParser parser;
    List<String> labelList;
    Map<String,Integer> lableMap = new HashMap<String, Integer>();
    Map<Integer, List> valueMap;

    MySQLBaseDaoImpl mySQLBaseDaoImpl = new MySQLBaseDaoImpl(new File("src//main//resource//Properties.properties"));
    ProntoCSVDTO prontoCSVDTO = new ProntoCSVDTO();

    public FileParser(File csvFile) throws ImporterException {
        parser = new CsvFileParser();
        parser.initialnize(csvFile);
    }
    public void parseCSV() throws ImporterException, IOException {
        List<String> tempList = parser.getCurRow();
        Map<String,Object>objectMap ;
        while (tempList.size() < 2){
            tempList = parser.getCurRow();
        }
        labelList = tempList;
        for(int i=0;i<labelList.size();i++){
            lableMap.put(labelList.get(i),i);
        }
        valueMap = parser.getAllValues();
        for(int i = 0;i<valueMap.size();i++){
            Pronto pronto = prontoCSVDTO.transfer2Pronto(valueMap.get(i),lableMap);
            mySQLBaseDaoImpl.insert(pronto);
        }
        parser.close();
    }
}

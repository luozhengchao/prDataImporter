package com.nokia.oss.primporter.utils;

/**
 * Created by ruizhao on 2016/5/17.
 */

import com.Ostermiller.util.ExcelCSVParser;
import com.Ostermiller.util.LabeledCSVParser;
import com.nokia.oss.primporter.exception.ImporterException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFileParser {
    Logger LOG = Logger.getLogger(CsvFileParser.class);
    private LabeledCSVParser csvParser;


    public void initialnize(File csvFile) throws ImporterException {
        LOG.debug("CsvFileParser initialize begin.");
        try {
            FileInputStream in = new FileInputStream(csvFile);
            this.csvParser = new LabeledCSVParser(new ExcelCSVParser(in));
        } catch (FileNotFoundException e) {
            throw new ImporterException("Can not find CSV file[" + csvFile.getAbsolutePath() + "]. Error: " + e.getMessage());
        } catch (IOException e) {
            throw new ImporterException("Import CSV file[" + csvFile.getAbsolutePath() + "] failed. Error: " + e.getMessage());
        }
        LOG.debug("CsvFileParser initialize completed.");
    }

    public List<String> getCurRow() throws ImporterException {
        List<String> valueList;
        try {
            String[] valueArray = this.csvParser.getLine();
            valueList = Arrays.asList(valueArray);
        } catch (IOException e) {
            throw new ImporterException("Get CSV value failed. Error: " + e.getMessage());
        }
        return valueList;
    }


    public List<String> getLabels() throws ImporterException {
        List<String> labelList;
        try {
            String[] labelArray = this.csvParser.getLabels();
            labelList = Arrays.asList(labelArray);
        } catch (IOException e) {
            throw new ImporterException("Get CSV labels failed. Error: " + e.getMessage());
        }
        return labelList;
    }

    public Map<Integer, List> getAllValues() throws ImporterException {
        Map<Integer, List> valueMaps = new HashMap<Integer, List>();
        try {
            String[][] allValuesArrays = this.csvParser.getAllValues();
            for (int i = 0; i < allValuesArrays.length; i++){
                valueMaps.put(i, Arrays.asList(allValuesArrays[i]));
            }
        } catch (IOException e) {
            throw new ImporterException("Get CSV value maps failed. Error: " + e.getMessage());
        }
        return valueMaps;
    }

    public void close() throws IOException {
        csvParser.close();
    }




}

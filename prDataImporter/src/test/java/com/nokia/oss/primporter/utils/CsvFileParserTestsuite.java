package com.nokia.oss.primporter.utils;


import com.nokia.oss.primporter.bean.Pronto;
import com.nokia.oss.primporter.bean.ProntoSeverity;
import com.nokia.oss.primporter.bean.ProntoStatus;
import com.nokia.oss.primporter.dao.BaseDao;
import com.nokia.oss.primporter.dao.ProntoDao;
import com.nokia.oss.primporter.utils.CsvFileParser;
import com.nokia.oss.primporter.utils.ProntoCSVDTO;
import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.File;

/**
 * User: j59chen
 * Date: 2016/5/18
 * Time: 11:21
 * TO-DO: class Description, need to be modified
 */
public class CsvFileParserTestsuite  {

    private CsvFileParser csvFileParser;
    private ProntoCSVDTO prontoCSVDTO = new ProntoCSVDTO();
    private Map<Integer, List> map;
    private Map<String, Integer> mapLable=new HashMap<String, Integer>();
    private List<String> list;
    File file = new File("D:\\Pronto_Statistics_2016_03_25_04_07_44.csv");

    @Before
    public void initialnize()throws Exception{
        csvFileParser = new CsvFileParser();
        csvFileParser.initialnize(file);
    }


    @Test
    public void testGetAllValues()throws Exception{

        List<String> listLable= csvFileParser.getCurRow();
        while(listLable.size()<2){
            listLable= csvFileParser.getCurRow();
        }
        for(int i = 0; i < listLable.size() ; i++){
            mapLable.put(listLable.get(i),i);
        }

        map=csvFileParser.getAllValues();
        //System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, List> entry : map.entrySet()) {
            list=entry.getValue();
            //Pronto pronto = (Pronto) prontoCSVDTO.transfer2Object(entry.getValue(), mapLable,i).get("pronto");
            //ProntoDao<Pronto> baseDao = new ProntoDao<Pronto>();
            //baseDao.insert(pronto);


            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
}

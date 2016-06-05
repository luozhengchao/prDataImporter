package com.nokia.oss.primporter.orm.jdbc.implementation;

import com.nokia.oss.primporter.exception.ImporterException;
import com.nokia.oss.primporter.orm.utils.AnnotationParser;
import com.nokia.oss.primporter.orm.utils.Invoker;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * User: j59chen
 * Date: 2016/5/24
 * Time: 23:06
 * TO-DO: class Description, need to be modified
 */
public class MySQLBaseDaoImpl extends BaseDaoImpl{

    public MySQLBaseDaoImpl(File file){
        super(file);
    }

    public void insert(Object entity) throws ImporterException {
        String tableName = AnnotationParser.parseTable(entity.getClass());
        Map<String, String> fieldMap = AnnotationParser.parseFields(entity.getClass());
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuffer sqlBuffer = new StringBuffer("insert into " + tableName +"( ");
        for (Field field:
             fields) {
            sqlBuffer.append(fieldMap.get(field.getName()) + ", ");
        }
        sqlBuffer.replace(sqlBuffer.length()-2, sqlBuffer.length()-1, ") values( '");
        for (Field field:
                fields) {
            if(Invoker.getAttributeValue(entity, StringUtils.capitalize(field.getName())).equals("< empty >")){
                sqlBuffer.replace(sqlBuffer.length()-1,sqlBuffer.length()," ");
                sqlBuffer.append("NUll, '");
            }
            else {
                sqlBuffer.append(Invoker.getAttributeValue(entity, StringUtils.capitalize(field.getName())) + "', '");
            }
        }
        sqlBuffer.replace(sqlBuffer.length()-3, sqlBuffer.length(), ") ");
       try {
           statement.execute(sqlBuffer.toString());
           //connection.close();
        } catch (SQLException e) {
            throw new ImporterException("SQL execution failed. Error: " + e.getMessage());
        }
    }

    public int queryId(Object entity) throws ImporterException{
        int id;
        String tableName = AnnotationParser.parseTable(entity.getClass());
        Map<String, String> fieldMap = AnnotationParser.parseFields(entity.getClass());
        String dbId = AnnotationParser.parseId(entity.getClass());
        StringBuffer sqlBuffer = new StringBuffer("select " + dbId + " from " + tableName +" where ");
        for (Map.Entry fieldEntry:
                fieldMap.entrySet()) {
            if(Invoker.getAttributeValue(entity, StringUtils.capitalize((String)fieldEntry.getKey())) != null){
                sqlBuffer.append( fieldEntry.getValue() + " = '" +
                        Invoker.getAttributeValue(entity, StringUtils.capitalize((String)fieldEntry.getKey())) + "' and ");
            }
        }
        sqlBuffer.delete(sqlBuffer.length() - 4, sqlBuffer.length());
        try {
            ResultSet rs = statement.executeQuery(sqlBuffer.toString());
            if(rs.next()){
                id = rs.getInt(1);
            }else{
                id=-1;
            }
        } catch (SQLException e) {
            throw new ImporterException("SQL execution failed. Error: " + e.getMessage());
        }
        return id;
    }


}

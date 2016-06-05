package com.nokia.oss.primporter.orm.utils;

import com.nokia.oss.primporter.orm.annotation.Id;
import com.nokia.oss.primporter.orm.annotation.TableProperty;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * User: j59chen
 * Date: 2016/5/24
 * Time: 22:57
 * TO-DO: class Description, need to be modified
 */
public class AnnotationParser {

    public static String parseTable(Class<?> clazz){
        TableProperty tableProperty = clazz.getAnnotation(TableProperty.class);
        return tableProperty.value();
    }

    public static Map<String, String> parseFields(Class<?> clazz){
        Map<String, String> fieldsMap = new HashMap<String, String>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:
             fields) {
            fieldsMap.put(field.getName(), field.getAnnotation(TableProperty.class).value());
        }
        return fieldsMap;
    }

    public static String parseId(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:
                fields) {
            if (field.getAnnotation(Id.class) != null){
                return field.getAnnotation(TableProperty.class).value();
            }
        }
        return null;
    }
}

package com.nokia.oss.primporter.orm.utils;

import com.nokia.oss.primporter.exception.ImporterException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: j59chen
 * Date: 2016/5/26
 * Time: 16:04
 * TO-DO: class Description, need to be modified
 */
public class Invoker {

    public static String getAttributeValue(Object entity, String fieldName) throws ImporterException{
        String valueString;
        try {
            Class clazz = entity.getClass();
            Method method = clazz.getMethod("get" + fieldName);
            if (method.invoke(entity) != null) {
                valueString = method.invoke(entity).toString();
            }
            else{
                return null;
            }
        } catch (NoSuchMethodException e) {
            throw new ImporterException("Can not find getter method for attribute[" + fieldName + "]. Error: " + e.getMessage());
        } catch (InvocationTargetException e) {
            throw new ImporterException("Invoke getter method for attribute[" + fieldName + "] failed. Error: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new ImporterException("Invoke getter method for attribute[" + fieldName + "] failed. Error: " + e.getMessage());
        }
        return valueString;
    }
}

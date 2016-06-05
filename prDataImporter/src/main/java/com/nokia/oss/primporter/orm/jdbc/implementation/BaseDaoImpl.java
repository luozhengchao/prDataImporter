package com.nokia.oss.primporter.orm.jdbc.implementation;

import com.nokia.oss.primporter.exception.ImporterException;
import com.nokia.oss.primporter.orm.jdbc.BaseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * User: j59chen
 * Date: 2016/5/24
 * Time: 23:12
 * TO-DO: class Description, need to be modified
 */
public abstract class BaseDaoImpl implements BaseDao {
    protected Connection connection;
    protected Statement statement;

    public BaseDaoImpl(File properties){
        Properties propert = new Properties();
        try {
            propert.load(new FileInputStream(properties));
            initialize(propert);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ImporterException e) {
            e.printStackTrace();
        }
    }

    public void initialize(Properties properties) throws ImporterException{
        try {
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.password"));
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new ImporterException("Connection to DB failed. Error: " + e.getMessage());
        }

    }
}

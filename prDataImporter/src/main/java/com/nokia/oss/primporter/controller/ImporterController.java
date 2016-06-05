package com.nokia.oss.primporter.controller;

import com.nokia.oss.primporter.orm.jdbc.implementation.MySQLBaseDaoImpl;
import com.nokia.oss.primporter.parser.FileParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import static javafx.scene.input.KeyCode.F;

/**
 * User: j59chen
 * Date: 2016/5/18
 * Time: 17:24
 * TO-DO: class Description, need to be modified
 */
public class ImporterController {
    Logger LOG = Logger.getLogger(ImporterController.class);

    public static  String file;
    public static String newFolder;
    FileParser fileParser ;

    public void fileInput() throws Exception{
        Properties prop = new Properties();
        prop.load(new FileInputStream("src//main//resource//Properties.properties"));
        file = prop.getProperty("FILE_NAME").trim();
        newFolder=prop.getProperty("NEW_FOLDER").trim();
    }
    public  void readFile(String filepath) throws Exception {
        File file = new File(filepath);
        String[] fileList = file.list();
        for (int i = 0; i < fileList.length; i++) {
            File currentFile = new File(filepath + File.separator + fileList[i]);
            if (!currentFile.isDirectory()) {
                fileParser=new FileParser(new File(currentFile.getAbsolutePath()));
                fileParser.parseCSV();
                fileToFile(currentFile.getAbsolutePath(),newFolder);
            } else if (currentFile.isDirectory()) {
                readFile(filepath + File.separator + fileList[i]);
            }
        }
    }
    public static void fileToFile(String filePath,String newFolder){
        File fold = new File(filePath);//某路径下的文件
        File fnewpath = new File(newFolder);
        if(!fnewpath.exists())
            fnewpath.mkdirs();
        File fnew = new File(newFolder+File.separator+fold.getName());
        fold.renameTo(fnew);
    }
    public static void main(String[] args) throws Exception {
        ImporterController importerController = new ImporterController();
        importerController.fileInput();
        importerController.readFile(file);
    }
}

package com.iceye.utils;

/**
 * @author in-vinaykumar.gupta on 25/05/20
 * @project IntelliJ IDEA
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class is reponsible for reading property file data based on the environment passed
 */
public class PropertyFileReader {
    public static Map<String,String> listOfProperties =new HashMap<String, String>();
    public static Properties prop = new Properties();

    public static Map<String,String> getAllProperties() {
        String environment ="QA";
        //String environment =System.getProperty("env");
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+environment+".properties");
            prop.load(file);
            listOfProperties.put("serverUrl",prop.getProperty("serverUrl"));
            listOfProperties.put("userName",prop.getProperty("userName"));
            listOfProperties.put("password",prop.getProperty("password"));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfProperties;
    }
}

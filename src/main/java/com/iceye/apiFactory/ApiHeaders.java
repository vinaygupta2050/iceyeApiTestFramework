package com.iceye.apiFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author in-vinaykumar.gupta on 25/05/20
 * @project IntelliJ IDEA
 * Info: This class is responsible for creating header which we would be using in our test while sending request.
 */
public class ApiHeaders {

    public  static Map<String,String> defaultHeader(){
        Map<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("accept","*/*");
        //headerMap.put("Content-Type","application/json");
        return headerMap;

    }
    public  static Map<String,String> headerWithContentType(){
        Map<String,String> headerMap = new HashMap<String, String>();
        String token="";
        headerMap.put("accept","*/*");
        headerMap.put("Content-Type","application/json");
        return headerMap;
    }
}

package com.iceye.utils;

import com.google.gson.Gson;

/**
 * @author in-vinaykumar.gupta on 25/05/20
 * @project IntelliJ IDEA
 * Info: This class is responsible for converting pojo into json object
 */
public class SerializeDeserialize {
    public static String getJson (Object obj){
        Gson gson= new Gson();
        String json = gson.toJson(obj);
        return json;
    }
}

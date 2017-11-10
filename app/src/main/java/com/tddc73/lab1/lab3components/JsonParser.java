package com.tddc73.lab1.lab3components;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    public static List<String>  parseJsonString(String jsonString, int namesToGet) {

        List<String> result = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(jsonString);
            JSONArray jsonArray = jsonResponse.getJSONArray("result");
            int iterations = Math.min(namesToGet, jsonArray.length());
            for (int i = 0; i < iterations; i++) {
                result.add(jsonArray.getString(i));
            }
        }
        catch (Exception e){
            Log.e("JSON_ERROR", "Got exception parsing json, exception was " + e.toString());
        }
        return result;
    }
}
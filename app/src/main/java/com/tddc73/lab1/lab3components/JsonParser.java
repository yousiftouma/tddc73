package com.tddc73.lab1.lab3components;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A small JSON parser class to parse JSON strings to java objects
 */
public class JsonParser {

    /**
     * Parses a json object that contains a list of names to a list of strings
     * @param jsonString the JSON object as a string to parse
     * @param namesToGet how many of the names to get (first come first served)
     * @return a list of the namesToGet first names or all names if namesToGet is larger than number of names
     */
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
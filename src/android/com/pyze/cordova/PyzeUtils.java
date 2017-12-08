package com.pyze.cordova;

import com.pyze.android.events.dto.PyzeGeoPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jesudasjosephlobo on 25/05/16.
 */
public class PyzeUtil {
    public static HashMap<String,String> stringToHashMap(String mapString){
        HashMap<String,String> map = new HashMap<>();
        try {
            JSONObject mapObject = new JSONObject(mapString);
            Iterator<String> keys= mapObject.keys();
            while (keys.hasNext()){
                String key   =  keys.next();
                String value = mapObject.getString(key);
                map.put(key,value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static PyzeGeoPoint stringToPyzeGeoPoint(String pointString){
        PyzeGeoPoint pyzeGeoPoint = new PyzeGeoPoint();
        try {
            JSONObject pointObj = new JSONObject(pointString);
            pyzeGeoPoint.mLatitude  = (float) pointObj.getDouble("lat");
            pyzeGeoPoint.mLongitude = (float) pointObj.getDouble("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pyzeGeoPoint;
    }
}
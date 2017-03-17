package com.medium.reactnative.appsee;

import com.appsee.Appsee;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import android.util.Log;

import org.json.JSONException;

import java.util.Map;

class AppseeNativeModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNAppsee";

    public AppseeNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void startScreen(String screenName) {
        Log.d("startScreen", screenName);
        Appsee.startScreen(screenName);
    }

    @ReactMethod
    public void addEvent(String eventName, ReadableMap properties) throws JSONException {
        Log.d("appsee", eventName);
        Map<String, Object> propertiesMap = ReactNativeJson.convertReadableMapToHashMap(properties);
        if (propertiesMap.size() > 0) {
            Appsee.addEvent(eventName, propertiesMap);
        } else {
            Appsee.addEvent(eventName);
        }
    }
}

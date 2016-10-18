package com.medium.reactnative.appsee;

import com.appsee.Appsee;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.util.Log;

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
    public void addEvent(String eventName) {
        Log.d("appsee", eventName);
        Appsee.addEvent(eventName);
    }
}

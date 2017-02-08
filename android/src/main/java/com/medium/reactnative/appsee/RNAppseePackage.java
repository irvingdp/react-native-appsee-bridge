package com.medium.reactnative.appsee;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.appsee.Appsee;

public class RNAppseePackage implements ReactPackage {
    private String mApiKey;

    public RNAppseePackage(String apiKey) {
        mApiKey = apiKey;
        Appsee.addAppseeListener(new AppseeListener() {
            @Override
            public void onAppseeScreenDetected(AppseeScreenDetectedInfo screenInfo)
            {
                //Ignore "Main" screen that auto detect by appsee sdk.
                if(screenInfo.getScreenName().equals("MainActivity")){
                    screenInfo.setScreenName(null);
                }
            }
            @Override
            public void onAppseeSessionStarting(AppseeSessionStartingInfo startingInfo)
            {
            }
            @Override
            public void onAppseeSessionStarted(AppseeSessionStartedInfo sessionInfo)
            {
            }

            @Override
            public void onAppseeSessionEnding(AppseeSessionEndingInfo sessionInfo)
            {
            }
            @Override
            public void onAppseeSessionEnded(AppseeSessionEndedInfo sessionInfo)
            {
            }
        });
    }

    /**
     * according to appsee sdk, this is only allowed to be called within onCreate or onResume
     */
    public void start() {
        Appsee.start(mApiKey);
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new AppseeNativeModule(reactContext));
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

}

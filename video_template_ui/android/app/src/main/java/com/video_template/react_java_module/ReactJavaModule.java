package com.video_template.react_java_module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ReactJavaModule extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "ReactJavaModule";
    private final Context APP_CONTEXT;


    public ReactJavaModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.APP_CONTEXT = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void startActivityFromJS(String name, String params) throws ClassNotFoundException {
        Class<?> activity = Class.forName(name);
        Intent intent = new Intent(APP_CONTEXT, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("params", params);
        APP_CONTEXT.startActivity(intent);
    }
}
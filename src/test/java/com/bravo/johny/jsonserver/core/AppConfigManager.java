package com.bravo.johny.jsonserver.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public final class AppConfigManager {

    private static AppConfigManager instance;
    private JSONObject appSettingsJson;
    private JSONObject dataJson;

    private AppConfigManager() {
        try {
            URL fileResource = getClass().getClassLoader().getResource("appSettings.json");
            appSettingsJson = (JSONObject) new JSONParser().parse(new FileReader(fileResource.getFile()));

            fileResource = getClass().getClassLoader().getResource("data.json");
            dataJson = (JSONObject) new JSONParser().parse(new FileReader(fileResource.getFile()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static AppConfigManager getInstance() {
        if (instance == null){
            synchronized (AppConfigManager.class) {
                if(instance == null) {
                    instance = new AppConfigManager();
                }
            }
        }

        return instance;
    }

    public String getAppSettingsConfig(String key) {
        return appSettingsJson.get(key).toString();
    }

    public String getDataConfig(String key) {
        return dataJson.get(key).toString();
    }
}

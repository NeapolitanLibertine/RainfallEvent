package team.rainfall.rfEvent.config;

import aoc.kingdoms.lukasz.jakowski.FileManager;
import com.badlogic.gdx.utils.Json;
import team.rainfall.finality.FinalityLogger;

public class ConfigManager {
    public static final ConfigManager INSTANCE = new ConfigManager();
    private ConfigData configData = null;
    public ConfigData getConfigData(){
        if(configData == null){
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            json.addClassTag("layoutConfigs", EventLayoutConfig.class);
            configData = json.fromJson(ConfigData.class, FileManager.loadFile("rainfall/rfEvent.json"));
        }
        return configData;
    }
    public EventLayoutConfig getLayoutByID(int id){
        for (EventLayoutConfig uiConfig : getConfigData().layoutConfigs) {
            if(uiConfig.id == id) return uiConfig;
        }
        FinalityLogger.warn("[rfEvent] Layout "+id+" not found");
        return null;
    }
}

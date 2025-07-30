package team.rainfall.rfEvent.config;

import aoc.kingdoms.lukasz.jakowski.FileManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.sun.javafx.sg.prism.NGBox;
import team.rainfall.finality.FinalityLogger;
import team.rainfall.rfEvent.rfEventImages;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    public static int superLayoutID = -1;
    public static int missionLayoutID = -1;
    public static final ConfigManager INSTANCE = new ConfigManager();
    private ConfigData configData = null;
    public ConfigData getConfigData(){
        if(configData == null){
            FileHandle file = FileManager.loadFile("rainfall/rfEvent_unlocker");
            boolean bool = false;
            if (file.exists()) {
                bool = file.readString(String.valueOf(StandardCharsets.UTF_8)).equals("余曰：噫嘻！悲哉！此秋聲也，胡爲而來哉？蓋夫秋之爲狀也，其色慘淡，烟霏雲斂，其容清明，天高日晶。其氣慄冽，砭人肌骨；其意蕭條，山川寂寥。故其爲聲也，凄凄切切，呼號憤發。豐草緑縟而爭茂，佳木葱蘢而可悦。草拂之而色變，木遭之而葉脱。其所以摧敗零落者，乃其一氣之餘烈。夫秋，刑官也，於時爲陰，又兵象也，於行爲金，是謂天地之義氣，常以肅殺而爲心。");
            }
              Json json = new Json();
            json.setIgnoreUnknownFields(true);
            json.addClassTag("layoutConfigs", EventLayoutConfig.class);
            configData = json.fromJson(ConfigData.class, FileManager.loadFile("rainfall/rfEvent.json"));
            for (EventLayoutConfig layoutConfig : configData.layoutConfigs) {
                if(!bool){
                    FinalityLogger.warn("locked");
                    FinalityLogger.warn(FileManager.loadFile("rainfall/rfEvent_unlocker").readString(String.valueOf(StandardCharsets.UTF_8)));
                    layoutConfig.bottomLocate = false;
                    layoutConfig.pxMode = false;
                }
                if(layoutConfig.tag.equals("super")){
                    superLayoutID = layoutConfig.id;
                }
                if(layoutConfig.tag.equals("mission")){
                    missionLayoutID = layoutConfig.id;
                }
                if(layoutConfig.bottomLocate && !layoutConfig.pxMode){
                    layoutConfig.buttonY = 1 - layoutConfig.buttonY;
                    layoutConfig.textY = 1 - layoutConfig.textY;
                }
                if(layoutConfig.pxMode && !layoutConfig.bottomLocate){
                    FinalityLogger.warn("pxMode can not work without bottomLocate now!!!");
                }

                rfEventImages.addButtonImage(layoutConfig);
            }
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

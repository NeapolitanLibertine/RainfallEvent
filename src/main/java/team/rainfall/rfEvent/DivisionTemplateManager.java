package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;

public class DivisionTemplateManager {
    public static final DivisionTemplateManager INSTANCE = new DivisionTemplateManager();
    private Array<DivisionTemplate> DivisionTemplates = new Array<>();
    public DivisionTemplateManager(){
        loadDT();
    }
    public void loadDT() {
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            FileHandle fileList = FileManager.loadFile("game/DivisionTemplate.json");
            json.setElementType(DTList.class, "DivisionTemplates", DivisionTemplate.class);
            DTList nsList = json.fromJson(DTList.class, fileList);
            this.DivisionTemplates = nsList.DivisionTemplates;
        } catch (Exception e) {
            Gdx.app.error("RainfallEvent", "Failed to load NS", e);
        }
    }
    public DivisionTemplate getDT(int id){
        for (DivisionTemplate divisionTemplate : DivisionTemplates) {
            if(divisionTemplate.id == id){
                return divisionTemplate;
            }
        }
        return null;
    }
}

class DTList {
    Array<DivisionTemplate> DivisionTemplates = new Array<>();
}

package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.textures.ImageManager;
import team.rainfall.rfEvent.config.EventLayoutConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class rfEventImages {
    private static HashMap<Integer,ButtonImage> buttonImageMap = new HashMap<>();
    public static void addButtonImage(EventLayoutConfig layoutConfig){
        if(layoutConfig.buttonTexture != null && layoutConfig.buttonActiveTexture != null){
            ButtonImage buttonImage = new ButtonImage();
            buttonImage.btnID = ImageManager.addImage("ui/"+CFG.getRescouresPath()+layoutConfig.buttonTexture);
            buttonImage.btnActiveID = ImageManager.addImage("ui/"+CFG.getRescouresPath()+layoutConfig.buttonActiveTexture);
            buttonImageMap.put(layoutConfig.id,buttonImage);
        }
    }
    public static int getBtnImageID(int id){
        return buttonImageMap.get(id).btnID;
    }
    public static int getBtnActiveImageID(int id){
        return buttonImageMap.get(id).btnActiveID;
    }
}
class ButtonImage{
    int btnID = 0;
    int btnActiveID = 0;
}
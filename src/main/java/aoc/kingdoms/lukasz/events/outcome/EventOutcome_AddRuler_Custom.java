package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.map.Ruler;
import aoc.kingdoms.lukasz.map.RulersManager;
import aoc.kingdoms.lukasz.textures.Images;

import java.lang.reflect.Method;

public class EventOutcome_AddRuler_Custom extends EventOutcome{
    public String civTag;
    public int order;
    public static Method method = null;
    public EventOutcome_AddRuler_Custom(String civTag,int order){
        this.civTag = civTag;
        this.order = order;
    }
    public void updateCiv(int iCivID, int bonus_duration) {
        try {
           if(method == null){
               method = RulersManager.class.getDeclaredMethod("loadRuler", int.class, String.class,int.class);
           }
            method.invoke(null,Game.getCivID(civTag),civTag,order);
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }
    public String getStringLeft() {
        return Game.lang.get("Ruler") + ": ";
    }

    public String getStringRight() {
        return Game.getCiv(Game.getCivID(civTag)).sCivName;
    }

    public int getImage() {
        return Images.council;
    }
}

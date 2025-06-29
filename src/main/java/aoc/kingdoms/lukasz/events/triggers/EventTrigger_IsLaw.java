package aoc.kingdoms.lukasz.events.triggers;


import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;

public class EventTrigger_IsLaw extends EventTrigger_Value{
    public int iCivID = -1;
    public int lawID;
    public int lawStatus;
    public EventTrigger_IsLaw(int i,int j) {
        lawID = i;
        lawStatus = j;
    }
    public EventTrigger_IsLaw(String civTag,int i,int j) {
        this.iCivID = Game.getCivID(civTag);
        lawID = i;
        lawStatus = j;
    }
    public boolean outCondition(int iCivID, int iProvinceID) {
        if(this.iCivID != -1){
            iCivID = this.iCivID;
        }
        return Game.getCiv(iCivID).laws.get(lawID) == lawStatus;
    }

    public String getText() {
        return Game.lang.get("Law") + " = ";
    }

    public String getText2() {
        return lawID + ","+lawStatus;
    }

    public String getText3() {
        return "";
    }

    public int getImage() {
        return Images.law;
    }
}

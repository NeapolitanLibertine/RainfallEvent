package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.LawsManager;
import aoc.kingdoms.lukasz.textures.Images;

import static aoc.kingdoms.lukasz.map.LawsManager.updateCivBonuses;

public class EventOutcome_Change_Law extends EventOutcome{
    public int lawID;
    public int lawStatus;
    public int iCivID = -1;
    public EventOutcome_Change_Law(int i,int j) {
        lawID = i;
        lawStatus = j;
    }
    public EventOutcome_Change_Law(String  civTag,int i,int j) {
        this.iCivID = Game.getCivID(civTag);
        lawID = i;
        lawStatus = j;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        if(this.iCivID != -1){
            iCivID = this.iCivID;
        }
        try {
            updateCivBonuses(lawID, Game.getCiv(iCivID).laws.get(lawID), iCivID, -1.0F);
            try {
                Game.getCiv(iCivID).adoptReform(lawID, lawStatus);
            } catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            updateCivBonuses(lawID, Game.getCiv(iCivID).laws.get(lawID), iCivID, 1.0F);
        } catch (Exception var5) {
            CFG.exceptionStack(var5);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("Law") + ": ";
    }

    public String getStringRight() {
        return LawsManager.laws.get(lawID).Law[lawStatus];
    }

    public int getImage() {
        return Images.law;
    }
}

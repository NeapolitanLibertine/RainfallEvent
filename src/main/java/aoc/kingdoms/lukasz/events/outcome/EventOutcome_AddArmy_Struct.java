package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.Game_Ages;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.map.army.ArmyDivision;
import aoc.kingdoms.lukasz.map.army.ArmyRegiment;
import team.rainfall.rfEvent.DivisionTemplate;
import team.rainfall.rfEvent.DivisionTemplateManager;

import java.util.ArrayList;
import java.util.List;

public class EventOutcome_AddArmy_Struct extends EventOutcome{
    public int civID;
    public int provinceID;
    public int tempID;
    public DivisionTemplate dt;
    public EventOutcome_AddArmy_Struct(String civID,int provinceID,int tempID) {
        this.civID = Game.getCivID(civID);
        this.provinceID = provinceID;
        this.tempID = tempID;
        this.dt = DivisionTemplateManager.INSTANCE.getDT(tempID);
    }
    public EventOutcome_AddArmy_Struct(String civID,int tempID) {
        this.civID = Game.getCivID(civID);
        this.provinceID = -1;
        this.tempID = tempID;
        this.dt = DivisionTemplateManager.INSTANCE.getDT(tempID);
    }
    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            if(provinceID == -1){
                provinceID = Game.getCiv(civID).getCapitalProvinceID();
            }
            if(Game.getProvince(provinceID).getCivID() == iCivID) {
                List<ArmyRegiment> armyRegiments = new ArrayList<>();
                for (int i = Math.min(dt.armyIDs.length, dt.unitIDs.length) - 1; i >= 0; --i) {
                    armyRegiments.add(new ArmyRegiment(dt.unitIDs[i], dt.armyIDs[i]));
                }
                ArmyDivision armyDivision = new ArmyDivision(iCivID,provinceID, armyRegiments);
                Game.getProvince(provinceID).addArmy(armyDivision);
                try{
                    armyDivision.getClass().getField("name").set(armyDivision,dt.name);
                }catch (Exception ignored){

                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        if(provinceID == -1){
            provinceID = Game.getCiv(civID).getCapitalProvinceID();
        }
        return Game.getProvince(provinceID).getProvinceName() + ", " + Game.lang.get("Army") + ": ";
    }

    public String getStringRight() {
        return "" + CFG.getNumberWithSpaces("" + dt.unitIDs.length * ((Game_Ages.Data_Ages)Game.gameAges.lAges.get(Game_Calendar.CURRENT_AGEID)).REGIMENT_SIZE);
    }

    public int getImage() {
        return Game_Calendar.IMG_MANPOWER;
    }
}

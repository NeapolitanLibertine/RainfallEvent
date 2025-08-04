//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.Game_Ages;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.map.army.ArmyDivision;
import aoc.kingdoms.lukasz.map.army.ArmyRegiment;
import java.util.ArrayList;
import java.util.List;

public class EventOutcome_AddArmy extends EventOutcome {
    public List<Integer> unitID = new ArrayList();
    public List<Integer> armyID = new ArrayList();

    public EventOutcome_AddArmy(List<Integer> unitID, List<Integer> armyID) {
        this.unitID = unitID;
        this.armyID = armyID;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            if (Game.getCiv(iCivID).getCapitalProvinceID() >= 0 && Game.getProvince(Game.getCiv(iCivID).getCapitalProvinceID()).getCivID() == iCivID && this.armyID.size() > 0 && this.unitID.size() > 0) {
                List<ArmyRegiment> armyRegiments = new ArrayList();

                for(int i = Math.min(this.armyID.size(), this.unitID.size()) - 1; i >= 0; --i) {
                    armyRegiments.add(new ArmyRegiment((Integer)this.unitID.get(i), (Integer)this.armyID.get(i)));
                }

                ArmyDivision armyDivision = new ArmyDivision(iCivID, Game.getCiv(iCivID).getCapitalProvinceID(), armyRegiments);
                Game.getProvince(Game.getCiv(iCivID).getCapitalProvinceID()).addArmy_Load(armyDivision);
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.getCiv(Game.player.iCivID).getCapitalProvinceID() >= 0 && Game.getProvince(Game.getCiv(Game.player.iCivID).getCapitalProvinceID()).getCivID() == Game.player.iCivID ? Game.getProvince(Game.getCiv(Game.player.iCivID).getCapitalProvinceID()).getProvinceName() + ", " + Game.lang.get("Army") + ": " : Game.lang.get("Army") + ": ";
    }

    public String getStringRight() {
        return "" + CFG.getNumberWithSpaces("" + this.unitID.size() * ((Game_Ages.Data_Ages)Game.gameAges.lAges.get(Game_Calendar.CURRENT_AGEID)).REGIMENT_SIZE);
    }

    public int getImage() {
        return Game_Calendar.IMG_MANPOWER;
    }
}

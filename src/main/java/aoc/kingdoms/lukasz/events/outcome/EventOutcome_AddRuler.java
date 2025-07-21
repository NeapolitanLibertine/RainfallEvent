//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.map.Ruler;
import aoc.kingdoms.lukasz.map.RulersManager;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_AddRuler extends EventOutcome {
    public String sName;
    public String sSurname;
    public String imageID;
    public int BornDay;
    public int BornMonth;
    public int BornYear;

    public EventOutcome_AddRuler(String sName, String sSurname, String imageID, int BornDay, int BornMonth, int BornYear) {
        this.sName = sName;
        this.sSurname = sSurname;
        this.imageID = imageID;
        this.BornDay = BornDay;
        this.BornMonth = BornMonth;
        this.BornYear = BornYear;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int nBornYear = this.BornYear;
            if (Game_Calendar.currentYear - nBornYear < 10 || Game_Calendar.currentYear - nBornYear > 99) {
                nBornYear = Game_Calendar.currentYear - GameValues.generals.GENERAL_YEARS_OLD_MIN - Game.oR.nextInt(GameValues.generals.GENERAL_YEARS_OLD_RANDOM);
            }
            Game.getCiv(iCivID).ruler = new Ruler(iCivID, this.sName + " " + this.sSurname, "" + this.imageID, this.BornDay, this.BornMonth, nBornYear, Game_Calendar.currentYear, false, false);
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("Ruler") + ": ";
    }

    public String getStringRight() {
        return "" + this.sName + "  " + this.sSurname;
    }

    public int getImage() {
        return Images.council;
    }
}

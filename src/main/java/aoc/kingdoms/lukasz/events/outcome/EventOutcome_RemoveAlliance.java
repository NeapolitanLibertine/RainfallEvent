//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_RemoveAlliance extends EventOutcome {
    public String fromCivTAG;
    public String toCivTag;

    public EventOutcome_RemoveAlliance(String fromCivTAG, String toCivTag) {
        this.fromCivTAG = fromCivTAG;
        this.toCivTag = toCivTag;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int fromCivID = Game.getCivID(this.fromCivTAG);
            int toCivID = Game.getCivID(this.toCivTag);
            if (fromCivID > 0 && toCivID > 0) {
                DiplomacyManager.removeAlliance(fromCivID, toCivID);
            }
        } catch (Exception var5) {
            Exception ex = var5;
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("DisolveAlliance") + ": ";
    }

    public String getStringRight() {
        return Game.lang.getCiv(this.fromCivTAG) + " - " + Game.lang.getCiv(this.toCivTag);
    }

    public int getImage() {
        return Images.alliance;
    }
}

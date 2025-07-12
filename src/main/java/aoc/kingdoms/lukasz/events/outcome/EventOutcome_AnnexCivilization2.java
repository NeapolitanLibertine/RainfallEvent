//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_AnnexCivilization2 extends EventOutcome {
    public String annexCivTag = "";

    public EventOutcome_AnnexCivilization2(String annexCivTag) {
        this.annexCivTag = annexCivTag;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        int annexCivID = Game.getCivID(this.annexCivTag);
        if (annexCivID != iCivID && annexCivID > 0) {
            for(int i = Game.getCiv(annexCivID).getNumOfProvinces() - 1; i >= 0; --i) {
                try {
                    int pID = Game.getCiv(annexCivID).getProvinceID(i);
                    Game.getProvince(pID).setCivID(iCivID);
                    Game.getProvince(pID).removeArmyCivID(annexCivID);
                    //Game.getProvince(pID).addCore(iCivID);
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }

    }

    public String getStringLeft() {
        return Game.lang.get("Annexation") + ": ";
    }

    public String getStringRight() {
        int annexCivID = Game.getCivID(this.annexCivTag);
        return annexCivID > 0 && Game.getCiv(annexCivID).getNumOfProvinces() > 0 ? Game.getCiv(annexCivID).getCivName() : Game.lang.get("None");
    }

    public int getImage() {
        return Images.provinces;
    }
}

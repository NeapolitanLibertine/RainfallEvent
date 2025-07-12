//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.menusInGame.Info.InGame_Info;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_AnnexedByCivilization2 extends EventOutcome {
    public String annexedByCivTag = "";

    public EventOutcome_AnnexedByCivilization2(String annexCivTag) {
        this.annexedByCivTag = annexCivTag;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        int annexCivID = Game.getCivID(this.annexedByCivTag);
        if (annexCivID != iCivID && annexCivID > 0 && iCivID > 0) {
            for(int i = Game.getCiv(iCivID).getNumOfProvinces() - 1; i >= 0; --i) {
                try {
                    int pID = Game.getCiv(iCivID).getProvinceID(i);
                    Game.getProvince(pID).setCivID(annexCivID);
                    Game.getProvince(pID).removeArmyCivID(iCivID);
                    //Game.getProvince(pID).addCore(annexCivID);
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            Game.gameThread.addCivUpdateTotalIncomePerMonth(annexCivID);
            Game.gameThread.addCivUpdateTotalIncomePerMonth(iCivID);
            if (annexCivID == Game.player.iCivID) {
                InGame_Info.iCivID = annexCivID;
                InGame_Info.iCivID2 = iCivID;
                Game.menuManager.rebuildInGame_Info(Game.lang.get("AcceptedOurUltimatum"), Game.getCiv(annexCivID).getCivName() + " - " + Game.getCiv(iCivID).getCivName());
                InGame_Info.imgID = Images.infoDiplomacy;
            }
        }

    }

    public String getStringLeft() {
        return Game.lang.getCiv(this.annexedByCivTag) + ", " + Game.lang.get("Annexation") + ": ";
    }

    public String getStringRight() {
        return Game.getCiv(Game.player.iCivID).getCivName();
    }

    public int getImage() {
        return Images.provinces;
    }
}

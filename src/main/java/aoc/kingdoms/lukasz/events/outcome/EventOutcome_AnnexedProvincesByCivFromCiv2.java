//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.army.ArmyDivision;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.menusInGame.Info.InGame_Info;
import aoc.kingdoms.lukasz.textures.Images;
import java.util.List;

public class EventOutcome_AnnexedProvincesByCivFromCiv2 extends EventOutcome {
    public String sFromCivTAG;
    public String byCivTAG;
    public List<Integer> lProvinces;

    public EventOutcome_AnnexedProvincesByCivFromCiv2(String byCivTAG, String sFromCivTAG, List<Integer> nProvinces) {
        this.byCivTAG = byCivTAG;
        this.sFromCivTAG = sFromCivTAG;
        this.lProvinces = nProvinces;

        for(int i = this.lProvinces.size() - 1; i >= 0; --i) {
            if ((Integer)this.lProvinces.get(i) < 0 || (Integer)this.lProvinces.get(i) >= Game.getProvincesSize()) {
                this.lProvinces.remove(i);
            }
        }

    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int annexByCivID = Game.getCivID(this.byCivTAG);
            int annexFromCivID = Game.getCivID(this.sFromCivTAG);
            if (annexByCivID > 0 && annexFromCivID > 0) {
                for(int i = this.lProvinces.size() - 1; i >= 0; --i) {
                    if (Game.getProvince((Integer)this.lProvinces.get(i)).getCivID() == annexFromCivID) {
                        Game.getProvince((Integer)this.lProvinces.get(i)).setCivID(annexByCivID);
                       // Game.getProvince((Integer)this.lProvinces.get(i)).addCore(annexByCivID);
                    }
                }

                for(int i = this.lProvinces.size() - 1; i >= 0; --i) {
                    if (Game.getProvince((Integer)this.lProvinces.get(i)).getCivID() == annexByCivID) {
                        for(int j = Game.getProvince((Integer)this.lProvinces.get(i)).getArmySize() - 1; j >= 0; --j) {
                            if (!DiplomacyManager.isAlly(annexByCivID, Game.getProvince((Integer)this.lProvinces.get(i)).getArmy(j).civID)) {
                                ArmyDivision tArmy = Game.getProvince((Integer)this.lProvinces.get(i)).getArmy(j);
                                Game.getProvince((Integer)this.lProvinces.get(i)).removeArmy(j);
                                if (tArmy.civID > 0 && Game.getCiv(tArmy.civID).getCapitalProvinceID() >= 0 && Game.getProvince(Game.getCiv(tArmy.civID).getCapitalProvinceID()).getCivID() == tArmy.civID) {
                                    Game.getProvince(Game.getCiv(tArmy.civID).getCapitalProvinceID()).addArmy(tArmy);
                                }
                            }
                        }
                    }
                }

                Game.gameThread.addCivUpdateTotalIncomePerMonth(annexByCivID);
                Game.gameThread.addCivUpdateTotalIncomePerMonth(annexFromCivID);
                if (annexByCivID == Game.player.iCivID) {
                    InGame_Info.iCivID = annexByCivID;
                    InGame_Info.iCivID2 = annexFromCivID;
                    Game.menuManager.rebuildInGame_Info(Game.lang.get("AcceptedOurUltimatum"), Game.getCiv(annexByCivID).getCivName() + " - " + Game.getCiv(annexFromCivID).getCivName());
                    InGame_Info.imgID = Images.infoDiplomacy;
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.getCiv(this.byCivTAG) + ", " + Game.lang.get("Annexation") + ": ";
    }

    public String getStringRight() {
        String out = "";
        int annexCivID = Game.getCivID(this.sFromCivTAG);

        for(int i = 0; i < this.lProvinces.size(); ++i) {
            if ((Integer)this.lProvinces.get(i) >= 0 && (Integer)this.lProvinces.get(i) < Game.getProvincesSize() && Game.getProvince((Integer)this.lProvinces.get(i)).getCivID() == annexCivID) {
                out = out + Game.getProvince((Integer)this.lProvinces.get(i)).getProvinceName() + (i == this.lProvinces.size() - 1 ? "" : ", ");
            }
        }

        if (out.length() > 0) {
            return out;
        } else {
            return Game.lang.get("None");
        }
    }

    public int getImage() {
        return Images.provinces;
    }
}

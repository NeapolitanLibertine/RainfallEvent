//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.menusInGame.Info.InGame_Info;
import aoc.kingdoms.lukasz.textures.Images;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventOutcome_WhitePeace extends EventOutcome {
    public String fromCivTAG;
    public String toCivTag;

    public EventOutcome_WhitePeace(String fromCivTAG, String toCivTag) {
        this.fromCivTAG = fromCivTAG;
        this.toCivTag = toCivTag;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int fromCivID = Game.getCivID(this.fromCivTAG);
            int toCivID = Game.getCivID(this.toCivTag);
            if (fromCivID > 0 && toCivID > 0) {
                List<String> list1 =  Game.getCiv(fromCivID).diplomacy.lWars;
                List<String> list2 = Game.getCiv(toCivID).diplomacy.lWars;
                String key = hasCommonString(list1,list2);
                if (key != null) {
                    DiplomacyManager.whitePeace(key);
                    Game.menuManager.setVisibleInGame_War(false);
                    Game.menuManager.rebuildInGame_Wars();
                    InGame_Info.iCivID = fromCivID;
                    InGame_Info.iCivID2 = toCivID;
                    if(Game.player.iCivID == fromCivID || Game.player.iCivID == toCivID) {
                        Game.menuManager.rebuildInGame_Info(Game.lang.get("WhitePeace"), Game_Calendar.getCurrentDate());
                    }
                    InGame_Info.imgID = Images.infoDiplomacy;
                }
            }
        } catch (Exception var5) {
            Exception ex = var5;
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("WhitePeace") + ": ";
    }

    public String getStringRight() {
        return Game.lang.getCiv(this.fromCivTAG) + " - " + Game.lang.getCiv(this.toCivTag);
    }

    public int getImage() {
        return Images.peace;
    }
    public static String hasCommonString(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        for (String str : list2) {
            if (set1.contains(str)) {
                return str;
            }
        }
        return null;
    }
}

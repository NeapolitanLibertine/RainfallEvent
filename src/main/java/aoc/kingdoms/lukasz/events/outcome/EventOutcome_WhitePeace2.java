package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.textures.Images;

import java.util.*;

public class EventOutcome_WhitePeace2 extends EventOutcome{
    public String fromCivTAG;

    public EventOutcome_WhitePeace2(String fromCivTAG) {
        this.fromCivTAG = fromCivTAG;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int fromCivID = Game.getCivID(this.fromCivTAG);
            if (fromCivID > 0) {
                List<String> list1 =  Game.getCiv(fromCivID).diplomacy.lWars;
                ArrayList<String> keys = new ArrayList<>(list1);
                for (String key : keys) {
                    if (key != null) {
                        DiplomacyManager.whitePeace(key);
                        Game.menuManager.setVisibleInGame_War(false);
                        Game.menuManager.rebuildInGame_Wars();
                    }
                }
            }
        } catch (Exception var5) {
            CFG.exceptionStack(var5);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("WhitePeace") + ": ";
    }

    public String getStringRight() {
        return Game.lang.getCiv(this.fromCivTAG);
    }

    public int getImage() {
        return Images.peace;
    }
}

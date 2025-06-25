//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.triggers;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;

public class EventTrigger_IsPlayer2 extends EventTrigger_Value {

    public EventTrigger_IsPlayer2() {

    }

    public boolean outCondition(int iCivID, int iProvinceID) {
        try {
            return Game.player.iCivID == iCivID;
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
            return false;
        }
    }

    public String getText() {
        return Game.lang.get("Player") + " -> ";
    }

    public String getText2() {
        return "";
    }

    public String getText3() {
        return "";
    }
}

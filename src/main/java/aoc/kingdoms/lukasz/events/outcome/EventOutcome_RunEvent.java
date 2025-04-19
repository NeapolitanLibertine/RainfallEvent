//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.events.EventsManager;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.finality.FinalityLogger;

public class EventOutcome_RunEvent extends EventOutcome {
    public String eventID;

    public EventOutcome_RunEvent(String eventID) {
        this.eventID = eventID;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            FinalityLogger.debug("RUN EVENT "+this.eventID);
            EventsManager.runEvent.add(this.eventID);
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("Event");
    }

    public String getStringRight() {
        return "";
    }

    public int getImage() {
        return Images.time;
    }
}

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

public class EventOutcome_RunEventInstantly extends EventOutcome {
    public String eventID;

    public EventOutcome_RunEventInstantly(String eventID) {
        this.eventID = eventID;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            EventsManager.runEvent.add(this.eventID);
            EventsManager.runEvent(EventsManager.runEvent.size() - 1);
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

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;

import java.util.Iterator;

public class EventOutcome_RemoveVariable extends EventOutcome{
    public String value;

    public EventOutcome_RemoveVariable(String value) {
        this.value = value;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            Game.getCiv(iCivID).eventsDataVariables.v.removeIf(s -> s.equals(value));
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }
}

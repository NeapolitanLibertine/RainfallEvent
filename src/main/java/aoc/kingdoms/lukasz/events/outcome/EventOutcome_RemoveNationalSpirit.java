package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import team.rainfall.rfEvent.NS_Bridge;

public class EventOutcome_RemoveNationalSpirit extends EventOutcome{
    public String value;
    public int iCivID = -1;
    public EventOutcome_RemoveNationalSpirit(String value) {
        this.value = value;
    }
    public EventOutcome_RemoveNationalSpirit(int i,String value) {
        this.value = value;
        iCivID = i;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            if(this.iCivID != -1){
                iCivID = this.iCivID;
            }
            if(NS_Bridge.removeNS != null){
                NS_Bridge.removeNS.invoke(null,iCivID,value);
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }
}

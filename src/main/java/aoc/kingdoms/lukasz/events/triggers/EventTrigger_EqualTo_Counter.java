package aoc.kingdoms.lukasz.events.triggers;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.civilization.Civilization;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.rfEvent.Counter;
import team.rainfall.rfEvent.rfEvent;

public class EventTrigger_EqualTo_Counter extends EventTrigger_Value {
    public String counterName;
    public int value;

    public EventTrigger_EqualTo_Counter(String counterName,int value) {
        this.value = value;
        this.counterName = counterName;
    }

    public boolean outCondition(int iCivID, int iProvinceID) {
        Civilization civilization = Game.getCiv(iCivID);
        if(Counter.existsInCiv(civilization,counterName)){
            Counter counter;
            for (String s : civilization.eventsDataVariables.v) {
                if (s.startsWith("$$" + rfEvent.CODENAME + "_" + counterName)) {
                    counter = new Counter(s);
                    return counter.value == value;
                }
            }
        }
        //Game.menuManager.addToast_Error("Can not find counter:"+counterName);
        return false;
    }

    public String getText() {
        return Game.lang.get("Random") + " < ";
    }

    public String getText2() {
        return "" + CFG.getPrecision2(this.value, 10) + "%";
    }

    public String getText3() {
        return "";
    }

    public int getImage() {
        return Images.dice;
    }
}

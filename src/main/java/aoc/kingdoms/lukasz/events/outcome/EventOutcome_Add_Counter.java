package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.civilization.Civilization;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.rfEvent.Counter;
import team.rainfall.rfEvent.rfEvent;

import java.util.Iterator;

public class EventOutcome_Add_Counter extends EventOutcome{
    public String civTAG;
    public String counterName;
    public int value;
    public EventOutcome_Add_Counter(String civTAG, String counterName, int value) {
        this.civTAG = civTAG;
        this.value = value;
        this.counterName = counterName;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            Civilization civilization = Game.getCiv(iCivID);
            if(Counter.existsInCiv(civilization,counterName)){
                Counter counter = null;
                Iterator<String> iterator = civilization.eventsDataVariables.v.iterator();
                while (iterator.hasNext()){
                    String s = iterator.next();
                    if(s.startsWith("$$" + rfEvent.CODENAME + "_" + counterName)){
                        counter = new Counter(s);
                        iterator.remove();
                        break;
                    }
                }
                if (counter != null) {
                    counter.name = counterName;
                    counter.value = counter.value + value;
                    civilization.eventsDataVariables.addVariable(counter.getRaw());
                }else {
                    Game.menuManager.addToast_Error("Can not find counter:"+counterName);
                }
            }
        } catch (Exception var5) {
            CFG.exceptionStack(var5);
        }

    }

    public String getStringLeft() {
        return null;
    }

    public String getStringRight() {
        return "";
    }

    public int getImage() {
        return Images.nuke;
    }
}

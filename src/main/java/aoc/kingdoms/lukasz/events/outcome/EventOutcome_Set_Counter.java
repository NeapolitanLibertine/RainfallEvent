package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.civilization.Civilization;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.finality.FinalityLogger;
import team.rainfall.rfEvent.Counter;
import team.rainfall.rfEvent.ExpressionProcessor;
import team.rainfall.rfEvent.rfEvent;

//修改计数器
//这玩意的原理就是加一个特殊标签
public class EventOutcome_Set_Counter extends EventOutcome {
    public String civTAG;
    public String counterName;
    public String expStr;

    public EventOutcome_Set_Counter(String civTAG, String counterName, String expStr) {
        this.civTAG = civTAG;
        this.expStr = expStr;
        this.counterName = counterName;
    }
    public EventOutcome_Set_Counter(String counterName, String expStr) {
        this.civTAG = rfEvent.CODENAME;
        this.expStr = expStr;
        this.counterName = counterName;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            if(civTAG.equals(rfEvent.CODENAME)){
                civTAG = Game.getCiv(iCivID).getCivTag();
            }
            if(counterName.startsWith("$")) {
                counterName = counterName.replace("$","");
            }
            Counter counter = new Counter();
            String name = counterName;
            String civTag = Game.getCiv(iCivID).getCivTag();
            if(counterName.contains(":")){
                name = counterName.split(":")[0];
                civTag = counterName.split(":")[1];
            }
            counter.name = name;
            counter.iCivID = Game.getCivID(civTag);
            Civilization civilization = Game.getCiv(counter.iCivID);
            counter.value = ExpressionProcessor.compute(iCivID, expStr);
            if (Counter.existsInCiv(civilization, counterName)) {
                civilization.eventsDataVariables.v.removeIf(s -> s.startsWith("$$" + rfEvent.CODENAME + "_" + counterName));
            }
            civilization.eventsDataVariables.addVariable(counter.getRaw());

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

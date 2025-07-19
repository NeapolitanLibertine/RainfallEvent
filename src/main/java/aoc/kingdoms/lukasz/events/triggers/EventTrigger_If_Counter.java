package aoc.kingdoms.lukasz.events.triggers;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.finality.FinalityLogger;
import team.rainfall.rfEvent.ExpressionProcessor;

public class EventTrigger_If_Counter extends EventTrigger_Value{
    public String expStr;
    public EventTrigger_If_Counter(String expStr) {
        this.expStr = expStr;
    }

    public boolean outCondition(int iCivID, int iProvinceID) {
        return ExpressionProcessor.satisfied(iCivID,expStr);
    }

    public String getText() {
        return Game.lang.get("Counter")+":";
    }

    public String getText2() {
        return expStr;
    }

    public String getText3() {
        return "";
    }
}

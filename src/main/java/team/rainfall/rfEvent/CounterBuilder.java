package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.civilization.Civilization;
import team.rainfall.finality.FinalityLogger;

public class CounterBuilder {
    /**
     * Find the counter.
     * @param iCivID if this name doesn't specify a civ tag,it will be used as this counter's civ.
     * @param name counter name
     * @return A counter object,null when this counter can't be found.
     */
    public static Counter getCounterFromCiv(int iCivID,String name){
        name = name.replaceFirst("$","");//Remove the first $ if possible
        String civTag = "";
        Civilization civilization;
        if(name.contains(":")){
            civTag = name.split(":")[1];
            name = name.split(":")[0];
        }
        if(civTag.isEmpty()){
            civilization = Game.getCiv(iCivID);
        }else {
            civilization = Game.getCiv(Game.getCivID(civTag));
        }
        for (String s : civilization.eventsDataVariables.v) {
            FinalityLogger.debug("CIV_VAR "+s+" ; "+name);
            if(s.startsWith("$$" + rfEvent.CODENAME + "_"+name)){
                return new Counter(s);
            }
        }
        return null;
    }
}

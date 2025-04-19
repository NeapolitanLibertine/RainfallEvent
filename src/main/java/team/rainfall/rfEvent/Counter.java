package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.civilization.Civilization;

public class Counter {
    public int iCivID = 0;
    public String name;
    public int value;
    public Counter(String text){
        if(text.startsWith("$$"+rfEvent.CODENAME+"_")) {
            String[] array = text.replace("$$" + rfEvent.CODENAME + "_", "").split("=");
            name = array[0];
            if(name.contains(":")){
                iCivID = Game.getCivID(name.split(":")[1]);
                name = name.split(":")[0];
            }
            value = Integer.parseInt(array[1]);
        }else {
            name = "";
            value = 0;
        }
    }

    public Counter(){

    }
    public String getRaw(){
        return "$$" + rfEvent.CODENAME + "_"+name+"="+value;
    }

    public static boolean existsInCiv(Civilization civilization,String name){
        for (String s : civilization.eventsDataVariables.v) {
            if(s.startsWith("$$" + rfEvent.CODENAME + "_"+name)){
                return true;
            }
        }
        return false;
    }
}

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.technology.TechnologyTree;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_Tooltip extends EventOutcome{
    public boolean hideOutcomes;
    public String content;
    public EventOutcome_Tooltip(boolean hideOutcomes,String content){
        this.content = content;
        this.hideOutcomes = hideOutcomes;
    }


    public void updateCiv(int iCivID, int bonus_duration) {
        //Just do nothing
    }

    public String getStringLeft() {
        return "";
    }

    public String getStringRight() {
        return "";
    }

    public int getImage() {
        return Images.truce;
    }
}

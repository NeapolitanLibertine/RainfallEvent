package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.map.technology.TechnologyTree;
import aoc.kingdoms.lukasz.textures.Images;

public class EventOutcome_Unlock_Tech extends EventOutcome{
    public int techID = 0;

    public EventOutcome_Unlock_Tech(int i) {
        techID = i;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            Game.getCiv(iCivID).addTechnology(techID,false);
            Game.getCiv(iCivID).setAdvantagePoints(Game.getCiv(iCivID).getAdvantagePoints() - 1);
        } catch (Exception var5) {
            Exception ex = var5;
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("UnlockedTechnologies") + ": ";
    }

    public String getStringRight() {
        return TechnologyTree.lTechnology.get(techID).Name;
    }

    public int getImage() {
        return Images.techResearched;
    }
}

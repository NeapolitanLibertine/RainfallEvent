//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.rfEvent.rfEvent;

public class EventOutcome_SetCiv_Reset2 extends EventOutcome {
    public String fromCivTAG;
    public String toCivTag;

    public EventOutcome_SetCiv_Reset2(String fromCivTAG, String toCivTag) {
        this.fromCivTAG = fromCivTAG;
        this.toCivTag = toCivTag;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int fromCivID = Game.getCivID(this.fromCivTAG);
            if (fromCivID > 0) {
                Game.getCiv(fromCivID).setCivTag(this.toCivTag);
                Game.addSimpleTask(new Game.SimpleTask(this.toCivTag, fromCivID) {
                    public void update() {
                        Game.LoadCivilizationData civData = Game.loadCivilization(this.taskKey);
                        Game.getCiv(this.id).updateCivilizationTAG(this.taskKey, civData.iR, civData.iG, civData.iB);
                        rfEvent.loadMissionForCiv(this.id);
                    }
                });
            }
        } catch (Exception var4) {
            Exception ex = var4;
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.getCiv(this.fromCivTAG) + " -> ";
    }

    public String getStringRight() {
        return Game.lang.getCiv(this.toCivTag);
    }

    public int getImage() {
        return Images.government;
    }
}

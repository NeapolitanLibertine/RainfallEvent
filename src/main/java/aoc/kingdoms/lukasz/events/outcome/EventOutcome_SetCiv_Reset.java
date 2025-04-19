//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;
import team.rainfall.rfEvent.rfEvent;

public class EventOutcome_SetCiv_Reset extends EventOutcome {
    public String value;

    public EventOutcome_SetCiv_Reset(String value) {
        this.value = value;
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            Game.getCiv(iCivID).setCivTag(this.value);
            Game.addSimpleTask(new Game.SimpleTask(this.value, iCivID) {
                public void update() {
                    Game.LoadCivilizationData civData = Game.loadCivilization(this.taskKey);
                    Game.getCiv(this.id).updateCivilizationTAG(this.taskKey, civData.iR, civData.iG, civData.iB);
                    rfEvent.loadMissionForCiv(this.id);
                }
            });
        } catch (Exception var4) {
            Exception ex = var4;
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("FormCivilization") + ": ";
    }

    public String getStringRight() {
        return Game.lang.getCiv(this.value);
    }

    public int getImage() {
        return Images.government;
    }
}

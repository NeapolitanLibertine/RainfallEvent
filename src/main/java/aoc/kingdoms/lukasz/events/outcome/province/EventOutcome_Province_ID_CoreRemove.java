//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events.outcome.province;

import aoc.kingdoms.lukasz.events.outcome.EventOutcome;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.textures.Images;
import com.badlogic.gdx.utils.Array;

public class EventOutcome_Province_ID_CoreRemove extends EventOutcome {
    public String provID;
    public String civA;
    public Array<Integer> provIDs = new Array<>();
    public EventOutcome_Province_ID_CoreRemove(String provID, String civA) {
        this.provID = provID;
        this.civA = civA;
        for (String s : provID.split(";")) {
            this.provIDs.add(Integer.parseInt(s));
        }
    }

    public void updateCiv(int iCivID, int bonus_duration) {
        try {
            int idA = Game.getCivID(this.civA);
            if (idA > 0) {
                for (Integer id : provIDs) {
                    Game.getProvince(id).removeCore(idA);
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("Remove") + ", " + Game.lang.get("Core") + ": ";
    }

    public String getStringRight() {
        int idA = Game.getCivID(this.civA);
        return idA > 0 ? Game.getCiv(idA).getCivName() : " -- ";
    }

    public String getStringRight2(int bonus_duration) {
        try {
            StringBuilder right = new StringBuilder();
            for (Integer id : provIDs) {
                right.append(Game.getProvince(id).getProvinceName()).append(",");
            }
            return right.toString();
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
            return null;
        }
    }

    public int getImage() {
        return Images.core;
    }
}

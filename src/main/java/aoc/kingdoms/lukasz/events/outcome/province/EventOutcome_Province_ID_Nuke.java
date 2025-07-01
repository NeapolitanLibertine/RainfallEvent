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
import team.rainfall.rfEvent.NukeBypass;

public class EventOutcome_Province_ID_Nuke extends EventOutcome {
    public String provID;
    public int iCivID;
    public Array<Integer> provIDs = new Array<>();
    public EventOutcome_Province_ID_Nuke(String provID,String civTag) {
        this.provID = provID;
        this.iCivID = Game.getCivID(civTag);
        for (String s : provID.split(";")) {
            this.provIDs.add(Integer.parseInt(s));
        }
    }
    public void updateCiv(int iCivID, int bonus_duration) {
        try {
                for (Integer id : provIDs) {
                    NukeBypass.dropAtomicBomb(iCivID,id);
                }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public String getStringLeft() {
        return Game.lang.get("DropAtomicBomb") + ": ";
    }

    public String getStringRight() {
        return Game.getCiv(iCivID).sCivName;
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
        return Images.nuke;
    }
}

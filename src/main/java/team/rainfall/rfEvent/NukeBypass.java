package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.Renderer.RendererGame;
import aoc.kingdoms.lukasz.jakowski.Steam.SteamAchievementsManager;
import aoc.kingdoms.lukasz.map.diplomacy.DiplomacyManager;
import aoc.kingdoms.lukasz.menusInGame.Info.InGame_Info;
import aoc.kingdoms.lukasz.textures.Images;

public class NukeBypass {
    public static final int dropAtomicBomb(int iCivID, int iProvinceID) {
            int iCasualties = Game.getProvince(iProvinceID).atomicBombDropped();
            if (iCivID == Game.player.iCivID || Game.getProvince(iProvinceID).getCivID() == Game.player.iCivID) {
                InGame_Info.iCivID = iCivID;
                InGame_Info.iCivID2 = Game.getProvince(iProvinceID).getCivID();
                Game.menuManager.rebuildInGame_Info(Game.lang.get("AtomicBombing") + ": " + Game.getProvince(iProvinceID).getProvinceName(), Game.lang.get("Casualties") + ": " + CFG.getNumberWithSpaces("" + CFG.getPrecision2((float)iCasualties, 1)));
                InGame_Info.imgID = Images.infoAtomic;
                if (iCivID == Game.player.iCivID) {
                    SteamAchievementsManager.unlockAchievement(SteamAchievementsManager.DROP_NUKE);
                }
            }

            RendererGame.addNuke(iProvinceID);

        return -1;
    }
}

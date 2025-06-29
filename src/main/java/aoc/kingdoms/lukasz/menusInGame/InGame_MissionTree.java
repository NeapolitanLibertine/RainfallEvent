// Decompiled with: CFR 0.152
// Class Version: 8
package aoc.kingdoms.lukasz.menusInGame;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Missions.MissionTree;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import aoc.kingdoms.lukasz.jakowski.Renderer.SparksAnimation;
import aoc.kingdoms.lukasz.menu.Colors;
import aoc.kingdoms.lukasz.menu.Menu;
import aoc.kingdoms.lukasz.menu.menuTitle.MenuTitleTechTree;
import aoc.kingdoms.lukasz.menu_element.Empty;
import aoc.kingdoms.lukasz.menu_element.MenuElement;
import aoc.kingdoms.lukasz.menu_element.Status;
import aoc.kingdoms.lukasz.menu_element.button.ButtonMissionTree;
import aoc.kingdoms.lukasz.menu_element.button.ButtonMissionTreeCiv;
import aoc.kingdoms.lukasz.menus.InitGame;
import aoc.kingdoms.lukasz.textures.ImageManager;
import aoc.kingdoms.lukasz.textures.Images;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrawer.JoinType;

public class InGame_MissionTree
        extends Menu {
    public static SparksAnimation sparksAnimation = new SparksAnimation();
    protected static final int ANIMATION_TIME = 60;
    public static long lTime = 0L;
    public int iMapPosY = 0;
    public List<TechLine> lines = new ArrayList<TechLine>();
    public int iLinesSize = 0;

    public InGame_MissionTree() {
        boolean missionCanBeUnlocked;
        boolean missionUnlocked;
        int i;
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        int paddingLeft = CFG.PADDING * 2;
        int paddingTop = CFG.PADDING * 4;
        int titleHeight = ImageManager.getImage(Images.titleTechTree).getHeight();
        int menuWidth = CFG.GAME_WIDTH;
        int menuX = CFG.BUTTON_WIDTH + Renderer.boxBGExtraY + CFG.PADDING;
        int menuY = ImageManager.getImage(Images.topStats).getHeight() + CFG.PADDING * 2 + ImageManager.getImage(Images.title928).getHeight();
        int buttonY = paddingTop;
        int buttonX = paddingLeft;
        int centerToPosX = 0;
        if (Game.getCiv((int)Game.player.iCivID).iMissionsSize > 0) {
            for (i = 0; i < Game.getCiv((int)Game.player.iCivID).iMissionsSize; ++i) {
                missionUnlocked = MissionTree.haveUnlockedMission_Civ(Game.player.iCivID, i);
                missionCanBeUnlocked = MissionTree.canRunMission_Civ(Game.player.iCivID, i);
                menuElements.add(new ButtonMissionTreeCiv(i, Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).ImageID, 100 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeColumn, 15 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeRow, missionUnlocked, missionCanBeUnlocked));
                if (Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission >= 0) {
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeRow, missionUnlocked));
                }
                if (Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2 < 0) continue;
                this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeRow, missionUnlocked));
            }
        } else {
            for (i = 0; i < MissionTree.iMissionsSize; ++i) {
                missionUnlocked = MissionTree.haveUnlockedMission(Game.player.iCivID, i);
                missionCanBeUnlocked = MissionTree.canRunMission(Game.player.iCivID, i);
                menuElements.add(new ButtonMissionTree(i, MissionTree.lMissions.get((int)i).ImageID, 100 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, missionUnlocked, missionCanBeUnlocked));
                if (MissionTree.lMissions.get((int)i).RequiredMission >= 0) {
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, missionUnlocked));
                }
                if (MissionTree.lMissions.get((int)i).RequiredMission2 < 0) continue;
                this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission2).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission2).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, missionUnlocked));
            }
        }
        buttonY = 0;
        int iSize = menuElements.size();
        for (i = 0; i < iSize; ++i) {
            if (buttonY >= ((MenuElement)menuElements.get(i)).getPosY() + ((MenuElement)menuElements.get(i)).getHeight() + CFG.PADDING) continue;
            buttonY = ((MenuElement)menuElements.get(i)).getPosY() + ((MenuElement)menuElements.get(i)).getHeight() + CFG.PADDING;
        }
        int tMenuHeight = Math.min(buttonY, CFG.GAME_HEIGHT - menuY - CFG.PADDING * 2);
        int tMaxX = 0;
        int iSize2 = menuElements.size();
        for (MenuElement menuElement : menuElements) {
            if (((MenuElement) menuElement).getPosX() + ((MenuElement) menuElement).getWidth() <= tMaxX) continue;
            tMaxX = ((MenuElement) menuElement).getPosX() + ((MenuElement) menuElement).getWidth();
        }
        menuElements.add(new Empty(0, 0, tMaxX += 100, buttonY));
        buttonY = (int)Math.max((float)buttonY, (float)(MissionTree.iMissionHeight + 15) * ((float)GameValues.inGame.TECH_TREE_NUM_OF_ROWS + 0.25f) + (float)(paddingTop * 2));
        this.initMenu(new MenuTitleTechTree(Game.getCiv(Game.player.iCivID).getCivName() + ": " + Game.lang.get("Missions"), titleHeight, false, false){

            @Override
            public long getTime() {
                return lTime;
            }

            @Override
            public void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, Status titleStatus) {
                this.draw2(oSB, nPosX, nPosY, nWidth, titleStatus);
            }
        }, 0, CFG.GAME_HEIGHT / 2 - tMenuHeight / 2, menuWidth, tMenuHeight, menuElements, false, true);
        this.iMapPosY = (int)((float)Math.max(0, Game.mapBG.iHeightOfMapTech - CFG.GAME_HEIGHT) * ((float)Game.oR.nextInt(100) / 100.0f));
        this.iLinesSize = this.lines.size();
        if (centerToPosX != 0) {
            this.setMenuPosX(-centerToPosX + CFG.GAME_WIDTH / 4);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean menuIsActive, Status titleStatus) {
        float fA = 1.0f;
        if (lTime + 60L >= CFG.currentTimeMillis) {
            fA = (float)(CFG.currentTimeMillis - lTime) / 60.0f;
        }
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, 0.6f * fA));
        ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
        ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, 0.3f * fA));
        Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
        Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
        oSB.setColor(Color.WHITE);
        if (lTime + 60L >= CFG.currentTimeMillis) {
            iTranslateY = iTranslateY - CFG.BUTTON_HEIGHT + (int)((float)CFG.BUTTON_HEIGHT * ((float)(CFG.currentTimeMillis - lTime) / 60.0f));
        }
        Renderer.drawBoxCorner(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getTitle().getHeight() + iTranslateY, this.getWidth(), this.getHeight() + this.getTitle().getHeight() + CFG.PADDING);
        ImageManager.getImage(Images.insideTechTree).draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() + CFG.PADDING, false, true);
        Renderer.clipView_Start(oSB, this.getPosX() + iTranslateX, CFG.GAME_HEIGHT - (this.getPosY() + iTranslateY), this.getWidth(), -this.getHeight());
        Renderer.setShaderWater(oSB);
        ImageManager.getImage(Images.waves).draw2(oSB, 0, 0, CFG.GAME_WIDTH, CFG.GAME_HEIGHT, -this.getMenuPosX(), -this.getMenuPosY());
        Renderer.setShaderDefault(oSB);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.25f));
        oSB.setShader(Renderer.shaderAlpha);
        InitGame.background.getTexture().bind(1);
        Gdx.gl.glActiveTexture(33984);
        Images.gradientFull.draw(oSB, (CFG.GAME_WIDTH - InitGame.backgroundWidth) / 2 + iTranslateX, (CFG.GAME_HEIGHT - InitGame.backgroundHeight) / 2 + iTranslateY, InitGame.backgroundWidth, InitGame.backgroundHeight);
        Images.gradientXY.draw(oSB, (CFG.GAME_WIDTH - InitGame.backgroundWidth) / 2 + iTranslateX, (CFG.GAME_HEIGHT - InitGame.backgroundHeight) / 2 + iTranslateY, InitGame.backgroundWidth, InitGame.backgroundHeight);
        oSB.flush();
        oSB.setShader(Renderer.shaderDefault);
        oSB.setColor(Color.WHITE);
        Renderer.clipView_End(oSB);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.25f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 1.0f));
        ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1, false, true);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.35f));
        Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4);
        Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4, false, true);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.15f));
        sparksAnimation.draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - Images.sparkHeight + iTranslateY, this.getWidth(), Images.sparkHeight);
        oSB.setColor(Color.WHITE);
        for (int i = 0; i < this.iLinesSize; ++i) {
            this.lines.get((int)i).lPointsX.get(0);
            int jSize = this.lines.get((int)i).lPointsX.size();
            for (int j = 0; j < jSize; ++j) {
                ((Vector2)((TechLine)this.lines.get((int)i)).nPath.get((int)j)).x = this.getPosX() + this.getMenuPosX() + iTranslateX + this.lines.get((int)i).lPointsX.get(j);
                ((Vector2)((TechLine)this.lines.get((int)i)).nPath.get((int)j)).y = -(this.getMenuPosY() + iTranslateY + this.lines.get((int)i).lPointsY.get(j));
            }
            Renderer.shapeDrawer.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
            Renderer.shapeDrawer.path(this.lines.get(i).nPath, 3.0f, JoinType.SMOOTH, true);
            if (this.lines.get((int)i).unlocked) {
                Renderer.shapeDrawer.setColor(new Color(0.39215687f, 0.33333334f, 0.19607843f, 1.0f));
            } else {
                Renderer.shapeDrawer.setColor(new Color(0.3137255f, 0.3137255f, 0.3137255f, 1.0f));
            }
            Renderer.shapeDrawer.path(this.lines.get(i).nPath, 1.0f, JoinType.SMOOTH, true);
        }
        Renderer.oSBBorder.end();
        Renderer.oSBBorder.begin();
        super.draw(oSB, iTranslateX, iTranslateY, menuIsActive, titleStatus);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        lTime = CFG.currentTimeMillis;
    }

    @Override
    public void onHovered() {
        super.onHovered();
        Game.menuManager.setOrderOfMenu_TechnologyTree();
    }

    @Override
    public void actionCloseMenu() {
        super.actionCloseMenu();
        Game.menuManager.setVisibleInGame_TechnologyTree(false);
    }

    public class TechLine {
        public boolean unlocked = false;
        public int iMissionID;
        private Array<Vector2> nPath = new Array<>();
        public List<Integer> lPointsX = new ArrayList<Integer>();
        public List<Integer> lPointsY = new ArrayList<Integer>();

        public TechLine(int iMissionID, int iX, int iY, int iX2, int iY2, boolean unlocked) {
            this.iMissionID = iMissionID;
            this.unlocked = unlocked;
            this.lPointsX.add(iX);
            this.lPointsY.add(iY);
            if(iX == iX2 && iY != iY2){

            }
            else if (iY != iY2) {
                int mod = iY > iY2 ? -1 : 1;
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 - 8);
                this.lPointsY.add(iY);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 - 6);
                this.lPointsY.add(iY + mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 - 4);
                this.lPointsY.add(iY + 2 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 - 2);
                this.lPointsY.add(iY + 4 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 - 1);
                this.lPointsY.add(iY + 6 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50);
                this.lPointsY.add(iY + 8 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50);
                this.lPointsY.add(iY2 - 8 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 + 1);
                this.lPointsY.add(iY2 - 6 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 + 2);
                this.lPointsY.add(iY2 - 4 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 + 4);
                this.lPointsY.add(iY2 - 2 * mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 + 6);
                this.lPointsY.add(iY2 - mod);
                this.lPointsX.add(iX2 - MissionTree.iMissionWidth / 2 - 50 + 8);
                this.lPointsY.add(iY2);
            }
            this.lPointsX.add(iX2);
            this.lPointsY.add(iY2);
            for (int i = this.lPointsX.size() - 1; i >= 0; --i) {
                this.nPath.add(new Vector2(0.0f, 0.0f));
            }
        }
    }
}

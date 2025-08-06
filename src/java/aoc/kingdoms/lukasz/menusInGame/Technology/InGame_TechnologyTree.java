//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.menusInGame.Technology;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import aoc.kingdoms.lukasz.jakowski.Renderer.SparksAnimation;
import aoc.kingdoms.lukasz.map.technology.TechnologyTree;
import aoc.kingdoms.lukasz.menu.Colors;
import aoc.kingdoms.lukasz.menu.Menu;
import aoc.kingdoms.lukasz.menu.menuTitle.MenuTitleTechTree;
import aoc.kingdoms.lukasz.menu_element.Empty;
import aoc.kingdoms.lukasz.menu_element.MenuElement;
import aoc.kingdoms.lukasz.menu_element.Status;
import aoc.kingdoms.lukasz.menu_element.button.ButtonTechnology;
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

import aoc.kingdoms.lukasz.menusInGame.config.TreeStyleConfigManager;

public class InGame_TechnologyTree extends Menu {
    public static SparksAnimation sparksAnimation = new SparksAnimation();
    protected static final int ANIMATION_TIME = 60;
    public static long lTime = 0L;
    public int iMapPosY = 0;
    public List<TechLine> lines = new ArrayList<TechLine>();
    public int iLinesSize = 0;
    public static int centerToTechID = -1;

    // Configuration manager instance
    private static TreeStyleConfigManager configManager = TreeStyleConfigManager.getInstance();

    // Static method to reload technology tree connection line style configuration
    public static void reloadTechConnectionStyleConfig() {
        configManager.reloadConfigurations();
    }

    public InGame_TechnologyTree() {
        List<MenuElement> menuElements = new ArrayList<MenuElement>();
        int paddingLeft = CFG.PADDING * 2;
        int paddingTop = CFG.PADDING * 4;
        int titleHeight = ImageManager.getImage(Images.titleTechTree).getHeight();
        int menuWidth = CFG.GAME_WIDTH;
        int menuX = CFG.BUTTON_WIDTH + Renderer.boxBGExtraY + CFG.PADDING;
        int menuY = ImageManager.getImage(Images.topStats).getHeight() + CFG.PADDING * 2 + ImageManager.getImage(Images.title928).getHeight();
        int centerToPosX = 0;

        for(int i = 0; i < TechnologyTree.iTechnologySize; ++i) {
            menuElements.add(new ButtonTechnology(TechnologyTree.getTechBG(i, Game.player.iCivID), i, 100 + (TechnologyTree.iTechnologyWidth + 100) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeColumn, 15 + (TechnologyTree.iTechnologyHeight + 15) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeRow, true, Game.player.playerData.techQueue.getTechIsInQueue(i)));
            if (centerToTechID >= 0) {
                if (i == centerToTechID) {
                    centerToPosX = Math.max(centerToPosX, ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosX());
                }
            } else if (Game.getCiv(Game.player.iCivID).getTechResearched(i)) {
                centerToPosX = Math.max(centerToPosX, ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosX());
            }

            if (((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech >= 0) {
                // Use the research status of the prerequisite technology
                boolean requiredTechResearched = Game.getCiv(Game.player.iCivID).getTechResearched(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech);
                this.lines.add(new TechLine(i, 100 + TechnologyTree.iTechnologyWidth / 2 + (TechnologyTree.iTechnologyWidth + 100) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech)).TreeColumn, 15 + TechnologyTree.iTechnologyHeight / 2 + (TechnologyTree.iTechnologyHeight + 15) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech)).TreeRow, 100 + TechnologyTree.iTechnologyWidth / 2 + (TechnologyTree.iTechnologyWidth + 100) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeColumn, 15 + TechnologyTree.iTechnologyHeight / 2 + (TechnologyTree.iTechnologyHeight + 15) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeRow, requiredTechResearched));
            }

            if (((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech2 >= 0) {
                // Use the research status of the second prerequisite technology
                boolean requiredTech2Researched = Game.getCiv(Game.player.iCivID).getTechResearched(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech2);
                this.lines.add(new TechLine(i, 100 + TechnologyTree.iTechnologyWidth / 2 + (TechnologyTree.iTechnologyWidth + 100) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech2)).TreeColumn, 15 + TechnologyTree.iTechnologyHeight / 2 + (TechnologyTree.iTechnologyHeight + 15) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).RequiredTech2)).TreeRow, 100 + TechnologyTree.iTechnologyWidth / 2 + (TechnologyTree.iTechnologyWidth + 100) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeColumn, 15 + TechnologyTree.iTechnologyHeight / 2 + (TechnologyTree.iTechnologyHeight + 15) * ((TechnologyTree.Technology)TechnologyTree.lTechnology.get(i)).TreeRow, requiredTech2Researched));
            }
        }

        int buttonY = 0;
        int i = 0;

        for(int iSize = menuElements.size(); i < iSize; ++i) {
            if (buttonY < ((MenuElement)menuElements.get(i)).getPosY() + ((MenuElement)menuElements.get(i)).getHeight() + CFG.PADDING) {
                buttonY = ((MenuElement)menuElements.get(i)).getPosY() + ((MenuElement)menuElements.get(i)).getHeight() + CFG.PADDING;
            }
        }

        int menuHeight = Math.min(buttonY, CFG.GAME_HEIGHT - menuY - CFG.PADDING * 2);
        int tMaxX = 0;

        for(int j = 0; j < menuElements.size(); ++j) {
            if (((MenuElement)menuElements.get(j)).getPosX() + ((MenuElement)menuElements.get(j)).getWidth() > tMaxX) {
                tMaxX = ((MenuElement)menuElements.get(j)).getPosX() + ((MenuElement)menuElements.get(j)).getWidth();
            }
        }

        tMaxX += 100;
        menuElements.add(new Empty(0, 0, tMaxX, buttonY));
        buttonY = (int)Math.max((float)buttonY, (float)(TechnologyTree.iTechnologyHeight + 15) * ((float)GameValues.inGame.TECH_TREE_NUM_OF_ROWS + 0.25F) + (float)(paddingTop * 2));
        this.initMenu(new MenuTitleTechTree(Game.lang.get("TechnologyTree"), titleHeight, false, false) {
            public long getTime() {
                return InGame_TechnologyTree.lTime;
            }
        }, 0, CFG.GAME_HEIGHT / 2 - menuHeight / 2, menuWidth, menuHeight, menuElements, false, true);
        this.iMapPosY = (int)((float)Math.max(0, Game.mapBG.iHeightOfMapTech - CFG.GAME_HEIGHT) * ((float)Game.oR.nextInt(100) / 100.0F));
        this.iLinesSize = this.lines.size();
        if (centerToPosX != 0) {
            this.setMenuPosX(-centerToPosX + CFG.GAME_WIDTH / 4);
        }

    }

    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean menuIsActive, Status titleStatus) {
        TreeStyleConfigManager.TechnologyTreeConfig config = configManager.getTechnologyTreeConfig();

        float fA = 1.0F;
        if (lTime + 60L >= CFG.currentTimeMillis) {
            fA = (float)(CFG.currentTimeMillis - lTime) / 60.0F;
        }

        // Draw gradient background if enabled
        if (config.enableGradientBackground) {
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, config.gradientOpacity * fA));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
            ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, 0.3F * fA));
            Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
            Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
        }
        oSB.setColor(Color.WHITE);
        if (lTime + 60L >= CFG.currentTimeMillis) {
            iTranslateY = iTranslateY - CFG.BUTTON_HEIGHT + (int)((float)CFG.BUTTON_HEIGHT * ((float)(CFG.currentTimeMillis - lTime) / 60.0F));
        }

        Renderer.drawBoxCorner(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getTitle().getHeight() + iTranslateY, this.getWidth(), this.getHeight() + this.getTitle().getHeight() + CFG.PADDING);
        ImageManager.getImage(Images.insideTechTree).draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() + CFG.PADDING, false, true);

        // Start clip view if enabled
        if (config.enableClipView) {
            Renderer.clipView_Start(oSB, this.getPosX() + iTranslateX, CFG.GAME_HEIGHT - (this.getPosY() + iTranslateY), this.getWidth(), -this.getHeight());
        }

        // Draw wave effect if enabled
        if (config.enableWaveEffect) {
            Renderer.setShaderWater(oSB);
            ImageManager.getImage(Images.waves).draw2(oSB, 0, 0, CFG.GAME_WIDTH, CFG.GAME_HEIGHT, -this.getMenuPosX(), -this.getMenuPosY());
            Renderer.setShaderDefault(oSB);
        }

        // Draw map background if enabled
        if (config.enableMapBackground && Game.map.getActiveMap_MapData().mapData.BackgroundZoomOut_Enable) {
            oSB.setColor(new Color(1.0F, 1.0F, 1.0F, config.mapBackgroundOpacity));
            Game.mapBG.drawMapBG2_TechTree(oSB, this.getPosX() + this.getMenuPosX() + iTranslateX, this.getPosY() + iTranslateY);
            oSB.setColor(Color.WHITE);
        } else if (config.enableBackgroundShader) {
            // Draw background shader effects if enabled
            oSB.setColor(new Color(1.0F, 1.0F, 1.0F, config.backgroundShaderOpacity));
            oSB.setShader(Renderer.shaderAlpha);
            InitGame.background.getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            Images.gradientFull.draw(oSB, (CFG.GAME_WIDTH - InitGame.backgroundWidth) / 2 + iTranslateX, (CFG.GAME_HEIGHT - InitGame.backgroundHeight) / 2 + iTranslateY, InitGame.backgroundWidth, InitGame.backgroundHeight);
            Images.gradientXY.draw(oSB, (CFG.GAME_WIDTH - InitGame.backgroundWidth) / 2 + iTranslateX, (CFG.GAME_HEIGHT - InitGame.backgroundHeight) / 2 + iTranslateY, InitGame.backgroundWidth, InitGame.backgroundHeight);
            oSB.flush();
            oSB.setShader(Renderer.shaderDefault);
            oSB.setColor(Color.WHITE);
        }

        // End clip view if it was enabled
        if (config.enableClipView) {
            Renderer.clipView_End(oSB);
        }
        // Draw additional gradient effects if enabled
        if (config.enableGradientBackground) {
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.25F));
            Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 1.0F));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1, false, true);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.35F));
            Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
            oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.5F));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4);
            Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4, false, true);
        }

        // Draw sparks animation if enabled
        if (config.enableSparksAnimation) {
            oSB.setColor(new Color(1.0F, 1.0F, 1.0F, config.sparksOpacity));
            sparksAnimation.draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - Images.sparkHeight + iTranslateY, this.getWidth(), Images.sparkHeight);
        }
        oSB.setColor(Color.WHITE);

        for(int i = 0; i < this.iLinesSize; ++i) {
            TechLine techLine = (TechLine)this.lines.get(i);
            int j = 0;

            // Update path point coordinates, constrained to menu area
            for(int jSize = techLine.lPointsX.size(); j < jSize; ++j) {
                ((Vector2)techLine.nPath.get(j)).x = (float)(this.getPosX() + this.getMenuPosX() + iTranslateX + (Integer)techLine.lPointsX.get(j));
                ((Vector2)techLine.nPath.get(j)).y = (float)(-(this.getMenuPosY() + iTranslateY + (Integer)techLine.lPointsY.get(j)));
            }

            // Draw the thicker outline border of the connection line
            Renderer.shapeDrawer.setColor(config.connectionOutlineColor);
            Renderer.shapeDrawer.path(techLine.nPath, config.connectionOutlineWidth, config.connectionJoinType, true);

            // Draw the inner line color based on technology research status
            if (techLine.researched) {
                // Use gold color for researched technologies
                Renderer.shapeDrawer.setColor(config.connectionUnlockedColor);
            } else {
                // Use darker gray for unresearched technologies
                Renderer.shapeDrawer.setColor(config.connectionLockedColor);
            }

            Renderer.shapeDrawer.path(techLine.nPath, config.connectionInnerWidth, config.connectionJoinType, true);
        }

        Renderer.oSBBorder.end();
        Renderer.oSBBorder.begin();
        super.draw(oSB, iTranslateX, iTranslateY, menuIsActive, titleStatus);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        lTime = CFG.currentTimeMillis;
    }

    public void onHovered() {
        super.onHovered();
        Game.menuManager.setOrderOfMenu_TechnologyTree();
    }

    public void actionCloseMenu() {
        super.actionCloseMenu();
        Game.menuManager.setVisibleInGame_TechnologyTree(false);
    }

    public class TechLine {
        public boolean researched = false;
        public int iTechID;
        private Array<Vector2> nPath = new Array<Vector2>();
        public List<Integer> lPointsX = new ArrayList<Integer>();
        public List<Integer> lPointsY = new ArrayList<Integer>();

        // Add menu boundary information for constraining path points
        private int menuWidth = 0;
        private int menuHeight = 0;

        public TechLine(int iTechID, int iX, int iY, int iX2, int iY2, boolean researched) {
            this.iTechID = iTechID;
            this.researched = researched;

            // Record menu size for subsequent clipping
            this.menuWidth = InGame_TechnologyTree.this.getWidth();
            this.menuHeight = InGame_TechnologyTree.this.getHeight();

            // Add starting point
            this.lPointsX.add(iX);
            this.lPointsY.add(iY);

            if (TreeStyleConfigManager.getInstance().getTechnologyTreeConfig().useVerticalStyle) {
                // Use vertical technology tree connection line style
                // If points are on different rows, create vertical connection style
                if (iY != iY2) {
                    // Determine direction (up or down)
                    int mod = iY > iY2 ? -1 : 1;

                    // First vertical segment - directly from starting point down or up
                    int startOffset = 10;
                    int firstVerticalY = iY + startOffset * mod;

                    this.lPointsX.add(iX);
                    this.lPointsY.add(firstVerticalY);

                    // Calculate vertical position of horizontal segment
                    int horizontalY;
                    if (mod > 0) { // Downward
                        // Horizontal line at 3/4 between start and end points
                        horizontalY = iY + (int)(Math.abs(iY2 - iY) * 0.75) * mod;
                    } else { // Upward
                        horizontalY = iY + (int)(Math.abs(iY2 - iY) * 0.25) * mod;
                    }

                    // Extend vertical line to horizontal position
                    this.lPointsX.add(iX);
                    this.lPointsY.add(horizontalY);

                    // Create horizontal connection line
                    this.lPointsX.add(iX2);
                    this.lPointsY.add(horizontalY);

                    // Final vertical segment to reach target point
                    int endOffset = 10;
                    int lastVerticalY = iY2 - endOffset * mod;

                    this.lPointsX.add(iX2);
                    this.lPointsY.add(lastVerticalY);
                }
            } else {
                // Use original technology tree connection line style
                if (iY != iY2) {
                    int mod = iY > iY2 ? -1 : 1;
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 - 8);
                    this.lPointsY.add(iY);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 - 6);
                    this.lPointsY.add(iY + 1 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 - 4);
                    this.lPointsY.add(iY + 2 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 - 2);
                    this.lPointsY.add(iY + 4 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 - 1);
                    this.lPointsY.add(iY + 6 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50);
                    this.lPointsY.add(iY + 8 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50);
                    this.lPointsY.add(iY2 - 8 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 + 1);
                    this.lPointsY.add(iY2 - 6 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 + 2);
                    this.lPointsY.add(iY2 - 4 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 + 4);
                    this.lPointsY.add(iY2 - 2 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 + 6);
                    this.lPointsY.add(iY2 - 1 * mod);
                    this.lPointsX.add(iX2 - TechnologyTree.iTechnologyWidth / 2 - 50 + 8);
                    this.lPointsY.add(iY2);
                }
            }

            // Add target point
            this.lPointsX.add(iX2);
            this.lPointsY.add(iY2);

            // Create Vector2 objects for path rendering
            for(int i = 0; i < this.lPointsX.size(); i++) {
                this.nPath.add(new Vector2(0.0F, 0.0F));
            }
        }
    }
}

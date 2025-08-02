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

import aoc.kingdoms.lukasz.menusInGame.config.TreeStyleConfigManager;
import aoc.kingdoms.lukasz.textures.Image;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class InGame_MissionTree
        extends Menu {
    public static SparksAnimation sparksAnimation = new SparksAnimation();
    protected static final int ANIMATION_TIME = 60;
    public static long lTime = 0L;
    public int iMapPosY = 0;
    public List<TechLine> lines = new ArrayList<TechLine>();
    public int iLinesSize = 0;

    // Configuration manager instance
    private static TreeStyleConfigManager configManager = TreeStyleConfigManager.getInstance();

    // Fixed background image cache
    private static Image fixedBackgroundImage = null;
    private static String loadedBackgroundPath = "";
    private static boolean backgroundLoadFailed = false;

    // Static method to reload connection line style configuration
    public static void reloadConnectionStyleConfig() {
        configManager.reloadConfigurations();
        // Reload fixed background if configuration changed
        TreeStyleConfigManager.MissionTreeConfig config = configManager.getMissionTreeConfig();
        if (config.enableFixedBackground && !config.fixedBackgroundPath.equals(loadedBackgroundPath)) {
            loadFixedBackgroundImage(config.fixedBackgroundPath);
        }
    }

    /**
     * Load fixed background image for mission tree
     * @param imagePath Path to the background image
     */
    private static void loadFixedBackgroundImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return;
        }

        // Check if image is already loaded
        if (imagePath.equals(loadedBackgroundPath) && fixedBackgroundImage != null) {
            return;
        }

        // Dispose previous image if exists
        if (fixedBackgroundImage != null) {
            fixedBackgroundImage.dispose();
            fixedBackgroundImage = null;
        }

        try {
            // Load the background image using ImageManager
            fixedBackgroundImage = new Image(ImageManager.loadTexture(imagePath), TextureFilter.Linear, TextureWrap.ClampToEdge);
            loadedBackgroundPath = imagePath;
            backgroundLoadFailed = false;
            System.out.println("InGame_MissionTree: Successfully loaded fixed background image: " + imagePath);
        } catch (Exception e) {
            System.err.println("InGame_MissionTree: Failed to load fixed background image: " + imagePath + ", Error: " + e.getMessage());
            fixedBackgroundImage = null;
            loadedBackgroundPath = "";
            backgroundLoadFailed = true;
        }
    }

    /**
     * Dispose fixed background image resources
     */
    public static void disposeFixedBackground() {
        if (fixedBackgroundImage != null) {
            fixedBackgroundImage.dispose();
            fixedBackgroundImage = null;
        }
        loadedBackgroundPath = "";
        backgroundLoadFailed = false;
    }

    /**
     * Draw fixed background image with proper scaling and positioning
     * @param oSB SpriteBatch for rendering
     * @param iTranslateX X translation offset
     * @param iTranslateY Y translation offset
     * @param config Mission tree configuration
     */
    private void drawFixedBackground(SpriteBatch oSB, int iTranslateX, int iTranslateY, TreeStyleConfigManager.MissionTreeConfig config) {
        if (fixedBackgroundImage == null) {
            return;
        }

        // Set opacity
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, config.fixedBackgroundOpacity));

        int drawX, drawY, drawWidth, drawHeight;

        if (config.fixedBackgroundScaled) {
            // Scale background to fit menu area
            if (config.fixedBackgroundCentered) {
                // Center and scale to fit menu area
                float scaleX = (float) this.getWidth() / (float) fixedBackgroundImage.getWidth();
                float scaleY = (float) this.getHeight() / (float) fixedBackgroundImage.getHeight();
                float scale = Math.min(scaleX, scaleY); // Maintain aspect ratio

                drawWidth = (int) (fixedBackgroundImage.getWidth() * scale);
                drawHeight = (int) (fixedBackgroundImage.getHeight() * scale);
                drawX = this.getPosX() + (this.getWidth() - drawWidth) / 2 + iTranslateX;
                drawY = this.getPosY() + (this.getHeight() - drawHeight) / 2 + iTranslateY;
            } else {
                // Scale to fill entire menu area
                drawX = this.getPosX() + iTranslateX;
                drawY = this.getPosY() + iTranslateY;
                drawWidth = this.getWidth();
                drawHeight = this.getHeight();
            }
        } else {
            // Use original image size
            if (config.fixedBackgroundCentered) {
                // Center image in menu area
                drawX = this.getPosX() + (this.getWidth() - fixedBackgroundImage.getWidth()) / 2 + iTranslateX;
                drawY = this.getPosY() + (this.getHeight() - fixedBackgroundImage.getHeight()) / 2 + iTranslateY;
            } else {
                // Position at top-left of menu area
                drawX = this.getPosX() + iTranslateX;
                drawY = this.getPosY() + iTranslateY;
            }
            drawWidth = fixedBackgroundImage.getWidth();
            drawHeight = fixedBackgroundImage.getHeight();
        }

        // Draw the background image
        fixedBackgroundImage.draw(oSB, drawX, drawY, drawWidth, drawHeight);

        // Reset color
        oSB.setColor(Color.WHITE);
    }

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
                    // Use the unlock status of the prerequisite mission
                    boolean requiredMissionUnlocked = MissionTree.haveUnlockedMission_Civ(Game.player.iCivID, Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission);
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeRow, requiredMissionUnlocked));
                }
                if (Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2 >= 0) {
                    // Use the unlock status of the second prerequisite mission
                    boolean requiredMission2Unlocked = MissionTree.haveUnlockedMission_Civ(Game.player.iCivID, Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2);
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).RequiredMission2).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * Game.getCiv((int)Game.player.iCivID).lMissions.get((int)i).TreeRow, requiredMission2Unlocked));
                }
            }
        } else {
            for (i = 0; i < MissionTree.iMissionsSize; ++i) {
                missionUnlocked = MissionTree.haveUnlockedMission(Game.player.iCivID, i);
                missionCanBeUnlocked = MissionTree.canRunMission(Game.player.iCivID, i);
                menuElements.add(new ButtonMissionTree(i, MissionTree.lMissions.get((int)i).ImageID, 100 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, missionUnlocked, missionCanBeUnlocked));
                if (MissionTree.lMissions.get((int)i).RequiredMission >= 0) {
                    // Use the unlock status of the prerequisite mission
                    boolean requiredMissionUnlocked = MissionTree.haveUnlockedMission(Game.player.iCivID, MissionTree.lMissions.get((int)i).RequiredMission);
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, requiredMissionUnlocked));
                }
                if (MissionTree.lMissions.get((int)i).RequiredMission2 >= 0) {
                    // Use the unlock status of the second prerequisite mission
                    boolean requiredMission2Unlocked = MissionTree.haveUnlockedMission(Game.player.iCivID, MissionTree.lMissions.get((int)i).RequiredMission2);
                    this.lines.add(new TechLine(i, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission2).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)MissionTree.lMissions.get((int)i).RequiredMission2).TreeRow, 100 + MissionTree.iMissionWidth / 2 + (MissionTree.iMissionWidth + 100) * MissionTree.lMissions.get((int)i).TreeColumn, 15 + MissionTree.iMissionHeight / 2 + (MissionTree.iMissionHeight + 15) * MissionTree.lMissions.get((int)i).TreeRow, requiredMission2Unlocked));
                }
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
        TreeStyleConfigManager.MissionTreeConfig config = configManager.getMissionTreeConfig();

        float fA = 1.0f;
        if (lTime + 60L >= CFG.currentTimeMillis) {
            fA = (float)(CFG.currentTimeMillis - lTime) / 60.0f;
        }

        // Draw gradient background if enabled and not using fixed background
        if (config.enableGradientBackground && !config.enableFixedBackground) {
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, config.gradientOpacity * fA));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
            ImageManager.getImage(Images.gradientVertical).draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG.r, Colors.COLOR_GRADIENT_BG.g, Colors.COLOR_GRADIENT_BG.b, 0.3f * fA));
            Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() - this.getTitle().getHeight() - CFG.BUTTON_HEIGHT2 / 2 + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2);
            Images.gradientXY.draw(oSB, iTranslateX, this.getPosY() + this.getHeight() + iTranslateY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT2 / 2, false, true);
        }
        oSB.setColor(Color.WHITE);
        if (lTime + 60L >= CFG.currentTimeMillis) {
            iTranslateY = iTranslateY - CFG.BUTTON_HEIGHT + (int)((float)CFG.BUTTON_HEIGHT * ((float)(CFG.currentTimeMillis - lTime) / 60.0f));
        }
        Renderer.drawBoxCorner(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getTitle().getHeight() + iTranslateY, this.getWidth(), this.getHeight() + this.getTitle().getHeight() + CFG.PADDING);
        ImageManager.getImage(Images.insideTechTree).draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() + CFG.PADDING, false, true);

        // Check if fixed background is enabled - but don't draw it here, draw it later after menu elements
        if (config.enableFixedBackground) {
            // Load fixed background image if needed
            if (!backgroundLoadFailed && (fixedBackgroundImage == null || !config.fixedBackgroundPath.equals(loadedBackgroundPath))) {
                loadFixedBackgroundImage(config.fixedBackgroundPath);
            }
        }

        // Handle dynamic background effects when fixed background is disabled
        if (!config.enableFixedBackground) {
            // Use dynamic background effects when fixed background is disabled

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

            // Draw background shader effects if enabled
            if (config.enableBackgroundShader) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, config.backgroundShaderOpacity));
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
        }
        // Draw additional gradient effects if enabled
        if (config.enableGradientBackground) {
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.25f));
            Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 1.0f));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1, false, true);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_BG_BLUE.r, Colors.COLOR_GRADIENT_BG_BLUE.g, Colors.COLOR_GRADIENT_BG_BLUE.b, 0.35f));
            Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() - 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
            ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4);
            Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), CFG.PADDING * 4, false, true);
        }

        // Draw sparks animation if enabled
        if (config.enableSparksAnimation) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, config.sparksOpacity));
            sparksAnimation.draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - Images.sparkHeight + iTranslateY, this.getWidth(), Images.sparkHeight);
        }

        // Draw fixed background image if available (after menu elements but before connection lines)
        if (config.enableFixedBackground && fixedBackgroundImage != null) {
            drawFixedBackground(oSB, iTranslateX, iTranslateY, config);
        }

        oSB.setColor(Color.WHITE);
        for (int i = 0; i < this.iLinesSize; ++i) {
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

            // Draw the inner line color based on mission status
            if (techLine.unlocked) {
                // Use gold color for unlocked paths
                Renderer.shapeDrawer.setColor(config.connectionUnlockedColor);
            } else {
                // Use darker gray for locked paths
                Renderer.shapeDrawer.setColor(config.connectionLockedColor);
            }

            Renderer.shapeDrawer.path(techLine.nPath, config.connectionInnerWidth, config.connectionJoinType, true);
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
        // Note: We don't dispose the fixed background here as it may be reused
        // The background will be disposed when the game shuts down or when explicitly called
    }

    public class TechLine {
        public boolean unlocked = false;
        public int iMissionID;
        private Array<Vector2> nPath = new Array<>();
        public List<Integer> lPointsX = new ArrayList<Integer>();
        public List<Integer> lPointsY = new ArrayList<Integer>();

        // Add menu boundary information for constraining path points
        private int menuWidth = 0;
        private int menuHeight = 0;

        public TechLine(int iMissionID, int iX, int iY, int iX2, int iY2, boolean unlocked) {
            this.iMissionID = iMissionID;
            this.unlocked = unlocked;

            // Record menu size for subsequent clipping
            this.menuWidth = InGame_MissionTree.this.getWidth();
            this.menuHeight = InGame_MissionTree.this.getHeight();

            // Add starting point
            this.lPointsX.add(iX);
            this.lPointsY.add(iY);

            if (TreeStyleConfigManager.getInstance().getMissionTreeConfig().useVerticalStyle) {
                // Use vertical mission tree connection line style
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
                // Use original mission tree connection line style
                if (iY != iY2) {
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

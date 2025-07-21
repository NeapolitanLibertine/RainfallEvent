//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.menu_element.button;

import aoc.kingdoms.lukasz.events.EventsManager;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.SoundsManager;
import aoc.kingdoms.lukasz.jakowski.Missions.MissionTree;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import aoc.kingdoms.lukasz.menu.Colors;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_Hover;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type_Image;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type_Line;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type_Text;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type_Text_Desc;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.MenuElement_HoverElement_Type_Title;
import aoc.kingdoms.lukasz.menusInGame.Info.InGame_Info;
import aoc.kingdoms.lukasz.textures.ImageManager;
import aoc.kingdoms.lukasz.textures.Images;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import team.rainfall.rfEvent.config.ConfigManager;

import java.util.ArrayList;
import java.util.List;

public class ButtonMissionTreeCiv extends Button {
    public int iMissionID;
    public int iImageID;
    public boolean missionUnlocked;
    public boolean missionCanBeUnlocked;

    public ButtonMissionTreeCiv(int iMissionID, int iImageID, int iPosX, int iPosY, boolean missionUnlocked, boolean missionCanBeUnlocked) {
        this.init(iMissionID, iImageID, iPosX, iPosY);
        this.missionUnlocked = missionUnlocked;
        this.missionCanBeUnlocked = missionCanBeUnlocked;
    }

    public void init(int iMissionID, int iImageID, int iPosX, int iPosY) {
        this.iMissionID = iMissionID;
        this.iImageID = iImageID;
        this.fontID = CFG.FONT_REGULAR;
        this.init(Game.getCiv(Game.player.iCivID).lMissions.get(iMissionID).Name, this.fontID, this.iTextPositionX, iPosX, iPosY, MissionTree.iMissionWidth, MissionTree.iMissionHeight, true, true, false, false);
        int tWMax = 0;

        while(this.iTextWidth >= this.getWidth() - CFG.PADDING * 2 && this.getText().length() > 5) {
            ++tWMax;
            if (tWMax >= 100) {
                break;
            }

            this.setText(this.getText().substring(0, Math.max(1, this.getText().length() - 3)) + ".");
        }

    }

    protected void drawButtonBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setShader(Renderer.shaderAlpha);

        try {
            MissionTree.missionImagesCivs.get(this.iImageID).getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            ImageManager.getImage(Images.missionMask).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY);
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        oSB.flush();
        oSB.setShader(Renderer.shaderDefault);
        int nH = CFG.PADDING * 4 + this.getTextHeight();
        if(!ConfigManager.INSTANCE.getConfigData().noMissionMask) {
            if (this.missionUnlocked) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG_GREEN.r, Colors.COLOR_NOTIFICATION_BG_GREEN.g, Colors.COLOR_NOTIFICATION_BG_GREEN.b, 0.7F));
                Images.gradientFull.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.5F));
                ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH, false, false);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.55F));
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH, false, false);
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), CFG.PADDING, false, false);
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - CFG.PADDING + iTranslateY, this.getWidth(), CFG.PADDING, false, true);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG_GREEN.r, Colors.COLOR_NOTIFICATION_BG_GREEN.g, Colors.COLOR_NOTIFICATION_BG_GREEN.b, 0.75F));
                Images.gradientFull.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), 1);
            } else {
                oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.7F));
                Images.gradientFull.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH);
                oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.5F));
                ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH, false, false);
                oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.55F));
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), nH, false, false);
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), CFG.PADDING, false, false);
                Images.gradientXY.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - CFG.PADDING + iTranslateY, this.getWidth(), CFG.PADDING, false, true);
                oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.75F));
                Images.gradientFull.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + iTranslateY, this.getWidth(), 1);
            }
        }
        oSB.setColor(new Color(1.0F, 1.0F, 1.0F, 0.2F));
        Images.gradientFull.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - nH + 1 + iTranslateY, this.getWidth(), 1);
        oSB.setColor(Color.WHITE);
        ImageManager.getImage(Images.missionOver).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY);
        oSB.setColor(Color.WHITE);
    }

    public int titleH() {
        return CFG.TEXT_HEIGHT + CFG.PADDING * 3;
    }

    protected Color getColor(boolean isActive) {
        if (this.missionUnlocked) {
            return Colors.getColorPositive(isActive, this.getIsHovered());
        } else if (this.missionCanBeUnlocked) {
            return !this.getIsHovered() && !isActive ? Colors.HOVER_GOLD : Colors.getColorTopStats2(isActive, this.getIsHovered());
        } else {
            return Colors.getColorTopStats2(isActive, this.getIsHovered());
        }
    }

    protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosX() + this.getWidth() / 2 - this.getTextWidth() / 2 + iTranslateX, this.getPosY() + this.getHeight() - CFG.PADDING * 2 - this.getTextHeight() + iTranslateY, this.getColor(isActive));
    }

    public void buildElementHover() {
        List<MenuElement_HoverElement> nElements = new ArrayList();
        List<MenuElement_HoverElement_Type> nData = new ArrayList();
        nData.add(new MenuElement_HoverElement_Type_Title(Images.missions, "", Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).Name, Colors.HOVER_GOLD, Game.lang.get("Mission") + (this.missionUnlocked ? ": " + Game.lang.get("Completed") : ""), "", Colors.HOVER_RIGHT));
        nElements.add(new MenuElement_HoverElement(nData));
        nData.clear();
        String sInner = "- ";
        boolean addType = true;
        if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.desc.isEmpty()) {
            nData.add(new MenuElement_HoverElement_Type_Text_Desc(Game.lang.get(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.desc), CFG.FONT_REGULAR_SMALL, Colors.HOVER_LEFT2));
            nElements.add(new MenuElement_HoverElement(nData));
            nData.clear();
            nData.add(new MenuElement_HoverElement_Type_Line());
            nElements.add(new MenuElement_HoverElement(nData));
            nData.clear();
        }

        try {
            for(int i = 0; i < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.size(); ++i) {
                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAnd.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("and") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOr.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("or") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersAndNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("andNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAnd.get(i).triggersOrNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("orNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }
            }

            addType = true;

            for(int i = 0; i < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.size(); ++i) {
                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("andNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAnd.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("and") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("andNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOr.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("or") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("andNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersAndNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("andNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("andNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersAndNot.get(i).triggersOrNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("orNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }
            }

            addType = true;

            for(int i = 0; i < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.size(); ++i) {
                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("or"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAnd.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("and") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("or"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOr.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("or") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("or"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersAndNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("andNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("or"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOr.get(i).triggersOrNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("orNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }
            }

            addType = true;

            for(int i = 0; i < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.size(); ++i) {
                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("orNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAnd.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("and") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("orNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOr.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("or") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("orNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersAndNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("andNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }

                for(int j = 0; j < Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.size(); ++j) {
                    if (!Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getText().isEmpty()) {
                        if (addType) {
                            addType = false;
                            nData.add(new MenuElement_HoverElement_Type_Text(Game.lang.get("orNot"), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(sInner + Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getText(), CFG.FONT_REGULAR_SMALL));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getText2(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                        nData.add(new MenuElement_HoverElement_Type_Text(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getText3(), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                        if (Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getImage() > 0) {
                            nData.add(new MenuElement_HoverElement_Type_Image(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).event.triggersOrNot.get(i).triggersOrNot.get(j).getImage(), CFG.PADDING, 0));
                        }

                        nData.add(new MenuElement_HoverElement_Type_Text(" (" + Game.lang.get("orNot") + ")", CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT3));
                        nElements.add(new MenuElement_HoverElement(nData));
                        nData.clear();
                    }
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        this.menuElementHover = new MenuElement_Hover(nElements);
    }

    public int getSFX() {
        return SoundsManager.SOUND_CLICK_TOP;
    }

    public int getCurrent() {
        return this.iMissionID;
    }

    public void actionElement() {
        if (MissionTree.canRunMission_Civ(Game.player.iCivID, this.iMissionID)) {
            InGame_Info.iCivID = Game.player.iCivID;
            InGame_Info.iCivID2 = 0;
            Game.menuManager.rebuildInGame_Info(Game.getCiv(Game.player.iCivID).lMissions.get(this.iMissionID).Name, Game.lang.get("Mission"));
            InGame_Info.imgID = Images.infoCrown;
            EventsManager.updateRandomProvinceID(Game.player.iCivID);
            Game.menuManager.setVisibleInGame_MissionTree(false);
            MissionTree.runMission_Civ(Game.player.iCivID, this.iMissionID);
        } else if (!MissionTree.canRunMission_PreviousMissions_Civ(Game.player.iCivID, this.iMissionID)) {
            Game.menuManager.addToast_Error(Game.lang.get("CompleteThePreviousMissionFirst"), Images.missions);
        } else if (MissionTree.haveUnlockedMission_Civ(Game.player.iCivID, this.iMissionID)) {
            Game.menuManager.addToast_Error(Game.lang.get("AlreadyUnlocked"), Images.missions);
        } else {
            Game.menuManager.addToast_Error(Game.lang.get("RequirementsNotMet"), Images.missions);
        }

    }
}

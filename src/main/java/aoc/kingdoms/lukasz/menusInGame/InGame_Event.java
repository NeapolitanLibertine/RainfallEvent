//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.menusInGame;

import aoc.kingdoms.lukasz.events.Event;
import aoc.kingdoms.lukasz.events.EventOption;
import aoc.kingdoms.lukasz.events.EventsManager;
import aoc.kingdoms.lukasz.events.outcome.EventOutcome;
import aoc.kingdoms.lukasz.events.outcome.EventOutcome_Tooltip;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GlyphLayout_Game;
import aoc.kingdoms.lukasz.jakowski.Missions.MissionTree;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import aoc.kingdoms.lukasz.jakowski.Steam.SteamAchievementsManager;
import aoc.kingdoms.lukasz.map.ResourcesManager;
import aoc.kingdoms.lukasz.menu.Colors;
import aoc.kingdoms.lukasz.menu.Menu;
import aoc.kingdoms.lukasz.menu.menuTitle.MenuTitleIMG_DoubleText;
import aoc.kingdoms.lukasz.menu_element.Empty;
import aoc.kingdoms.lukasz.menu_element.MenuElement;
import aoc.kingdoms.lukasz.menu_element.Status;
import aoc.kingdoms.lukasz.menu_element.button.ButtonGame_Value;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.*;
import aoc.kingdoms.lukasz.menu_element.textStatic.Text_Desc;
import aoc.kingdoms.lukasz.textures.ImageManager;
import aoc.kingdoms.lukasz.textures.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import team.rainfall.finality.FinalityLogger;
import team.rainfall.rfEvent.FontLoader;
import team.rainfall.rfEvent.RainfallDesc;
import team.rainfall.rfEvent.RainfallTitle;
import team.rainfall.rfEvent.config.ConfigManager;
import team.rainfall.rfEvent.config.EventLayoutConfig;
import team.rainfall.rfEvent.rfEventImages;

import java.util.ArrayList;
import java.util.List;

public class InGame_Event extends Menu {
    protected static final int ANIMATION_TIME = 60;
    public static long lTime = 0L;
    public Event event;
    public static int eventType = 0;
    public static int eventID = 0;
    public int imgWidth = 1;
    public int imgHeight = 1;
    public boolean madeDecision = false;
    private EventLayoutConfig layout = null;

    public InGame_Event(Event nEvent, int nEventType, int nEventID) {
        List<MenuElement> menuElements = new ArrayList<>();
        this.event = nEvent;
        eventType = nEventType;
        eventID = nEventID;

        if (event.super_event && event.musicName != null) {
            try {
                if (nEvent.layoutID == -1) {
                    nEvent.layoutID = ConfigManager.superLayoutID;
                }
                Game.soundsManager.loadNextMusic(event.musicName);
            } catch (Exception e) {
                CFG.exceptionStack(e);
            }
        }
        FinalityLogger.debug("rfEvent.test2 " + event.title);
        if (nEvent.layoutID == -1 && (eventType == 999 || eventType == 1000)) {
            FinalityLogger.debug("rfEvent.test1" + event.title);
            nEvent.layoutID = ConfigManager.missionLayoutID;
        }

        if (nEvent.layoutID == -1) {
            nEvent.layoutID = 0;
        }

        layout = ConfigManager.INSTANCE.getLayoutByID(nEvent.layoutID);
        int paddingLeft = CFG.PADDING * 2 + Images.boxTitleBORDERWIDTH;
        int titleHeight = ImageManager.getImage(Images.title600).getHeight();
        int menuWidth = ImageManager.getImage(Images.title600).getWidth();
        int menuX = CFG.BUTTON_WIDTH + Renderer.boxBGExtraY + CFG.PADDING;
        int menuY = ImageManager.getImage(Images.topStats).getHeight() + CFG.PADDING * 2 + ImageManager.getImage(Images.title600).getHeight();
        int buttonY = CFG.PADDING * 2;
        int buttonX = Images.boxTitleBORDERWIDTH;
        EventsManager.loadEventIMG(this.event.image);
        float fScale = 0;
        try {
            fScale = (float) (menuWidth - Images.boxTitleBORDERWIDTH * 2) / (float) EventsManager.eventIMG.getWidth();
            this.imgWidth = menuWidth - Images.boxTitleBORDERWIDTH * 2;
            this.imgHeight = (int) ((float) EventsManager.eventIMG.getHeight() * fScale);
            buttonY += this.imgHeight;
        } catch (Exception var16) {
            Exception ex = var16;
            CFG.exceptionStack(ex);
        }
        int px_text = 0;
        int px_button = 0;
        if (layout.pxMode) {
            px_text = (int) (layout.textY * fScale);
            px_button = (int) (layout.buttonY * fScale);
        }
        if (eventType != 2 && eventType != 5 && !event.no_text) {
            RainfallDesc desc = new RainfallDesc(Game.lang.get(this.event.desc), (int) (paddingLeft + menuWidth * layout.textX), (int) (buttonY * layout.textY) - px_text, (int) ((menuWidth - paddingLeft * 2) * layout.textWidth), layout.textBackground);
            menuElements.add(desc);
        } else {
            String sResource = "";
            String sPriceChange = "";

            try {
                sResource = ResourcesManager.getResourceName(this.event.options.get(0).outcome.get(0).getValue1());
                sPriceChange = CFG.getPrecision2(this.event.options.get(0).outcome.get(0).getValue2(), 10);
            } catch (Exception var15) {
                CFG.exceptionStack(var15);
            }

            if (!event.no_text) {
                RainfallDesc desc = new RainfallDesc(Game.lang.get(this.event.desc, sResource, sPriceChange), (int) (paddingLeft + menuWidth * layout.textX), (int) (buttonY * layout.textY) - px_text, (int) ((menuWidth - paddingLeft * 2) * layout.textWidth), layout.textBackground);
                menuElements.add(desc);
            }
        }
        if (!event.no_text && layout.textY >= 1f) {
            buttonY += menuElements.get(0).getHeight() + CFG.PADDING * 2;
        }
        buttonY = (int) (buttonY * layout.buttonY);
        if (layout.bottomLocate) {
            buttonY = imgHeight - px_button;
        }
        int tMenuHeight;

        for (tMenuHeight = 0; tMenuHeight < this.event.options.size(); ++tMenuHeight) {
            //Skip preprocessor option
            if (event.preprocessorID == tMenuHeight) {
                continue;
            }
            menuElements.add(new ButtonGame_Value(Game.lang.get(this.event.options.get(tMenuHeight).name), CFG.FONT_REGULAR, -1, (int) (paddingLeft + menuWidth * layout.buttonX), buttonY, (int) ((menuWidth - paddingLeft * 2) * layout.buttonWidth), true, tMenuHeight) {
                public void actionElement() {
                    Game.player.removeActiveEvent(InGame_Event.eventType, InGame_Event.eventID);
                    madeDecision = true;
                    if (InGame_Event.eventType == 999) {
                        MissionTree.takeMissionDecision(Game.player.iCivID, InGame_Event.eventID, this.getCurrent());
                    } else if (InGame_Event.eventType == 1000) {
                        MissionTree.takeMissionDecision_Civ(Game.player.iCivID, InGame_Event.eventID, this.getCurrent());
                        Game.player.currSituation.updateCurrentSituation();
                    } else {
                        EventsManager.takeEventDecision(Game.player.iCivID, InGame_Event.eventType, InGame_Event.eventID, this.getCurrent());
                        Game.player.currSituation.updateCurrentSituation();
                    }

                    Game.menuManager.rebuildInGame_Right();
                    Game.menuManager.setVisibleInGame_Event(false);
                    SteamAchievementsManager.unlockAchievement(SteamAchievementsManager.EVENT_RES);
                }

                public int getButtonBG() {
                    return layout.buttonTexture != null ? rfEventImages.getBtnImageID(layout.id) : Images.buttonGame;
                }

                public int getButtonBG_Active() {
                    return layout.buttonActiveTexture != null ? rfEventImages.getBtnActiveImageID(layout.id) : Images.buttonGameH;
                }

                public void buildElementHover() {
                    List<MenuElement_HoverElement> nElements = new ArrayList<>();
                    List<MenuElement_HoverElement_Type> nData = new ArrayList<>();
                    nData.add(new MenuElement_HoverElement_Type_TextTitle_BG(this.getText(), CFG.FONT_BOLD, Colors.HOVER_GOLD));
                    nElements.add(new MenuElement_HoverElement(nData));
                    nData.clear();
                    boolean hide = false;
                    for (EventOutcome eventOutcome : InGame_Event.this.event.options.get(this.getCurrent()).outcome) {
                        if (eventOutcome instanceof EventOutcome_Tooltip) {
                            EventOutcome_Tooltip toolTipOutcome = (EventOutcome_Tooltip) eventOutcome;
                            hide = toolTipOutcome.hideOutcomes;
                            nData.add(new MenuElement_HoverElement_Type_Text_Desc(toolTipOutcome.content));
                            nElements.add(new MenuElement_HoverElement(nData));
                            nData.clear();
                        }
                    }
                    try {
                        for (int i = 0; i < InGame_Event.this.event.options.get(this.getCurrent()).outcome.size(); ++i) {
                            if (InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringLeft() != null) {
                                nData.add(new MenuElement_HoverElement_Type_Text(InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringLeft(), CFG.FONT_REGULAR_SMALL));
                                if (InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringRight() != null) {
                                    nData.add(new MenuElement_HoverElement_Type_Text(InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringRight(), CFG.FONT_BOLD_SMALL, Colors.HOVER_GOLD));
                                }

                                if (InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getImage() >= 0) {
                                    nData.add(new MenuElement_HoverElement_Type_Image(InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getImage(), CFG.PADDING, InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringRight2(InGame_Event.this.event.options.get(this.getCurrent()).bonus_duration) != null ? CFG.PADDING : 0));
                                }

                                if (InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringRight2(InGame_Event.this.event.options.get(this.getCurrent()).bonus_duration) != null) {
                                    nData.add(new MenuElement_HoverElement_Type_Text(InGame_Event.this.event.options.get(this.getCurrent()).outcome.get(i).getStringRight2(InGame_Event.this.event.options.get(this.getCurrent()).bonus_duration), CFG.FONT_REGULAR_SMALL, Colors.HOVER_RIGHT2));
                                }
                                if (!hide) {
                                    nElements.add(new MenuElement_HoverElement(nData));
                                }
                                nData.clear();
                            }
                        }
                    } catch (Exception var4) {
                        Exception ex = var4;
                        CFG.exceptionStack(ex);
                    }

                    this.menuElementHover = new MenuElement_Hover(nElements, nElements.size() == 1);
                }
            });
            buttonY += menuElements.get(menuElements.size() - 1).getHeight() + CFG.PADDING;
        }

        buttonY = 0;
        tMenuHeight = 0;

        int inProvinceID;
        for (inProvinceID = menuElements.size(); tMenuHeight < inProvinceID; ++tMenuHeight) {
            if (buttonY < menuElements.get(tMenuHeight).getPosY() + menuElements.get(tMenuHeight).getHeight() + CFG.PADDING * 2) {
                buttonY = menuElements.get(tMenuHeight).getPosY() + menuElements.get(tMenuHeight).getHeight() + CFG.PADDING * 2;
            }
        }

        tMenuHeight = Math.min(buttonY, CFG.GAME_HEIGHT - menuY - CFG.PADDING * 2);
        menuElements.add(new Empty(0, 0, menuWidth, Math.max(buttonY, tMenuHeight)));
        inProvinceID = Game.getCiv(Game.player.iCivID).eventProvinceID;
        if (inProvinceID < 0 && Game.getCiv(Game.player.iCivID).getCapitalProvinceID() >= 0) {
            inProvinceID = Game.getCiv(Game.player.iCivID).getCapitalProvinceID();
        } else if (Game.getCiv(Game.player.iCivID).getNumOfProvinces() > 0) {
            inProvinceID = Game.getCiv(Game.player.iCivID).getProvinceID(Game.oR.nextInt(Game.getCiv(Game.player.iCivID).getNumOfProvinces()));
        }

        inProvinceID = Math.max(0, inProvinceID);
        if (event.execPosition >= 0) {
            inProvinceID = event.execPosition;
        }
        if (layout.showTitle) {
            this.initMenu(new MenuTitleIMG_DoubleText(Game.lang.get(this.event.title), Game.lang.get("EventInX", Game.getProvince(inProvinceID).getProvinceName()), true, false, Images.title600) {
                public long getTime() {
                    return InGame_Event.lTime;
                }
            }, CFG.GAME_WIDTH / 2 - menuWidth / 2, CFG.GAME_HEIGHT / 5, menuWidth, tMenuHeight, menuElements, false, true);
        } else {
            this.initMenu(new MenuTitleIMG_DoubleText("", "", true, false, Images.title600) {
                @Override
                public void drawGradient(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, Status titleStatus) {

                }

                @Override
                public void drawText(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, Status titleStatus) {

                }

                @Override
                public void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, Status titleStatus) {
                    if (titleStatus == Status.HOVERED || titleStatus == Status.ACTIVE) {
                        oSB.setColor(new Color(1f, 1f, 1f, 0.15f));
                        Images.pix.draw(oSB, nPosX, nPosY - 1, nWidth, 1);
                        Images.pix.draw(oSB, nPosX, nPosY - this.getHeight(), nWidth, 1);
                    }
                }

                public long getTime() {
                    return InGame_Event.lTime;
                }
            }, CFG.GAME_WIDTH / 2 - menuWidth / 2, CFG.GAME_HEIGHT / 5, menuWidth, tMenuHeight, menuElements, false, true);

        }
        this.drawScrollPositionAlways = false;
    }

    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean menuIsActive, Status titleStatus) {
        if (event.important) {
            Game.gameThread.play = false;
        }
        if (lTime + 60L >= CFG.currentTimeMillis) {
            iTranslateY = iTranslateY - CFG.BUTTON_HEIGHT + (int) ((float) CFG.BUTTON_HEIGHT * ((float) (CFG.currentTimeMillis - lTime) / 60.0F));
        }
        int height2 = !layout.showTitle ? this.getTitle().getHeight() : 0;
        if (!event.no_background) {
            Renderer.drawBoxCorner(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getTitle().getHeight() + iTranslateY, this.getWidth(), this.getHeight() + this.getTitle().getHeight() + CFG.PADDING);
            Renderer.drawMenusBox(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidth(), this.getHeight() + CFG.PADDING, false, Images.insideTop600, Images.insideBot600);
        }
        oSB.setColor(Color.WHITE);

        try {
            EventsManager.eventIMG.draw(oSB, this.getPosX() + Images.boxTitleBORDERWIDTH + iTranslateX, this.getPosY() + iTranslateY - height2, this.imgWidth, this.imgHeight);
            if (!event.no_background) {
                Renderer.drawBox(oSB, Images.eventCorner, this.getPosX() + Images.boxTitleBORDERWIDTH + iTranslateX, this.getPosY() + iTranslateY, this.imgWidth, this.imgHeight, 1.0F);
                oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.5F));
                ImageManager.getImage(Images.gradientVertical).draw(oSB, this.getPosX() + Images.boxTitleBORDERWIDTH + iTranslateX, this.getPosY() + this.imgHeight + iTranslateY, this.imgWidth, CFG.PADDING * 2);
                Images.gradientXY.draw(oSB, this.getPosX() + Images.boxTitleBORDERWIDTH + iTranslateX, this.getPosY() + this.imgHeight + iTranslateY, this.imgWidth, CFG.PADDING * 2, false, true);
            }
            oSB.setColor(Color.WHITE);
        } catch (Exception ignored) {
        }
        if (layout.customTitle) {
            Renderer.glyphLayout.setText(Renderer.fontMain.get(FontLoader.fontID), Game.lang.get(this.event.title));
            Renderer.drawText(oSB, FontLoader.fontID, Game.lang.get(this.event.title), layout.titleScale, (int) (this.getPosX() - (Renderer.glyphLayout.getWidth() / 2) + iTranslateX + imgWidth * layout.titleX), (int) (this.getPosY() + (this.imgHeight * layout.titleY) + iTranslateY), Color.BLACK);
        }
        super.draw(oSB, iTranslateX, iTranslateY, menuIsActive, titleStatus);
    }

    public void setVisible(boolean visible) {
        if (!madeDecision && !visible && event.important) {
            Game.menuManager.addToast_Error(Game.lang.get("NotAllowedToCloseBeforeDecide"));
            return;
        }
        super.setVisible(visible);
        lTime = CFG.currentTimeMillis;
    }
}

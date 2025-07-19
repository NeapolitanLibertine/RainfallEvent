package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.menu_element.textStatic.Text_Desc;

public class RainfallDesc extends Text_Desc {
    public RainfallDesc(String sText, int iPosX, int iPosY, int iWidth, int nFontID,boolean extraRender) {
        super(sText, iPosX, iPosY, iWidth, nFontID);
        try {
            this.getClass().getField("extraRender").set(this,extraRender);
        } catch (Exception ignored) {

        }
    }
    public RainfallDesc(String sText, int iPosX, int iPosY, int iWidth,boolean extraRender) {
        super(sText, iPosX, iPosY, iWidth);
        try {
            this.getClass().getField("extraRender").set(this,extraRender);
        } catch (Exception ignored) {

        }
    }
}

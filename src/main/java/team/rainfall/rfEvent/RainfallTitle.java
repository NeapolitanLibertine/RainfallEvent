package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import aoc.kingdoms.lukasz.menu_element.textStatic.Text_Static;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RainfallTitle extends Text_Static {
    public float scale = 1f;

    public RainfallTitle(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    public RainfallTitle(String sText, int iPosX, int iPosY, int fontID,int width) {
        super(sText, iPosX, iPosY, fontID);
        setWidth(width);
    }

    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadowScale(oSB, this.fontID, this.sText, this.getPosX() + (iTextWidth / 2) + iTranslateX, this.getPosY() + (this.getHeight() - CFG.TEXT_HEIGHT) / 2 + iTranslateY, this.getColor(isActive),scale);
    }
}

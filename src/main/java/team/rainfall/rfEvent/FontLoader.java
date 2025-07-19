package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.FileManager;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Renderer.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import team.rainfall.finality.FinalityLogger;

public class FontLoader {
    public static int fontID = -1;
    public static void loadFont(){
        if(fontID != -1){
            return;
        }
        if(!Game.lang.get("Font_rfEvent").equals("Font_rfEvent")){
            FinalityLogger.debug("Success to load rfEvent font");
            loadFont(Game.lang.get("Font_rfEvent"),"abcdefghijklmnopqrstuvwxyz1234567890!?",48);
        }else {
            FinalityLogger.warn("Failed to load rfEvent font +"+Game.lang.get("Font_rfEvent"));
            loadFont(Game.lang.get("font"),"abcdefghijklmnopqrstuvwxyz1234567890!?",48);
        }
    }
    public static final void loadFont(String sFont, String charset, int fontSize) {
        FreeTypeFontGenerator generator = null;
        if (fontSize < 0) {
            fontSize = (int)((float) GameValues.value.DEFAULT_FONT_SIZE * CFG.GUI_SCALE);
        }

        try {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        } catch (Exception var5) {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/Roboto-Bold.ttf"));
        }

        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = Math.max(fontSize, 6);
        params.color = Color.WHITE;
        params.incremental = true;
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        Renderer.fontMain.add(generator.generateFont(params));
        fontID = Renderer.fontMainSize;
        Renderer.fontMainSize = Renderer.fontMain.size();
    }
}

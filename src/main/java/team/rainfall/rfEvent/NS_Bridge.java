package team.rainfall.rfEvent;

import java.lang.reflect.Method;

public class NS_Bridge {
    public static Method applyNS = null;
    public static Method removeNS = null;
    static {
        try {
            applyNS = Class.forName("team.rainfall.fontFix.NationalSpiritManager").getMethod("applyNS",int.class,String.class);
            removeNS = Class.forName("team.rainfall.fontFix.NationalSpiritManager").getMethod("removeNS",int.class,String.class);
        } catch (NoSuchMethodException | ClassNotFoundException ignored) {

        }
    }
}

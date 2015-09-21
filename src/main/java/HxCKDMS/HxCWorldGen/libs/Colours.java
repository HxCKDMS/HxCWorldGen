package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;
import HxCKDMS.HxCCore.api.Utils.LogHelper;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Colours {
    @Config.Map
    public static HashMap<String, String> Colours = new LinkedHashMap<>();

    static {
        Colours.put("Copper", "174, 105, 41");
        Colours.put("Tin", "220, 230, 255");
        Colours.put("Silver", "200, 240, 255");
        Colours.put("Lead", "160, 150, 160");
        Colours.put("Nickel", "200, 200, 152");
        Colours.put("Chromium", "210, 250, 255");
        Colours.put("Aluminum", "235, 235, 240");
        Colours.put("Ilmenite", "133, 95, 90");
        Colours.put("Platinum", "160, 250, 255");
        Colours.put("Peridot", "0, 160, 120");
        Colours.put("Sapphire", "30, 120, 200");
        Colours.put("Ruby", "200, 10, 10");
        Colours.put("Rutile", "100, 56, 18");
        Colours.put("Zinc", "200, 200, 190");
        Colours.put("Titanium", "190, 210, 215");
        Colours.put("Zircon", "150, 140, 130");
        Colours.put("Zirconia", "190, 195, 198");
        Colours.put("Steel", "140, 145, 150");
        Colours.put("Bronze", "160, 105, 61");
        Colours.put("Brass", "181, 166, 66");
        Colours.put("Diamond", "200, 200, 250");
        Colours.put("Emerald", "0, 255, 0");
        Colours.put("Iron", "180, 180, 180");
        Colours.put("Gold", "255, 215, 0");
        Colours.put("Coal", "40, 40, 40");
        Colours.put("Charcoal", "70, 70, 70");
        Colours.put("Nether", "120, 40, 0");
        Colours.put("Sulfur", "255, 240, 0");
        Colours.put("ERROR", "255, 0, 0");
    }

    public static int[] getColours(String key) {
        key = key.replace("Chunk", "").replace("Nugget", "").replace("Fragment", "")
                .replace("Ore", "").replace("Block", "").replace("Dust", "")
                .replace("Ingot", "").replace("Gem", "").replace("tile.null", "ERROR")
                .replace("Zirconium", "Zircon").trim();
        String[] tmp;
        try {
            tmp = Colours.get(key).split(", ");
        } catch (Exception ignored) {
            LogHelper.warn("Colour for " + key + " not found, please report this to mod author and add it to Config/HxCKDMS/HxCWorldGen_Colours.cfg", Reference.MOD_NAME);
            tmp = Colours.get("ERROR").split(", ");
        }
        int[] tmp2 = new int[3];
        for (int i = 0; i < 3; i++)
            tmp2[i] = Integer.parseInt(tmp[i]);

        return tmp2;
    }

    public static int getColourFromRGB(int[] rgb) {
        return getColourFromRGB(rgb[0], rgb[1], rgb[2]);
    }

    public static int getColourFromRGB(int red, int green, int blue) {
        return new Color(red, green, blue).getRGB();
    }

    public static int getColour(String name) {
        return getColourFromRGB(getColours(name));
    }
}

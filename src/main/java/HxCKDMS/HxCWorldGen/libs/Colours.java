package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;

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
        Colours.put("Aluminium", "235, 235, 240");
        Colours.put("Ilmenite", "133, 95, 90");
        Colours.put("Platinum", "160, 250, 255");
        Colours.put("Aventurine", "0, 160, 120");
        Colours.put("Sapphire", "30, 120, 200");
        Colours.put("Ruby", "200, 10, 10");
        Colours.put("Rutile", "100, 56, 18");
        Colours.put("Titanium", "190, 210, 215");
        Colours.put("Zircon", "150, 140, 130");
        Colours.put("Zirconia", "190, 195, 198");
        Colours.put("Steel", "140, 145, 150");
        Colours.put("Bronze", "170, 160, 30");
        Colours.put("Zinc", "200, 200, 190");
        Colours.put("Brass", "170, 220, 100");
    }

    public static int[] getColours(String key) {
        key = key.replace("Chunk", "").replace("Nugget", "").replace("Fragment", "")
                .replace("Ore", "").replace("Block", "").replace("Dust", "")
                .replace("Ingot", "").replace("Gem", "").trim();

        String[] tmp = Colours.get(key).split(", ");
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

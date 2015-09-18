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
    }

    public static int[] getColours(String key) {
        String[] tmp = Colours.get(key).split(", ");
        int[] tmp2 = new int[3];
        for (int i = 0; i < 3; i++) {
            tmp2[i] = Integer.parseInt(tmp[i]);
        }
        return tmp2;
    }

    public static int getColourFromRGB(int[] rgb) {
        return getColourFromRGB(rgb[0], rgb[1], rgb[2]);
    }

    public static int getColourFromRGB(int red, int green, int blue) {
        return new Color(red, green, blue).getRGB();
    }

    public static int[] oreColour(int meta) {
        switch (meta) {
            case 1 : return getColours("Tin");
            case 2 : return getColours("Silver");
            case 3 : return getColours("Lead");
            case 4 : return getColours("Nickel");
            case 5 : return getColours("Chromium");
            case 6 : return getColours("Aluminium");
            case 7 : return getColours("Ilmenite");
            case 8 : return getColours("Platinum");
            case 9 : return getColours("Aventurine");
            case 10 : return getColours("Ruby");
            case 11 : return getColours("Sapphire");
            case 12 : return getColours("Rutile");
            case 13 : return getColours("Zircon");
            case 14 : return getColours("Titanium");
            default : return getColours("Copper");
        }
    }
    public static int[] resourceColour(int meta) {
        switch (meta) {
            case 1 : return getColours("Tin");
            case 2 : return getColours("Silver");
            case 3 : return getColours("Lead");
            case 4 : return getColours("Nickel");
            case 5 : return getColours("Chromium");
            case 6 : return getColours("Aluminium");
            case 7 : return getColours("Titanium");
            case 8 : return getColours("Platinum");
            case 9 : return getColours("Aventurine");
            case 10 : return getColours("Ruby");
            case 11 : return getColours("Sapphire");
            case 12 : return getColours("Zircon");
            case 13 : return getColours("Zirconia");
            default : return getColours("Copper");
        }
    }
}

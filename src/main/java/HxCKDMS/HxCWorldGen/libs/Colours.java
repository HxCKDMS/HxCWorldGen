package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;

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
        Colours.put("Aluminium", "250, 250, 255");
        Colours.put("Ilmenite", "133, 95, 90");
        Colours.put("Platinum", "160, 250, 255");
        Colours.put("Aventurine", "0, 160, 120");
        Colours.put("Sapphire", "200, 10, 10");
        Colours.put("Ruby", "30, 120, 200");
        Colours.put("Rutile", "100, 56, 18");
        Colours.put("Titanium", "190, 210, 215");
        Colours.put("Zircon", "150, 140, 130");
        Colours.put("Zirconia", "190, 195, 198");
    }

    private static int[] getColours(String key) {
        String[] tmp = Colours.get(key).split(", ");
        int[] tmp2 = new int[3];
        for (int i = 0; i < 3; i++) {
            tmp2[i] = Integer.parseInt(tmp[i]);
        }
        return tmp2;
    }

    public static int[] oreColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = getColours("Tin"); break;
            case 2 : colours = getColours("Silver"); break;
            case 3 : colours = getColours("Lead"); break;
            case 4 : colours = getColours("Nickel"); break;
            case 5 : colours = getColours("Chromium"); break;
            case 6 : colours = getColours("Aluminium"); break;
            case 7 : colours = getColours("Ilmenite"); break;
            case 8 : colours = getColours("Platinum"); break;
            case 9 : colours = getColours("Aventurine"); break;
            case 10 : colours = getColours("Sapphire"); break;
            case 11 : colours = getColours("Ruby"); break;
            case 12 : colours = getColours("Rutile"); break;
            default : colours = getColours("Copper"); break;
        }
        return colours;
    }
    public static int[] blockColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = getColours("Tin"); break;
            case 2 : colours = getColours("Silver"); break;
            case 3 : colours = getColours("Lead"); break;
            case 4 : colours = getColours("Nickel"); break;
            case 5 : colours = getColours("Chromium"); break;
            case 6 : colours = getColours("Aluminium"); break;
            case 7 : colours = getColours("Ilmenite"); break;
            case 8 : colours = getColours("Platinum"); break;
            case 9 : colours = getColours("Aventurine"); break;
            case 10 : colours = getColours("Sapphire"); break;
            case 11 : colours = getColours("Ruby"); break;
            case 12 : colours = getColours("Zircon"); break;
            default : colours = getColours("Copper"); break;
        }
        return colours;
    }
    public static int[] resourceColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = getColours("Tin"); break;
            case 2 : colours = getColours("Silver"); break;
            case 3 : colours = getColours("Lead"); break;
            case 4 : colours = getColours("Nickel"); break;
            case 5 : colours = getColours("Chromium"); break;
            case 6 : colours = getColours("Aluminium"); break;
            case 7 : colours = getColours("Titanium"); break;
            case 8 : colours = getColours("Platinum"); break;
            case 9 : colours = getColours("Aventurine"); break;
            case 10 : colours = getColours("Sapphire"); break;
            case 11 : colours = getColours("Ruby"); break;
            case 12 : colours = getColours("Zircon"); break;
            case 13 : colours = getColours("Zirconia"); break;
            default : colours = getColours("Copper"); break;
        }
        return colours;
    }
}

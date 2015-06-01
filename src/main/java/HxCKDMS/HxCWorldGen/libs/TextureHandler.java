package HxCKDMS.HxCWorldGen.libs;

public class TextureHandler {
    public static String mod = Reference.RESOURCE_LOCATION;
    public static String items = mod+"textures/items/";
    public static String blocks = mod+"textures/blocks/";
    public static String a = "16";
    public static String b = "32";
    public static String c = "64";
    public static String size;
    private static boolean doSpecial;

    public static void preInit() {
        switch (Config.ResourceSize) {
            case 16 : size = a; break;
            case 32 : size = b; break;
            case 64 : size = c; break;
            default : size = ""; break;
        }
        if (size.isEmpty()) {
            doSpecial = true;
        } else {
            doSpecial = false;
        }
    }

    public static String getTexturePath(String resource) {
        if (resource.equals("ore")) {
            if (doSpecial) size = "16";
            return mod + size + resource;
        }
        if (resource.equals("ingot")) {
            /*if (doSpecial) */return "minecraft:iron_ingot";
            /*return mod + size + resource;*/
        }
        if (resource.equals("gem")) {
            /*if (doSpecial)*/ return "minecraft:diamond";
            /*return mod + size + resource;*/
        }
        if (resource.equals("metalBlock")) {
            if (doSpecial) return "minecraft:iron_block";
            return mod + size + resource;
        }
        if (resource.equals("gemBlock")) {
            if (doSpecial) return "minecraft:emerald_block";
            return mod + size + resource;
        }
        return "minecraft:cake_top";
    }

    public static boolean isDoSpecial () {
        return doSpecial;
    }
}
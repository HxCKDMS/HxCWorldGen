package HxCKDMS.HxCWorldGen.libs;

public class Reference {
    public static final String MOD_NAME = "HxC World Gen";
    public static final String MOD_ID = "hxcworldgen";
    public static final String RESOURCE_LOCATION = MOD_ID.toLowerCase() + ":";
    public static final String VERSION = "2.0.0";
    public static final String DEPENDENCIES = "required-after:hxccore@[2.0.0,)";
    public static final String CLIENT_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ServerProxy";

    public static int ORE_RENDER_ID = 0;
    public static int BLOCK_RENDER_ID = 1;
}
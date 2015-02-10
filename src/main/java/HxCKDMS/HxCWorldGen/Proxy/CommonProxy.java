package HxCKDMS.HxCWorldGen.Proxy;

import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("unused")
public abstract class CommonProxy {
    public void init(){}

    public Side getSide(){
        return this instanceof  ClientProxy ? Side.CLIENT : Side.SERVER;
    }
}

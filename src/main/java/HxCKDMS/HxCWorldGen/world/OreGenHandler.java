package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.Config;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGenHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(!(chunkGenerator instanceof ChunkProviderEnd) && !(chunkGenerator instanceof ChunkProviderHell)){
            for (int oreID = 0; oreID < 12; oreID++) {
                for(int i = 0; i < 5; i++){
                    int randPosX = (chunkX*16) + random.nextInt(16);
                    int randPosY = random.nextInt(50);
                    int randPosZ = (chunkZ*16) + random.nextInt(16);
                    getOre(oreID).generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
    }

    public WorldGenMinable getOre (int ore) {
        String oreString; int nodeSize;
        switch (ore) {
            case 1 : oreString = Config.Tin; nodeSize = Config.TinNodeSize * Config.OreNodeMultiplier; break;
            case 2 : oreString = Config.Silver; nodeSize = Config.SilverNodeSize * Config.OreNodeMultiplier; break;
            case 3 : oreString = Config.Lead; nodeSize = Config.LeadNodeSize * Config.OreNodeMultiplier; break;
            case 4 : oreString = Config.Nickel; nodeSize = Config.NickelNodeSize * Config.OreNodeMultiplier; break;
            case 5 : oreString = Config.Chromium; nodeSize = Config.ChromiumNodeSize * Config.OreNodeMultiplier; break;
            case 6 : oreString = Config.Aluminium; nodeSize = Config.AluminiumNodeSize * Config.OreNodeMultiplier; break;
            case 7 : oreString = Config.Titanium; nodeSize = Config.TitaniumNodeSize * Config.OreNodeMultiplier; break;
            case 8 : oreString = Config.Platinum; nodeSize = Config.PlatinumNodeSize * Config.OreNodeMultiplier; break;
            case 9 : oreString = Config.Aventurine; nodeSize = Config.AventurineNodeSize * Config.OreNodeMultiplier; break;
            case 10 : oreString = Config.Sapphire; nodeSize = Config.SapphireNodeSize * Config.OreNodeMultiplier; break;
            case 11 : oreString = Config.Ruby; nodeSize = Config.RubyNodeSize * Config.OreNodeMultiplier; break;
            case 12 : oreString = Config.Rutile; nodeSize = Config.RutileNodeSize * Config.OreNodeMultiplier; break;
            default : oreString = Config.Copper; nodeSize = Config.CopperNodeSize * Config.OreNodeMultiplier; break;
        }
        Block oreBlock = Block.getBlockFromName(oreString);
        int blockMeta = Integer.getInteger(oreString.substring(oreString.length()-2, oreString.length()-1).replaceAll(":", ""));
        return new WorldGenMinable(oreBlock, blockMeta, nodeSize, Blocks.stone);
    }
}

package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.libs.Config;
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
                for (int i = 0; i < 5; i++) {
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
            case 1 : oreString = Config.Tin; break;
            case 2 : oreString = Config.Silver; break;
            case 3 : oreString = Config.Lead; break;
            case 4 : oreString = Config.Nickel; break;
            case 5 : oreString = Config.Chromium; break;
            case 6 : oreString = Config.Aluminium; break;
            case 7 : oreString = Config.Titanium; break;
            case 8 : oreString = Config.Platinum; break;
            case 9 : oreString = Config.Aventurine; break;
            case 10 : oreString = Config.Sapphire; break;
            case 11 : oreString = Config.Ruby; break;
            case 12 : oreString = Config.Rutile; break;
            default : oreString = Config.Copper; break;
        }
        oreString = oreString.replace("<", "").replace(">", "");
        String[] strings = oreString.split(":");
        nodeSize = Integer.parseInt(Config.NodeSizes[ore]) * Config.OreNodeMultiplier;
        int blockMeta = Integer.parseInt(strings[2]);
        Block oreBlock = Block.getBlockFromName(strings[0] + ":" + strings[1]);
        return new WorldGenMinable(oreBlock, blockMeta, nodeSize, Blocks.stone);
    }
}

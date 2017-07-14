package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGenHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(Configurations.validDimensions.contains(world.provider.dimensionId)){
            for (String ore : Configurations.ORES) {
//                LogHelper.info(ore + " attempting to spawn", Reference.MOD_NAME);
                for (int i = 0; i < (world.provider.dimensionId == 0 ? Configurations.Ores.get(ore).nodeRarity : Configurations.Ores.get(ore).nodeRarity*2); i++) {
                    int randPosX = (chunkX*16) + random.nextInt(16);
                    int randPosY = random.nextInt(Configurations.specialDimensions.contains(world.provider.dimensionId) ? 255 : Configurations.Ores.get(ore).nodeDepth);
                    int randPosZ = (chunkZ*16) + random.nextInt(16);
                    getOre(ore, world.provider.dimensionId).generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
    }

    public WorldGenMinable getOre (String ore, int dim) {
        String oreString = Configurations.Ores.get(ore).oreBlockID;
        int nodeSize = Configurations.Ores.get(ore).nodeSize;
        String[] strings = oreString.split(":");
        nodeSize *= Configurations.OreNodeSizeMultiplier;
        nodeSize *= Configurations.specialDimensions.contains(dim) ? 1.25 : 1;
        int blockMeta = Configurations.Ores.get(ore).oreMetadata;
        Block oreBlock = Block.getBlockFromName(strings[0] + ":" + strings[1]);
        Block block = dim == -1 ? Blocks.netherrack : (dim == 1 ? Blocks.end_stone : Blocks.stone);
        return new WorldGenMinable(oreBlock, blockMeta, nodeSize, block);
    }
}

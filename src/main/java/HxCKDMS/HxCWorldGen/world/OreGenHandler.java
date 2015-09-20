package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.Reference;
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
        if((Configurations.allowEndGeneration && world.provider.dimensionId == -1) || (Configurations.allowNetherGeneration && world.provider.dimensionId == 1) || world.provider.dimensionId == 0){
            for (String ore : Reference.ORES) {
                for (int i = 0; i < Configurations.oreRarity.get(ore); i++) {
                    int randPosX = (chunkX*16) + random.nextInt(16);
                    int randPosY = random.nextInt(Configurations.oreDepth.get(ore));
                    int randPosZ = (chunkZ*16) + random.nextInt(16);
                    getOre(ore, world.provider.dimensionId).generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
    }

    public WorldGenMinable getOre (String ore, int dim) {
        String oreString = Configurations.Ores.get(ore); int nodeSize;
        String[] strings = oreString.split(":");
        nodeSize = Configurations.nodeSizes.get(ore) * Configurations.OreNodeSizeMultiplier;
        int blockMeta = strings.length == 3 ? Integer.parseInt(strings[2]) : 0;
        Block oreBlock = Block.getBlockFromName(strings[0] + ":" + strings[1]);
        Block block = dim == 0 ? Blocks.stone : (dim == 1 ? Blocks.end_stone : Blocks.netherrack);
        return new WorldGenMinable(oreBlock, blockMeta, nodeSize, block);
    }
}

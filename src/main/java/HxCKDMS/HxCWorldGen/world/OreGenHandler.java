package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.Config;
import HxCKDMS.HxCWorldGen.registry.BlockRegistry;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGenHandler implements IWorldGenerator {
    public int CopperNodeSize = Config.CopperNodeSize * Config.OreNodeMultiplier;
    public int TinNodeSize = Config.TinNodeSize * Config.OreNodeMultiplier;
    public int SilverNodeSize = Config.SilverNodeSize * Config.OreNodeMultiplier;
    public int LeadNodeSize = Config.LeadNodeSize * Config.OreNodeMultiplier;
    public int NickelNodeSize = Config.NickelNodeSize * Config.OreNodeMultiplier;
    public int ChromiumNodeSize = Config.ChromiumNodeSize * Config.OreNodeMultiplier;
    public int AluminiumNodeSize = Config.AluminiumNodeSize * Config.OreNodeMultiplier;
    public int TitaniumNodeSize = Config.TitaniumNodeSize * Config.OreNodeMultiplier;
    public int PlatinumNodeSize = Config.PlatinumNodeSize * Config.OreNodeMultiplier;
    public int AventurineNodeSize = Config.AventurineNodeSize * Config.OreNodeMultiplier;
    public int RubyNodeSize = Config.RubyNodeSize * Config.OreNodeMultiplier;
    public int SapphireNodeSize = Config.SapphireNodeSize * Config.OreNodeMultiplier;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(!(chunkGenerator instanceof ChunkProviderEnd) && !(chunkGenerator instanceof ChunkProviderHell)){

            //copper
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(50);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(0), CopperNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //tin
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(56);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(1), TinNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Silver
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(2), SilverNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Lead
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(3), LeadNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Nickel
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(4), NickelNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Chromium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(20);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(5), ChromiumNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Aluminium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(48);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(6), AluminiumNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Titanium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(24);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(7), TitaniumNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Platinum
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(10);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(8), PlatinumNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Aventurine
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(9), AventurineNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Ruby
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(10), RubyNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }

            //Sapphire
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre.getStateFromMeta(11), SapphireNodeSize).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
            }
        }
    }
}

package HxCKDMS.HxCWorldGen.world;

import HxCKDMS.HxCWorldGen.Config;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

import static HxCKDMS.HxCWorldGen.registry.ModRegistry.blockOre;

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

                new WorldGenMinable(blockOre, 0, CopperNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //tin
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(56);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 1, TinNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Silver
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 2, SilverNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Lead
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 3, LeadNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Nickel
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 4, NickelNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Chromium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(20);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 5, ChromiumNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Aluminium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(48);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 6, AluminiumNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Titanium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(24);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 7, TitaniumNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Platinum
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(10);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 8, PlatinumNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Aventurine
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 9, AventurineNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Ruby
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 10, RubyNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Sapphire
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(blockOre, 11, SapphireNodeSize, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }
        }
    }
}

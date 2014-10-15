package kay.MoreWorldGen.world;

import cpw.mods.fml.common.IWorldGenerator;
import kay.MoreWorldGen.registry.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;

import java.util.Random;

public class OreGenHandler implements IWorldGenerator {
    public WorldGenerator CopperGen;
    public static final EventType EVENT_TYPE_COPPER = EnumHelper.addEnum(EventType.class, "COPPER", new Class[0], new Object[0]);
    public static final EventType EVENT_TYPE_TIN = EnumHelper.addEnum(EventType.class, "TIN", new Class[0], new Object[0]);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(!(chunkGenerator instanceof ChunkProviderEnd) && !(chunkGenerator instanceof ChunkProviderHell)){

            //copper
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(50);
                int randPosZ = (chunkZ*16) + random.nextInt(16);
                TerrainGen.generateOre(world, random, CopperGen, randPosX, randPosZ, EVENT_TYPE_COPPER);

                new WorldGenMinable(BlockRegistry.blockOre, 0, 6, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //tin
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(56);
                int randPosZ = (chunkZ*16) + random.nextInt(16);
                TerrainGen.generateOre(world, random, CopperGen, randPosX, randPosZ, EVENT_TYPE_TIN);

                new WorldGenMinable(BlockRegistry.blockOre, 1, 7, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Silver
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 2, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Lead
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 3, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Nickel
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(18);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 4, 2, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Chromium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(20);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 5, 3, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Aluminium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(48);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 6, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Titanium
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(24);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 7, 3, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Platinum
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(10);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 8, 1, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Aventurine
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 9, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Ruby
            for(int i = 0; i < 5; i++){
                int randPosX = (chunkX*16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ*16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 10, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }

            //Sapphire
            for(int i = 0; i < 5; i++) {
                int randPosX = (chunkX * 16) + random.nextInt(16);
                int randPosY = random.nextInt(28);
                int randPosZ = (chunkZ * 16) + random.nextInt(16);

                new WorldGenMinable(BlockRegistry.blockOre, 11, 4, Blocks.stone).generate(world, random, randPosX, randPosY, randPosZ);
            }
        }
    }
}

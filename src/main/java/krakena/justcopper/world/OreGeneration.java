package krakena.justcopper.world;

import krakena.justcopper.config.OregenConfig;
import krakena.justcopper.objectholder.JustCopperBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	public static void setupOreGeneration() {
		
		if (OregenConfig.generate_overworld.get()) {
			
			for(Biome biome : ForgeRegistries.BIOMES) {
				
				//biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, JustCopperBlocks.COPPER_ORE.getDefaultState(), OregenConfig.justcopper_chance.get())));
				int copperChance = OregenConfig.justcopper_chance.get();
				int copperSize = OregenConfig.justcopper_size.get();
				int copperMinHeight = OregenConfig.justcopper_minHeight.get();
				int copperMaxHeight = OregenConfig.justcopper_maxHeight.get();
				
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
								JustCopperBlocks.COPPER_ORE.getDefaultState(), copperSize), Placement.COUNT_RANGE, new CountRangeConfig(copperChance, copperMinHeight, 0, copperMaxHeight)));
			}
		}
	}
}

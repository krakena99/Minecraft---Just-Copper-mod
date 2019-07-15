package krakena.justcopper.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue justcopper_chance;
	public static ForgeConfigSpec.IntValue justcopper_size;
	public static ForgeConfigSpec.IntValue justcopper_minHeight;
	public static ForgeConfigSpec.IntValue justcopper_maxHeight;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Oregen Config");
		
		justcopper_chance = server
				.comment("Chance of copper ore spawning into the world.")
				.defineInRange("oregen.justcopper_chance", 42, 1, 100);
		
		justcopper_size = server
				.comment("The avarage size of copper ore veins.")
				.defineInRange("oregen.justcopper_size", 10, 1, 100);
				
		
		justcopper_minHeight = server
				.comment("The lowest level where copper ore would spawn.")
				.defineInRange("oregen.justcopper_minHeight", 1, 1, 256);

		justcopper_maxHeight = server
				.comment("The highest level where copper ore would spawn.")
				.defineInRange("oregen.justcopper_maxHeight", 92, 1, 256);
		
		generate_overworld = server
				.comment("Does copper ore spawn in the overworld?")
				.define("oregen.generate_overworld", true);
	}
}

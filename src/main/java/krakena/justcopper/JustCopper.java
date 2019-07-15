package krakena.justcopper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import krakena.justcopper.config.Config;
import krakena.justcopper.copperclasses.CopperArmorMaterial;
import krakena.justcopper.copperclasses.CopperTier;
import krakena.justcopper.items.ItemCopperArmor;
import krakena.justcopper.items.ItemCopperAxe;
import krakena.justcopper.items.ItemCopperHoe;
import krakena.justcopper.items.ItemCopperPickaxe;
import krakena.justcopper.items.ItemCopperShovel;
import krakena.justcopper.items.ItemCopperSword;
import krakena.justcopper.objectholder.JustCopperBlocks;
import krakena.justcopper.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("justcopper")
public class JustCopper {
	public static JustCopper INSTANCE;
	public static final String MODID = "justcopper";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final IItemTier COPPER = new CopperTier();
	public static final IArmorMaterial COPPER_ARMOR = new CopperArmorMaterial();
	
	public JustCopper() {
		INSTANCE = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("justcopper-client.toml").toString());
		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("justcopper-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup register works.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("Client register works.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("copper_ingot"),
					new BlockItem(JustCopperBlocks.COPPER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(JustCopperBlocks.COPPER_ORE.getRegistryName()),
					
					new ItemCopperPickaxe(COPPER, 2, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("copper_pickaxe"),
					new ItemCopperAxe(COPPER, 7.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("copper_axe"),
					new ItemCopperShovel(COPPER, 2.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("copper_shovel"),
					new ItemCopperHoe(COPPER, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("copper_hoe"),
					new ItemCopperSword(COPPER, 4, -1.6f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("copper_sword"),
					
					new ItemCopperArmor(COPPER_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("copper_helmet"),
					new ItemCopperArmor(COPPER_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("copper_chestplate"),
					new ItemCopperArmor(COPPER_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("copper_leggings"),
					new ItemCopperArmor(COPPER_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("copper_boots")
				);
			
			LOGGER.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.METAL)).setRegistryName("copper_ore")
				);
			
			LOGGER.info("Blocks registered.");
		}

	}
}

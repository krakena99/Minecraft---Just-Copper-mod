package krakena.justcopper.copperclasses;

import krakena.justcopper.objectholder.JustCopperItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class CopperTier implements IItemTier {

	@Override
	public float getAttackDamage() {
		return 0;
	}

	@Override
	public float getEfficiency() {
		return 8;
	}

	@Override
	public int getEnchantability() {
		return 17;
	}

	@Override
	public int getHarvestLevel() {
		return 1;
	}

	@Override
	public int getMaxUses() {
		return 142;
	}
	
	@Override
	public Ingredient getRepairMaterial() {
	      return Ingredient.fromItems(JustCopperItems.COPPER_INGOT);
	}

    
}

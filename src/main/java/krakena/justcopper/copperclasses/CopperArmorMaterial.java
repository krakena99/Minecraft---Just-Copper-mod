package krakena.justcopper.copperclasses;

import krakena.justcopper.objectholder.JustCopperItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class CopperArmorMaterial implements IArmorMaterial {
	private int[] damageReductionArr = new int[]{1, 4, 6, 2};
	private int[] durabilityArr = new int[]{144, 166, 177, 122};

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return damageReductionArr[slotIn.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return durabilityArr[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return 17;
	}

	@Override
	public String getName() {
		return "copper";
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(JustCopperItems.COPPER_INGOT);
	}

	@Override
	public SoundEvent getSoundEvent() {
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}

	@Override
	public float getToughness() {
		return 0;
	}
}

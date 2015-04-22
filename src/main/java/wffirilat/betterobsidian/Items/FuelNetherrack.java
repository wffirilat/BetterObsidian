package wffirilat.betterobsidian.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelNetherrack implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == Item.getItemFromBlock(Blocks.netherrack)){
			return 480000;
		}
		return 0;
	}

}

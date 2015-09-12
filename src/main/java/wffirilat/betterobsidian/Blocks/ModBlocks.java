package wffirilat.betterobsidian.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import wffirilat.betterobsidian.Constants;

public class ModBlocks {

	public static Block cobblesidian;

	public static void init() {

		cobblesidian = new Cobblesidian().setHardness(35.0F).setResistance(1500.0F);

	}

	public static void registerRenderers() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		renderItem.getItemModelMesher().register(Item.getItemFromBlock(cobblesidian), 0, new ModelResourceLocation(Constants.MODID + ":" + ((Cobblesidian) cobblesidian).name, "inventory"));
	}

}

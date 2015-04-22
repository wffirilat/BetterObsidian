package wffirilat.betterobsidian.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import wffirilat.betterobsidian.Blocks.ModBlocks;
import wffirilat.betterobsidian.Mobs.FlameGhast;
import wffirilat.betterobsidian.Mobs.ModelVoidling;
import wffirilat.betterobsidian.Mobs.RenderFlameGhast;
import wffirilat.betterobsidian.Mobs.RenderVoidling;
import wffirilat.betterobsidian.Mobs.Voidling;
import wffirilat.betterobsidian.Renderer.ItemRendererObsidianChest;
import wffirilat.betterobsidian.Renderer.ObsidianChestRenderer;
import wffirilat.betterobsidian.tileEntity.TileEntityObsidianChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Voidling.class, new RenderVoidling(new ModelVoidling(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(FlameGhast.class, new RenderFlameGhast());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianChest.class, new ObsidianChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.obsidianChest), new ItemRendererObsidianChest());
	}
}
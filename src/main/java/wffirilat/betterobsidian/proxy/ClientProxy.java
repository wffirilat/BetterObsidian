package wffirilat.betterobsidian.proxy;

import wffirilat.betterobsidian.Mobs.ModelVoidling;
import wffirilat.betterobsidian.Mobs.RenderVoidling;
import wffirilat.betterobsidian.Mobs.Voidling;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Voidling.class, new RenderVoidling(new ModelVoidling(), 0.5F));
	}
}
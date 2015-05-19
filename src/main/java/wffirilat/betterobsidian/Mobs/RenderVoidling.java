package wffirilat.betterobsidian.Mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import wffirilat.betterobsidian.lib.Constants;

public class RenderVoidling extends RenderBiped {

	private static final ResourceLocation textureLocation = new ResourceLocation(Constants.MODID + ":" + "textures/models/entityVoidling.png");

	public RenderVoidling(ModelBiped model, float shadowSize) {
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return textureLocation;
	}
}
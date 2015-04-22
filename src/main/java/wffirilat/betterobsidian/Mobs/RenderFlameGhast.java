package wffirilat.betterobsidian.Mobs;

import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;
import wffirilat.betterobsidian.lib.Constants;

public class RenderFlameGhast extends RenderGhast {
	private static final ResourceLocation ghastTextures = new ResourceLocation(Constants.MODID + ":" + "textures/models/flameGhast.png");
	private static final ResourceLocation ghastShootingTextures = new ResourceLocation(Constants.MODID + ":" + "textures/models/flameGhast_shooting.png");

	protected ResourceLocation getEntityTexture(EntityGhast p_110775_1_) {
		return p_110775_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
	}
}

package wffirilat.betterobsidian;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import wffirilat.betterobsidian.blocks.ModBlocks;
import wffirilat.betterobsidian.events.ModEvents;
import wffirilat.betterobsidian.items.ModItems;
import wffirilat.betterobsidian.items.recipes.ModRecipes;


@Mod(modid = "betterobsidian")
public class BetterObsidian {
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	ModItems.init();
    	ModBlocks.init();
    	ModEvents.init();
    	ModRecipes.init();
    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
    	if(event.getSide() == Side.CLIENT) {
    		ModItems.registerRenderers();
    		ModBlocks.registerRenderers();
    	}
	}

}
